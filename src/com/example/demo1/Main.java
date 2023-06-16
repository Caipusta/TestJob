package com.example.demo1;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            System.out.println("Method clac returned " + calc(input));
        }
    }
    public static String calc(String  input) throws Exception {
        String [] strings = input.split(" ");
        /// Выбрасываем из калькулятора выражения имеющие больше двух операндов и одного опрератора
        if(strings.length != 3){
            throw new IOException();
        }
          //System.out.println("Строка имеет не больше одного оператора и двух операндов");
        ///Проверяем является ли строка математической опирацией
        String [] sig = { "+", "-", "*", "/"};
        for(int i = 0; i < 4; i++){
            if(Objects.equals(strings[1], sig[i])){
                sig[0] = strings[1];
                   //System.out.println("Строка является математической опирацией");
                break;
            } else if (i == 3){
                throw new IOException();
            }
        }
        String output = null;
        int number1 = 0;
        ////// Если арабские числа
        String [] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(Objects.equals(strings[0], num[i]) && Objects.equals(strings[2], num[j])){
                    number1 = i+1;
                    int number2 = j+1;
                    Aryph aoper = new Aryph();
                    // System.out.println("Ваше выражение содержит арабские цифры");
                    switch (sig[0]){
                        case "+":
                            output = Integer.toString(aoper.sum(number1, number2));
                            System.out.println(aoper.sum(number1, number2));
                            break;
                        case "-":
                            output = Integer.toString(aoper.sum(number1, number2));
                            System.out.println(aoper.dif(number1, number2));
                            break;
                        case "*":
                            output = Integer.toString(aoper.sum(number1, number2));
                            System.out.println(aoper.mult(number1, number2));
                            break;
                        case "/":
                            output = Integer.toString(aoper.sum(number1, number2));
                            System.out.println(aoper.div(number1, number2));
                            break;
                    }

                }else if(i == 9 && j == 9){
                    break;
                }
            }
        }
        ////// Если римские числа
        String [] rnum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(Objects.equals(strings[0], rnum[i]) && Objects.equals(strings[2], rnum[j])) {
                    ///Преобразование римских цифр в арабские для удобства
                    number1 = i + 1;
                    int number2 = j + 1;
                    int b;
                    Aryph roper = new Aryph();
                    Aryph rtransf = new Aryph();
                    //System.out.println("Ваше выражение содержит римские цифры");
                    switch (sig[0]) {
                        case "+":
                            b = roper.sum(number1, number2);
                            output = rtransf.arabicToRoman(b);
                            System.out.println(output);
                            break;
                        case "-":
                            if(number1 > number2) {
                                b = roper.dif(number1, number2);
                                output = rtransf.arabicToRoman(b);
                                System.out.println(output);
                                break;
                            }else {throw new IOException();}
                        case "/":
                            b = roper.div(number1, number2);
                            output = rtransf.arabicToRoman(b);
                            System.out.println(output);
                            break;
                        case "*":
                            b = roper.mult(number1, number2);
                            output = rtransf.arabicToRoman(b);
                            System.out.println(output);
                            break;
                    }
                }else if(i == 9 && j == 9){
                    break;
                }
            }
        }
        if (number1 == 0) {
            throw new IOException();
        }
        return output;
    }
}
class Aryph {
    int sum(int num1, int num2) {
        return num1 + num2;
    }

    int dif(int num1, int num2) {
        return num1 - num2;
    }

    int mult(int num1, int num2) {
        return num1 * num2;
    }

    int div(int num1, int num2) {
        return num1 / num2;
    }

    String arabicToRoman(int number) {
        String[] romanSymbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int remainingNumber = number;
        for (int i = 0; i < arabicValues.length; i++) {
            while (remainingNumber >= arabicValues[i]) {
                result.append(romanSymbols[i]);
                remainingNumber -= arabicValues[i];
            }
        }
        return result.toString();
    }
}

