package com.mi.war.groovy

import groovy.transform.Field

def name = 'Wang Jiahui'
assert name instanceof String

def name1 = "wangjiahui"
assert name1 instanceof String

/** 斜杠字符串 */
def slashStr = /one
${name}
two
three/
assert slashStr instanceof groovy.lang.GString

/** 三引号定义字符串 */
def quotationMark = '''one
two
three'''
assert quotationMark instanceof String


/** GString与String哈希值的区别 Start */

def n = {name}
def map = [(n): 1, "wjh": 2]
println map[name]
println map[(n)]

/** GString与String哈希值的区别 END */

/** GString惰性求值 Start */
def name2 =  "My name is $name."
println name2

name = "wjh"
println name2

def x = 1
def gs = "x = ${ -> x}"
assert gs == "x = 1"

x = 2
assert gs == "x = 2"
/** GString惰性求值 END */


def oneParamsClosure = "1 + 2 = ${w ->  w << 3}"
assert oneParamsClosure == '1 + 2 = 3'
groovy.lang.GString


//def cmdLine = "ls -l".execute()
//cmdLine.inputStream.eachLine {
//    println it
//}