package com.mi.war.groovy.closure

import java.awt.image.BufferStrategy

class Thing {
    String name
    Thing(String name) {
        this.name = name
    }
    def closure = {
        println "name is $name"
    }
}

class Earphone {
    String name
    Earphone(String name) {
        this.name = name
    }
}

def p = new Thing('thing')
def t = new Earphone('earphone')
p.closure()
p.closure.delegate = t
p.closure()
p.closure.resolveStrategy = Closure.DELEGATE_FIRST
p.closure()