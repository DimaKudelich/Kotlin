package com.kudelich.exercises

/*
    Functions are being created with key word "fun". Every function can have (or not have) parameters.
    We indicate them between "(" and ")".
    Between "{" and "}" we write a body of our function.
    Function can return some values in result. In this case in the end of fun we write "return". Also we should write after
    out parameters ":" and "dataType". It means that our fun return value with type "dataType"
    !Type Unit - equals to Void in Java!
*/

fun add(x: Int, y: Int):Int{
    return x+y
}

fun printText(string: String):Unit{
    println(string)
}

fun saySomething(param: Int):String = "Hello world $param"

fun main(){
    println(add(1,2))
    printText("Text")
    println(saySomething(2))
}