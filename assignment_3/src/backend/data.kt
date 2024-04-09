package backend

abstract class Data

object None:Data() {
    override fun toString() = "None"
}

// Each of these sub-classes of Data will override the toString() function to provide a string representation some data.
class IntData(val value:Int): Data() {
    override fun toString(): String = "$value"
}

class StringData(val value: String) : Data() {
    override fun toString(): String = "$value"
}

class BooleanData(val value:Boolean): Data() {
    override fun toString() = "$value"
}

class FunctionData(private val function: () -> Any) : Data() {
    override fun toString(): String = "Function: ${function::class.simpleName}"
}