package com.mi.war.groovy

import groovy.transform.Field

def name = 'Wang Jiahui'
assert name instanceof String

def name1 = "wangjiahui"
assert name1 instanceof String

def name2 =  "My name is ${name}."
assert name2 instanceof groovy.lang.GString

def x = 1
def gs = "x = ${ -> x}"
assert gs == "x = 1"

x = 2
assert gs == "x = 2"


def escape = /the character \/ is a forward slash/
println (escape == 'the character / is a forward slash')

def sParameterLessClosure = "1 + 2 == ${-> 3}"
println sParameterLessClosure == '1 + 2 == 3'


def oneParamsClosure = "1 + 2 = ${w ->  w << 3}"
println oneParamsClosure == '1 + 2 = 3'


/** 斜杠字符串 */
def slashStr = /one
two
three/
assert slashStr instanceof String

/** 引号定义字符串 */
def quotationMark = '''one
two
three'''
assert quotationMark instanceof String

println slashStr
println quotationMark

//def cmdLine = "ls -l".execute()
//cmdLine.inputStream.eachLine {
//    println it
//}