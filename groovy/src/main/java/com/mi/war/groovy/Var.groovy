package com.mi.war.groovy

def x1 = 333
def x2 = 3.33
def x3 = "wjh"
println x1.class
println x2.class
println x3.class

def method(Object o) {
    println 1
}

def method(String s) {
    println 2
}

Object o = "Object"
method(o)