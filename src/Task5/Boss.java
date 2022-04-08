package Task5;

public class Boss {
    //Init boss variables
    private int health;
    private int damage;
    private String defense;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Boss {" +
                "health=" + health +
                ", damage=" + damage +
                ", defense='" + defense + '\'' +
                '}';
    }
}
