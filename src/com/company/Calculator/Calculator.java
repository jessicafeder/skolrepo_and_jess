package com.company.Calculator;

import java.util.Scanner;

public class Calculator {
    public int add(int a, int b) {
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }

    public int div(int a, int b) {
        return a/b;
    }

    public int mod(int a, int b) {
        return a%b;
    }


    public static void main(String[] args) {
        int a, b;
        String method;
        Calculator calc = new Calculator();
        System.out.println("Welcome to the Calculator!");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            a = sc.nextInt();
            method = sc.next();
            b = sc.nextInt();
            if(method.equals("+")) {
                System.out.println("The answer is: " + calc.add(a,b));

            }else if(method.equals("-")){
                System.out.println("The answer is: " + calc.sub(a,b));

            }else if(method.equals("%")) {
                System.out.println("The answer is: " + calc.mod(a,b));

            }else if(method.equals("/")){
                System.out.println("The answer is: " + calc.div(a,b));

            } else if (method.equals(">")) {
                System.out.println("The answer is: " + Math.max(a,b));

            } else if (method.equals("<")) {
                System.out.println("The answer is: " + Math.min(a, b));
            }
            else {
                System.out.println("The method of calculation is not supported yet");
            }

        }

    }

    public int max(int a, int b) {
        if(a > b) {
            return a;
        }else
            return b;
    }
}