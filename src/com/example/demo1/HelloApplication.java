package com.example.demo1;

import java.util.Objects;
import java.util.Scanner;

public class HelloApplication {
    public static void main(String[] args){
        Scanner string = new Scanner(System.in);
        String Expression = string.nextLine();
        String [] strings = Expression.split(" ");
        /// Выбрасываем из калькулятора выражения имеющие больше двух операндов и одного опрератора
        if(strings.length != 3){
            System.out.println("System error");
            return;
        }
        //  System.out.println("Строка имеет не больше одного оператора и двух операндов");
        ///Проверяем есть ли строка математической опирацией
        String [] sig = { "+", "-", "*", "/"};
        for(int i = 0; i < 4; i++){
            if(Objects.equals(strings[1], sig[i])){
                sig[0] = strings[1];
                ///   System.out.println("Строка является математической опирацией");
                break;
            } else if (i == 3){
                System.out.println("System error");
                return;
            }
        }
        int num1 = 0;
        ////// Если арабские числа
        String [] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(Objects.equals(strings[0], num[i]) && Objects.equals(strings[2], num[j])){
                    num1 = i+1;
                    int num2 = j+1;
                    Aryph aoper = new Aryph();
                    ///System.out.println("Ваше выражение содержит арабские цифры");
                    switch (sig[0]){
                        case "+":
                            System.out.println(aoper.sum(num1, num2));
                            break;
                        case "-":
                            System.out.println(aoper.dif(num1, num2));
                            break;
                        case "*":
                            System.out.println(aoper.mult(num1, num2));
                            break;
                        case "/":
                            System.out.println(aoper.div(num1, num2));
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
                if(Objects.equals(strings[0], rnum[i]) && Objects.equals(strings[2], rnum[j])){
                    ///Преобразование римских цифр в арабские для удобства
                    num1 = i+1;
                    int num2 = j+1;
                    int c;
                    Aryph roper = new Aryph();
                    Aryph rtransf = new Aryph();
                    ///System.out.println("Ваше выражение содержит римские цифры");
                    switch (sig[0]){
                        case "+":
                            c = roper.sum(num1, num2);
                            rtransf.transf(c);
                            break;
                        case "-":
                            if(num1 > num2){
                                c = roper.dif(num1, num2);
                                rtransf.transf(c);
                            }else{
                                System.out.println("System error");
                                return;
                            }
                        case "*":
                            c = roper.mult(num1, num2);
                            rtransf.transf(c);
                            break;
                        case "/":
                            c = roper.div(num1, num2);
                            rtransf.transf(c);
                            break;
                    }
                }
            }
        }
        if (num1 == 0) {
            System.out.println("System error");
        }
    }
}
class Aryph{
    int sum(int num1, int num2){
        return num1 + num2;
    }
    int dif(int num1, int num2){
        return num1 - num2;
    }
    int mult(int num1, int num2){
        return num1 * num2;
    }
    int div(int num1, int num2){
        return num1 / num2;
    }
    void transf(int b){
        if(b == 100) {
            System.out.println("C");
        }
        else{
            if(b == 49){
                System.out.println("XXXXIX");
            }
            else if(b > 50){
                System.out.print("L");
                for(int i = 0; i < b/10-5; i++){
                    System.out.print("X");
                }
                if(b%10 == 9){
                    System.out.println("IX");
                }
                else if(b%10 >= 5){
                    System.out.print("V");
                    for(int i = 0; i < b%5; i++){
                        System.out.print("I");
                    }
                }
                else {
                    for(int i = 0; i < b%5; i++){
                        System.out.print("I");
                    }
                }
            }
            else{
                for(int i = 0; i < (b/10); i++){
                    System.out.print("X");
                }
                if(b%10 == 9){
                    System.out.println("IX");
                }
                else if(b%10 >= 5){
                    System.out.print("V");
                    for(int i = 0; i < b%5; i++){
                        System.out.print("I");
                    }
                }
                else {
                    for(int i = 0; i < b%5; i++){
                        System.out.print("I");
                    }
                }
            }
        }
    }
}