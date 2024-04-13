package backend

abstract class Data(val type: DataType)

enum class DataType {
    INT,
    DOUBLE,
    STRING,
    BOOLEAN,
    FUNCTION,
    NONE
}

object None:Data(DataType.NONE) {
    override fun toString() = "None"
}

// Each of these sub-classes of Data will override the toString() function to provide a string representation some data.
class IntData(val value:Int): Data(DataType.INT) {
    override fun toString(): String = "$value"
}

class DoubleData(val value: Double): Data(DataType.DOUBLE) {
    override fun toString(): String = "$value"
}

class StringData(val value: String): Data(DataType.STRING) {
    override fun toString(): String = "$value"
}

class BooleanData(val value:Boolean): Data(DataType.BOOLEAN) {
    override fun toString() = "$value"
}

class FuncData(
    val name: String,
    val params: List<FuncArg>,
    val body: Expr
): Data(DataType.FUNCTION) {
    override fun toString()
    = params.joinToString(", ").let {
        "$name($it) { ... }"
    }
}

data class FuncArg(val type: String, val name: String) {
    fun getType(): DataType = DataType.valueOf(type.uppercase())
}
