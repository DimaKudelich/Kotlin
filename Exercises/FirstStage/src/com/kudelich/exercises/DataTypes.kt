package com.kudelich.exercises

fun dataTypes(){
    /*
    Integers: short, ushort, int, uint, long, ulong
    Dotted: float, double
    Another: boolean, string, char

    var - variable, val - const
    Also we can use sign '?' in variable initialisation. It shows that this variable may have specified type
    or can be null
    */

    var integer: Int = 10
    integer = 20

    var float: Float = 5.1f
    var double: Double = 5.1

    var string: String = "string"
    var char: Char = 'c'

    var is_null: Int? = null

    println("Value: $integer")
}
