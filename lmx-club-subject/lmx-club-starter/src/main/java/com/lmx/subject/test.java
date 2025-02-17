package com.lmx.subject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class test {

        private static final Logger logger = LogManager.getLogger(test.class);

    public static void main(String[] args) {
        System.out.println("\u001B[31m红色文本\u001B[0m");
        System.out.println("\u001B[32m绿色文本\u001B[0m");
        System.out.println("\u001B[33m黄色文本\u001B[0m");
    }
}
