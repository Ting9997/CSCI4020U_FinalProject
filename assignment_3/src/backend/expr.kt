package backend

enum class Operator {
    Add,
    Sub,
    Mul,
    Div
}

enum class Comparator {
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
}

abstract class Expr(val type: DataType){
    abstract fun eval(runtime:Runtime):Data
}

class NoneExpr(): Expr(DataType.NONE) {
    override fun eval(runtime:Runtime) = None
}

class IntLiteral(val lexeme: String) : Expr(DataType.INT) {
    override fun eval(runtime: Runtime): Data = IntData(lexeme.toInt())
}
    
class DoubleLiteral(val lexeme: String) : Expr(DataType.DOUBLE) {
    override fun eval(runtime: Runtime): Data = DoubleData(lexeme.toDouble())
}

class StringLiteral(val lexeme: String) : Expr(DataType.STRING) {
    override fun eval(runtime: Runtime): Data = StringData(lexeme.substring(1, lexeme.length-1))
}

class BooleanLiteral(val lexeme: String) : Expr(DataType.BOOLEAN) {
    override fun eval(runtime: Runtime): Data = BooleanData(lexeme.equals("true"))
}

class Deref(val name:String): Expr(DataType.NONE) {
    override fun eval(runtime:Runtime):Data {
        val data = runtime.symbolTable[name]
        if(data == null) {
            throw Exception("$name is not assigned.")
        }
        return data
    }
}

class Initialize(val typeName: String, val name: String, val expression: Expr) : Expr(DataType.valueOf(typeName.uppercase())) {
    override fun eval(runtime: Runtime): Data {
        if (runtime.isValidType(typeName)) {
            runtime.symbolTypes.put(name, DataType.valueOf(typeName.uppercase()))
            return expression.eval(runtime).apply { runtime.symbolTable.put(name, this)}
        } else throw Exception("Invalid type")
    }
}

class Assignment(val name: String, val expression: Expr) : Expr(DataType.NONE) {
    override fun eval(runtime: Runtime): Data {
        if (runtime.symbolTable.containsKey(name)) {
            val retData = expression.eval(runtime)
            if (retData.type == runtime.symbolTypes[name]) {
                runtime.symbolTable.put(name, retData)
                return retData
            } else throw Exception("$name is not of type ${retData.type}")
        } else throw Exception("$name has not been defined")
    }

}

class Arithmetics(
    val op: Operator,
    val left: Expr,
    val right: Expr
) : Expr(DataType.NONE) {
    override fun eval(runtime: Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        return when {
            x is IntData && y is IntData -> evaluateIntOperation(x, y)
            x is StringData && y is StringData -> evaluateStringOperation(x, y)
            x is DoubleData && y is DoubleData -> evaluateDoubleOperation(x, y)
            x is DoubleData && y is IntData -> evaluateMixedOperation(x, y)
            x is IntData && y is DoubleData -> evaluateMixedOperation(y, x)
            x is StringData && y is IntData -> multiplyStringOperation(x, y)
            x is IntData && y is StringData  -> multiplyStringOperation(y, x)
            else -> throw Exception("Unsupported operation")
        }
    }
    
    
    private fun evaluateIntOperation(x: IntData, y: IntData): Data {
        return IntData(
            when (op) {
                Operator.Add -> x.value + y.value
                Operator.Sub -> x.value - y.value
                Operator.Mul -> x.value * y.value
                Operator.Div -> {
                    if (y.value != 0) {
                        x.value / y.value
                    } else {
                        throw Exception("cannot divide by zero")
                    }
                }
            }
        )
    }
    
    private fun evaluateDoubleOperation(x: DoubleData, y: DoubleData): Data {
        return DoubleData(
            when (op) {
                Operator.Add -> x.value + y.value
                Operator.Sub -> x.value - y.value
                Operator.Mul -> x.value * y.value
                Operator.Div -> {
                    if (y.value != 0.0) {
                        x.value / y.value
                    } else {
                        throw Exception("cannot divide by zero")
                    }
                }
            }
        )
    }
    
    private fun evaluateMixedOperation(x: DoubleData, y: IntData): Data {
        return DoubleData(
            when (op) {
                Operator.Add -> x.value + y.value
                Operator.Sub -> x.value - y.value
                Operator.Mul -> x.value * y.value
                Operator.Div -> {
                    if (y.value != 0) {
                        x.value / y.value
                    } else {
                        throw Exception("cannot divide by zero")
                    }
                }
            }
        )
    }



    private fun evaluateStringOperation(x: StringData, y: StringData): Data {
        return StringData(
            when (op) {
                Operator.Add -> x.value + y.value
                else -> throw Exception("Unsupported string operation")
            }
        )
    }
    
    private fun multiplyStringOperation(x: StringData, y: IntData): Data {
        return StringData(
            when (op) {
                Operator.Mul -> x.value.repeat(y.value)
                else -> throw Exception("Unsupported string and int operation")
            }
        )
    }

}

class Loop(val variable: String, val start: Expr, val end: Expr, val block: Expr) : Expr(DataType.NONE) {
    override fun eval(runtime: Runtime): Data {
        var result: Data
        val loopStart: Int
        val loopEnd: Int
        
        result = start.eval(runtime)
        if (result is IntData){
            loopStart = result.value
        }
        else throw Exception("Start not valid")
        
        result = end.eval(runtime)
        if (result is IntData){
            loopEnd = result.value
        }
        else throw Exception("End not valid")
        
        result = None
        for (i in loopStart..loopEnd) {
            runtime.symbolTable[variable] = IntData(i)
            result = block.eval(runtime)
        }
        return result
    }
}

class Block(val statements: List<Expr>) : Expr(DataType.NONE) {
    override fun eval(runtime: Runtime): Data {
        var result: Data = None
        for (statement in statements) {
            result = statement.eval(runtime)
        }
        return result
    }
}

class Invoke(val name:String, val args:List<Expr>):Expr(DataType.NONE) {
    override fun eval(runtime:Runtime):Data {
        val func:Data? = runtime.symbolTable[name]
        if(func == null) {
            throw Exception("$name does not exist")
        }
        if(func !is FuncData) {
            throw Exception("$name is not a function.")
        }
        if(func.params.size != args.size) {
            throw Exception(
                "$name expects ${func.params.size} arguments "
                + "but received ${args.size}"
            )
        }
        
        val r = runtime.subscope(
            func.params.zip(args.map {it.eval(runtime)}).toMap()
        )
        val retVal = func.body.eval(r)
        if (retVal.type != runtime.symbolTypes[name]) throw Exception("$name's return value is not returning a value of type ${runtime.symbolTypes[name]}")
        return retVal
    }
}

class Print(val expression: Expr) : Expr(DataType.FUNCTION) {
    override fun eval(runtime: Runtime): Data {
        val result = expression.eval(runtime)
        println(result)
        return None
    }
}

class Declare(
    val name: String,
    val params: List<FuncArg>,
    val body: Expr,
    val typeName: String
): Expr(DataType.NONE) {
    override fun eval(runtime:Runtime):Data
    { 
        runtime.symbolTypes.put(name, DataType.valueOf(typeName.uppercase()))
        return FuncData(name, params, body).also {
            runtime.symbolTable[name] = it
        }
    }
}

class Ifelse(
    val cond:Expr,
    val trueExpr:Expr,
    val falseExpr:Expr
): Expr(DataType.NONE) {
    override fun eval(runtime:Runtime): Data {
        val cond_data = cond.eval(runtime)
        if(cond_data !is BooleanData) {
            throw Exception("need boolean data in if-else")
        }
        if(cond_data.value) {
            return trueExpr.eval(runtime)
        } else {
            return falseExpr.eval(runtime)
        }
    }
}

class Compare(
    val comparator: Comparator,
    val left: Expr,
    val right: Expr
): Expr(DataType.NONE) {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        if(x is IntData && y is IntData) {
            return BooleanData(
                when(comparator) {
                    Comparator.LT -> x.value < y.value
                    Comparator.LE -> x.value <= y.value
                    Comparator.GT -> x.value > y.value
                    Comparator.GE -> x.value >= y.value
                    Comparator.EQ -> x.value == y.value
                    Comparator.NE -> x.value != y.value
                }
            )
        } else {
            throw Exception("Non-integer data in comparison")
        }
    }
}