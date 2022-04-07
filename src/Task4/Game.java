package Task4;

import java.util.Random;

public class Game {
    //Init boss's variables
    public static int bossHealth = 1000;
    public static int bossDamage = 80;
    public static String bossDefenceType;

    //Init simple heroes variables
    public static int[] heroesHealth = {280, 170, 160, 350, 100, 130, 165, 250};
    public static int[] heroesDamage = {10, 15, 20, 3, 12, 15, 11, 0};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Golem", "Lucky", "Berserk", "Thor", "Medic"};
    public static int total_dmg = 0;
    public static int temp_dmg = bossDamage - (bossDamage / 5);

    //Init game variables
    public static int round_number = 1;

    public static void main(String[] args) {

        while (!isGameFinished()) {
            round();
        }
        printStatistics();
    }

    public static void round() {
        chooseDefence();
        printStatistics();
        System.out.println("\033[1mRound " + round_number + " started.\033[0m");
        bossHits();
        heroesHit();
        heal();
        System.out.println("\033[1mRound " + round_number + " finished.\033[0m");
        round_number++;
    }

    //Method to choose weakness for boss
    public static void chooseDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length - 1);
        bossDefenceType = heroesAttackType[randomIndex];
    }

    public static void bossHits() {
        boolean isLucky = isLucky();
        int deflect = 0;
        boolean isThor = isLucky();

        if(isThor) {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0 && bossHealth > 0) {
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    } else {
                        //Golem's function
                        if (isGolemAlive()) {
                            if (!heroesAttackType[i].equals("Golem")) {

                                //Lucky's function
                                if (heroesAttackType[i].equals("Lucky") && isLucky) {
                                    if(heroesHealth[getIndexByName("Golem")] - (bossDamage - temp_dmg) < 0){
                                        heroesHealth[getIndexByName("Golem")] = 0;
                                    }else{
                                        heroesHealth[getIndexByName("Golem")] -= bossDamage - temp_dmg;
                                        deflect += bossDamage - temp_dmg;
                                    }
                                } else {
                                    heroesHealth[i] -= temp_dmg;
                                    if(heroesHealth[getIndexByName("Golem")] - (bossDamage - temp_dmg) < 0){
                                        heroesHealth[getIndexByName("Golem")] = 0;
                                    }else{
                                        heroesHealth[getIndexByName("Golem")] -= bossDamage - temp_dmg;
                                        deflect += bossDamage - temp_dmg;
                                    }

                                }
                            } else {
                                if(heroesHealth[getIndexByName("Golem")] - bossDamage < 0){
                                    heroesHealth[getIndexByName("Golem")] = 0;
                                }else {
                                    heroesHealth[getIndexByName("Golem")] -= bossDamage;
                                }
                            }
                        } else {
                            heroesHealth[i] = heroesHealth[i] - bossDamage;
                        }
                    }
                }
            }
            System.out.println("Boss attacked!");
            System.out.println("Golem deflected " + deflect + " damage.");

            if (isLucky && heroesHealth[getIndexByName("Lucky")] > 0) {
                System.out.println("Lucky dodged the damage.");
            } else {
                System.out.println("Lucky didn't dodge the damage.");
            }
        }else{
            System.out.println("Thor blocked boss for 1 round.");
        }
    }

    public static void heroesHit() {
        int block = new Random().nextInt(temp_dmg);

        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random random = new Random();
                    int coeff = random.nextInt(12) + 2;

                    if (bossHealth - heroesDamage[i] * coeff < 0) {
                        bossHealth = 0;
                        total_dmg += heroesDamage[i] * coeff;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coeff;
                        total_dmg += heroesDamage[i] * coeff;
                    }
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                        total_dmg += heroesDamage[i];
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                        total_dmg += heroesDamage[i];
                    }
                }

                //Berserk function
                if (heroesAttackType[i].equals("Berserk") && heroesHealth[getIndexByName("Berserk")] > 0) {
                    if(bossHealth - block < 0){
                        bossHealth = 0;
                    }else{
                        bossHealth -= block;
                    }
                    heroesHealth[i] += block;
                }

            }
        }
        System.out.println("Heroes attacked! Total: " + total_dmg + " dmg");
        if (heroesHealth[getIndexByName("Berserk")] > 0) {
            System.out.println("Berserk damaged extra " + block + " dmg.");
        }
        total_dmg = 0;
    }

    public static void printStatistics() {
        System.out.println("-----------------------------------------------");
        System.out.format("%13s %12s %8s %15s", "\033[1mName", "Health", "Damage", "Weakness\033[0m\n");
        System.out.println("-----------------------------------------------");
        System.out.format("%10s %10d %6d %12s", "Boss", bossHealth, bossDamage, bossDefenceType);
        System.out.println();

        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.format("%10s %10d %6d", heroesAttackType[i], heroesHealth[i], heroesDamage[i]);
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    //Medic's method
    public static void heal() {
        if (heroesHealth[heroesHealth.length - 1] > 0) {
            //Init random
            Random random = new Random();

            //Init Medic variable
            int heal = random.nextInt(30) + 20;

            //Init random patient by index except Medic
            int patient = random.nextInt(heroesAttackType.length - 1);

            for (int j = 0; j < heroesAttackType.length - 1; j++) {
                if (heroesHealth[j] > 0 && heroesHealth[j] < 100) {
                    heroesHealth[j] += heal;
                    System.out.println("Medic healed " + heroesAttackType[j] + " by " + heal + " hp.");
                    break;
                }
            }
        }
    }

    public static boolean isGolemAlive() {
        boolean isGolemAlive = true;

        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesAttackType[i].equals("Golem") && heroesHealth[i] <= 0) {
                isGolemAlive = false;
            }
        }
        return isGolemAlive;
    }

    public static int getIndexByName(String s) {
        int index = 0;

        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesAttackType[i].equals(s)) {
                index = i;
            }
        }

        return index;
    }

    public static boolean isLucky() {
        return new Random().nextBoolean();
    }
}
