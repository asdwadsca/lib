package com.asdwadsca;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static boolean test(String name){
        if (Objects.equals(name, "1")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.printf(String.valueOf(test(new Scanner(System.in).nextLine())));
    }
}