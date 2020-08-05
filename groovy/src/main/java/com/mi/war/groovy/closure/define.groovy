package com.mi.war.groovy.closure

/** 无参 */
def noParam = { -> println '无参闭包'}

def oneParam_1 = {println "this is $it!"}

Closure oneParam_2 = {it -> println "$it is same as oneParam_1!"}

Closure oneParam_3 = {String msg -> println "$msg is same as oneParam_1!"}

Closure<Boolean> twoParams = {String name, int num ->
    println "Hi, $name! This is a closure that contains $num paramaters."
}

assert noParam instanceof Closure
oneParam_1('test1')
oneParam_2('test2')
oneParam_3('test3')
twoParams.call("Wang Jiahui", 2)