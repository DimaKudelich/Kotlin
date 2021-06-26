package com.kudelich.exercises

fun conditionalStatements(){
    /*
    if-else
    when (equals to switch in Java)

    in if-else statement as a condition can be: >,<,>=,<=,==,!=,||,&&
    in when statement we use "->" as case (in switch construction), "else" for not found values
    */

    var a = 5
    if(a>2){
        println("Greater then 2")
    }else if(a == 5){
        println("Equals to 2")
    } else{
        println("Less then 2")
    }

    when(a){
        1->
            println("Equals to 1")
        2->
            println("Equals to 2")
        else->
            println("Can't find coincidences")
    }
}