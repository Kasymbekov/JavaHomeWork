package Task7;

public class Main {
    public static void main(String[] args) {
        printAbilities(createHeroes());
    }

    public static Hero[] createHeroes() {
        return new Hero[]{new Magic(), new Medic(), new Warrior()};
    }

    public static void printAbilities(Hero[] heroes) {
        for (Hero hero : heroes) {
            hero.applySuperAbility();
            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
            }
        }
    }
}
