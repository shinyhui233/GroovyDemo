package com.mi.war.groovy

import org.codehaus.groovy.runtime.InvokerHelper

class MyMetaClass extends MetaClassImpl {

    MyMetaClass(Class theClass) {
        super(theClass)
    }

    Object invokeMethod(Object object, String methodName, Object[] arguments){
        "MyMetaClass: ${super.invokeMethod(object, methodName, arguments)}"
    }

}

class Person {
    String name
    Integer age
//    Person(String name) {
//        this.name = name
//    }

    @Override
    Object invokeMethod(String s, Object o) {
        return  "call invokeMethod: $s, $o"
    }

    def methodMissing(String s, Object o) {
        return  "call methodMissing: $s, $o"
    }
}

// rookie = new Person("wjh")
def meta = new MyMetaClass(Person)
meta.initialize()
//rookie.metaClass = meta
//rookie.metaClass.speak = {msg -> "call metaClass: $msg"}
//println rookie.speak("have meat? speak louder")

Person.metaClass.constructor = {String name, int age -> new Person(name:name, age:age)}
//InvokerHelper.metaRegistry.setMetaClass(Person, meta)
def passersby = new Person("war", 26)
println "$passersby.name is $passersby.age"
