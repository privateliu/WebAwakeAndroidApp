package com.je.xwsgame.lesson

import org.json.JSONObject

fun main() {
    //kotlin数组
    //数组里面的值可以是任意类型
    val arrayNumber:Array<Any> = arrayOf(1,true,"ss")
    val test = arrayNumber.get(1)

    var arrayNumber1:Array<Int> = arrayOf(2,1)
    var arrayIfNull:Array<String?> = arrayOfNulls<String>(5)
    arrayIfNull[1] = "ss"
    val asc = Array(5){i:Int ->(i*i).toString()}
    val asc1 = ByteArray(5)

    for (item in arrayNumber){
        println(item.toString())
    }
    for (i in arrayNumber.indices){
        println(arrayNumber[i].toString())
    }
    arrayNumber.forEach {
        println(it.toString())
    }

    val array = mutableListOf<String>()
    array.add("ss")
    array.count()
    val array1 = listOf<String>()

    val map = mutableMapOf<Int,String>()
    map[2] = "ss"

    val map1 = mapOf<String,String>(Pair("key","value"), Pair("22","ff"))
    println(map1["22"])

    //跟list区别 不可以有相同的元素
    val set = mutableSetOf<Int>()
    set.add(1)
    val set1 = setOf<Int>(1,2,2)
    for (item in set1){
        println("set${item.toString()}")
    }

    val test4:String = learn(11,22,testFun = {Persion("xiangwenshi").test()}).toString()
    println("打印方法返回值${test4}")
    Persion("项文师").test()
    Persion("项文师").test()
    Persion1.test()
}

fun learn(a:Int,b:Int,testFun:() -> String):Boolean{
    return a > b
}

//普通类
class Persion constructor(name:String){
    var myname:String = ""
    init {
        myname = name;
    }
    fun test():String{
        println("调用类里面的方法${myname}")
        return "faff"
    }
}


//静态类
object Persion1{
    fun test(){
        println("调用类里面的方法")
    }
}