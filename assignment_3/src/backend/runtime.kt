package backend

class Runtime() {
    val symbolTable:MutableMap<String, Data> = mutableMapOf()
    val symbolTypes:MutableMap<String, DataType> = mutableMapOf()
    val types: List<String> = DataType.values().map {it.toString()}

    fun subscope(bindings:Map<String, Data>):Runtime {
        val parentSymbolTable = this.symbolTable
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(bindings)
        }
    }
    
    fun isValidType(typeString: String): Boolean {
        for (type in types) {
            if (type.equals(typeString, true)) return true
        }
        return false
    }

    override fun toString():String =
        symbolTable.map { 
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
}


