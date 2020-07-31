package com.mi.war.groovy

import groovy.transform.Field

@Field FILE_DIR = '/home/mi'
@Field FILE_NAME = '常用命令.txt'
void readFile() {
    /** 文件操作 */
    new File(FILE_DIR, FILE_NAME).eachLine { line, lineNum ->
        println "第${lineNum}行： ${line?:'内容为空'}"
    }
}

new File(FILE_DIR, FILE_NAME).withWriter {
    it.write('git rebase -i HEAD~2 修改多个改动')
    it.close()
}

readFile()

new File(FILE_DIR, FILE_NAME) << '''
git reset --hard HEAD^ 撤销最近的改动
git remote add origin [url]
git remote rm origin
git remote set-url origin [url]
'''

readFile()

new File(FILE_DIR, FILE_NAME).withOutputStream { os ->
    os.write(1)
}

readFile()

def ips = new File(FILE_DIR, FILE_NAME).newInputStream()
