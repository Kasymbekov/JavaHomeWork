package Task5;

public class Hero {
    //Init hero variables
    private int health;
    private int damage;
    private String power;

    public Hero(int health, int damage, String power) {
        this.health = health;
        this.damage = damage;
        this.power = power;
    }

    public Hero(int health, int damage){
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Hero {" +
                "health=" + health +
                ", damage=" + damage +
                ", power='" + power + '\'' +
                '}';
    }
}
