package com.BalancingBrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
        public static boolean balancedOrNot(String inputStr) {
            Stack stack = new Stack();
            char[] charArray = inputStr.toCharArray();
            for (char current : charArray) {
                if (current == '{' || current == '[' || current == '(') {
                    stack.push(current);
                    continue;
                }
                if (stack.isEmpty()) {
                    return false;
                }

                char popChar;
                switch (current) {
                    case ')' -> {
                        popChar = (char) stack.pop();
                        if (popChar == '{' || popChar == '[')
                            return false;
                    }
                    case '}' -> {
                        popChar = (char) stack.pop();
                        if (popChar == '(' || popChar == '[')
                            return false;
                    }
                    case ']' -> {
                        popChar = (char) stack.pop();
                        if (popChar == '(' || popChar == '{')
                            return false;
                    }
                }
            }
            return (stack.isEmpty());
        }

        public static void main(String[] args) {
            String inputStr;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the sample input:");
            inputStr = sc.nextLine();
            sc.close();


            if (balancedOrNot(inputStr))
                System.out.println("The entered String has Balanced Brackets.");
            else
                System.out.println("The entered Strings do not contain Balanced Brackets.");
        }
}