package com.mi.war.groovy

import groovy.transform.Field

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