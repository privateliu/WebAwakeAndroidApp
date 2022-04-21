package com.je.xwsgame.lesson

//kotlin数据类型
fun main() {

    /**
     * 什么是位宽（bit） 计算机中最小数据存储单位
     * 1.在计算机当中 所有数字在存储的时候 都是二进制存储
     * 二进制八位称为1个字节
     * int数据类型占了4个字节 4*8 = 32 long 占了8个字节
     *
     */
    val number = 100//编辑器会根据赋值，推断数据类型 这个number 是int 以为没超过int的最大值
    val bigNumber = 80000000 //long类型
    val longNUmber = 20L
    val intNumber:Int = 1
    val byteNumber:Byte = 1

    //浮点类型
    val doubleNumber = 3.1412334//double 32
    val foubleNumber = 3.1412334f//float 64

    println("foubleNumber: = "+doubleNumber);

    //字符类型声明
    var char:Char = '0'
    var istest:Boolean = false
    var istest1 = false
    var str = "1211111111"
    println("str[1]: = "+str[1].toString());
    println("the result is $str")
    println("the result length ${str.length}")
    val helloworld4 = """
        
    """.trimIndent()

    val numberInt:Int = 3/2  //输出1

    val numberDouble = 3/2.toDouble()//输出1.5
}