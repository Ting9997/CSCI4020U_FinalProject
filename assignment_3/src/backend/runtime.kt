package backend

class Runtime() {
    val symbolTable:MutableMap<String, Data> = mutableMapOf()
    val symbolTypes:MutableMap<String, DataType> = mutableMapOf()
    val types: List<String> = DataType.values().map {it.toString()}

    fun subscope(bindings:Map<FuncArg, Data>):Runtime {
        val parentSymbolTable = this.symbolTable
        val parentSymbolTypes = this.symbolTypes
        var newBindings:MutableMap<String, Data> = mutableMapOf()
        var typeBindings:MutableMap<String, DataType> = mutableMapOf()
        for (entry in bindings.entries.iterator()) {
            if (entry.key.getType() != entry.value.type) throw Exception("${entry.value} is not of type ${entry.key.type}")
            newBindings.put(entry.key.name, entry.value)
            typeBindings.put(entry.key.name, entry.key.getType())
        }
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(newBindings)
            symbolTypes.putAll(parentSymbolTypes)
            symbolTypes.putAll(typeBindings)
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


