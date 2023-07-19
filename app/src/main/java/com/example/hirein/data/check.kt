package com.example.hirein.data

open class check( val a :Int, val  b:Int)

class doubleCheck (a:Int, b:Int, val c:Int): check(a,b)

fun main(){
    val d = doubleCheck(1,2,3)
    val a :check = d as check

}