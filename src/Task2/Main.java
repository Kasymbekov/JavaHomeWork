package Task2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
            System.out.println(isAllowed(generateRandomAge(), 10));
            System.out.println(isAllowed(generateRandomAge(), 23));
            System.out.println(isAllowed(generateRandomAge(), 0));
            System.out.println(isAllowed(generateRandomAge(), -5));
            System.out.println(isAllowed(generateRandomAge(), 30));
    }

    public static String isAllowed(int age, int temp){
        String s = "";

        if(age >= 20 && age <= 45 && temp >= -20 && temp <= 30){
            s += "Можно идти гулять";
        }else if(age < 20 && temp >= 0 && temp <= 28){
            s += "Можно идти гулять";
        }else if(age > 45 && temp >= -10 && temp <= 25){
            s += "Можно идти гулять";
        }else{
            s += "Оставайтесь дома";
        }

        return s;
    }

    public static int generateRandomAge(){
        Random random = new Random();
        return random.nextInt(50);
    }
}
