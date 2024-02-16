package com.culfoshe.config.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    public static int [] intArr= {72,2,3,4,5,22,33,44,55,66,77};
    public static void main(String[] args) {
        int[] intArrCopy = intArr;
        String str = new String(intArrCopy, 0, 9);
        System.err.println(str);
    }
}
