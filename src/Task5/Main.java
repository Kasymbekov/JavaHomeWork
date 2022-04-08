package Task5;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Init boss variables
        Boss boss = new Boss();
        boss.setHealth(500);
        boss.setDamage(100);
        boss.setDefense("Magical");

        //Print boss properties
        System.out.println(boss);

        //Create and print all heroes
        printHeroes();
    }

    //Method to create heroes with random properties
    public static Hero[] createHeroes(){
        //To have only one mutable variable
        int quantity = 3;

        String[] powers = {"Telekinesis", "Kinetic", "Physical", "Magical"};
        Hero[] heroes = new Hero[quantity];

        Random random = new Random();

        for (int i = 0; i < heroes.length; i++) {
            if(random.nextBoolean()){
                heroes[i] = new Hero(random.nextInt(250), random.nextInt(90));
            }else{
                heroes[i] = new Hero(random.nextInt(250), random.nextInt(90), powers[random.nextInt(powers.length)]);
            }
        }

        return heroes;
    }

    //Method to print all heroes
    public static void printHeroes(){
        for (int i = 0; i < createHeroes().length; i++) {
            System.out.println("------------------------------------");
            System.out.println("Hero " + (i+1) + ":");
            System.out.println(" -Health: " + createHeroes()[i].getHealth());
            System.out.println(" -Damage: " + createHeroes()[i].getDamage());
            System.out.println(" -Superpower: " + createHeroes()[i].getPower());
        }
    }
}
