package backend

abstract class Data(val type: DataType)

enum class DataType {
    INT,
    FLOAT,
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

class FloatData(val value: Float): Data(DataType.FLOAT) {
    override fun toString(): String = value.toString()
}

class StringData(val value: String): Data(DataType.STRING) {
    override fun toString(): String = "$value"
}

class BooleanData(val value:Boolean): Data(DataType.BOOLEAN) {
    override fun toString() = "$value"
}

class FunctionData(private val function: () -> Any): Data(DataType.FUNCTION) {
    override fun toString(): String = "Function: ${function::class.simpleName}"
}


