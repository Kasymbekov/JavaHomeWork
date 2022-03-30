package Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //1
        String str = "Hello everyone, how are you?";

        //2
        final int NUM = 99;

        //3
        String word = "Hello world!";

        //4
        str = NUM + word;

        //5
        System.out.println(str + ", " + NUM + ", " + word);

        //6
        if (NUM < 0) {
            System.out.println("Вы сохранили отрицательное число");
        } else if (NUM > 0) {
            System.out.println("Вы сохранили положительное число");
        } else {
            System.out.println("Вы сохранили ноль");
        }

        //7
        System.out.print("Введите ваше имя: ");

        //8
        Scanner scanner = new Scanner(System.in);

        //9
        System.out.println("Good morning, " + scanner.next() + "!");
    }
}
