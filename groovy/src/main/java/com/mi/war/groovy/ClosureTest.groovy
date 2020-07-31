package com.mi.war.groovy

import groovy.transform.Field


/** 无参 */
def noParam = { -> println '无参闭包'}

def oneParam_1 = {println "$it is same as oneParam_2!"}

Closure oneParam_2 = {it -> println "$it is same as oneParam_1!"}

Closure oneParam_3 = {String msg -> println msg}

Closure<Boolean> twoParams = {String name, int num ->
    println "Hi, $name! This is a closure that contains $num paramaters."
    name.equalsIgnoreCase('Wang Jiahui')
}

assert  noParam instanceof Closure
oneParam_1('test2')
oneParam_2('test3')
oneParam_3('this is same as the above two!')
twoParams.call("Wang Jiahui",2)


class Enclosing {
    void run() {
        def whatIsThisObject = {getThisObject()}
        assert whatIsThisObject() == this
        def whatIsThis = {this}
        assert whatIsThis() == this
    }
}

class EnclosingInnerClass {
    class Inner {
        def cl = {this}
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

class NestedInClosure {
    void run() {
        def nestClosures = {
            def inner = {this}
            inner()
        }
        assert  nestClosures() == this
    }
}

new Enclosing().run()
new EnclosingInnerClass().run()
new NestedInClosure().run()

class EnclosingOwner {
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }
}

class EnclosingInnerClassOwner {
    class Inner {
        def cl = {owner}
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

class NestedInClosureOwner {
    void run() {
        def nestClosures = {
            def inner = {owner}
            inner()
        }
        assert  nestClosures() == nestClosures
    }
}

new EnclosingOwner().run()
new EnclosingInnerClassOwner().run()
new NestedInClosureOwner().run()

class Priority {
    String priority_level
    class Inner {
        String priority_level
    }


}

def fib
fib = { long n -> n < 2 ? n : fib(n - 1) + fib(n - 2)}.memoize()
def start = System.currentTimeMillis()
fib(25)
def end = System.currentTimeMillis()
println "time cost: ${end - start} ms"