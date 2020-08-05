package com.mi.war.groovy

import org.codehaus.groovy.runtime.InvokerHelper

class MyMetaClass extends DelegatingMetaClass {

    MyMetaClass(Class theClass) {
        super(theClass)
    }

    Object invokeMethod(Object object, String methodName, Object[] arguments){
        "MyMetaClass: ${super.invokeMethod(object, methodName, arguments)}"
    }

    @Override
    Object invokeMissingMethod(Object instance, String methodName, Object[] arguments) {
        return super.invokeMissingMethod(instance, methodName, arguments)
    }
}

class Person {
    String name
    Integer age

//    def speak(String msg) {
//        "speak by myself: $msg"
//    }

    @Override
    Object invokeMethod(String s, Object o) {
        return  "call invokeMethod: $s, $o"
    }

    def methodMissing(String s, Object o) {
        return  "call methodMissing: $s, $o"
    }
}

def rookie = new Person()
def meta = new MyMetaClass(Person)
//meta.initialize()
rookie.metaClass = meta
println rookie.speak("have meat? speak louder")

InvokerHelper.metaRegistry.setMetaClass(Person, meta)

def noob = new Person()
println noob.speak("the early birds eats the worm.")

//rookie.metaClass.speak = {msg -> "call metaClass: $msg"}

//Person.metaClass.constructor = {String name, int age -> new Person(name:name, age:age)}
//def passersby = new Person("war", 26)
//println "$passersby.name is $passersby.age"
