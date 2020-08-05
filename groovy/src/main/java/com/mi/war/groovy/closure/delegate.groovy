package com.mi.war.groovy.closure


class Outer {
    def outerThis = { getThisObject() }
    def outerOwner = { getOwner() }
    def outerDelegate = { getDelegate() }

    class Inner {
        def innerThis = {this}
        def innerOwner = { owner }
        def innerDelegate = { delegate }
    }

    void run() {
        println "this is ${outerThis()} in the top-level class"
        println "owner is ${outerOwner()} in the top-level class"
        println "delegate is ${outerDelegate()} in the top-level class"
        println '-------------------------------'

        def inner = new Inner()

        assert inner.innerThis() == inner
        assert inner.innerOwner() == inner
        assert inner.innerDelegate() == inner
        println "this is ${inner.innerThis()} in the enclosing class"
        println "owner is ${inner.innerOwner()} in the enclosing class"
        println "delegate is ${inner.innerDelegate()} in the enclosing class"
        println '-------------------------------'

        def nestClosures = {
            def innerClosureThis = {println this}
            innerClosureThis()
            def innerClosureOwner = {println owner}
            innerClosureOwner()
            def innerClosureDelegate = {println delegate}
            innerClosureDelegate()
        }
        nestClosures()
    }
}

def outer = new Outer()
outer.run()