package Task6;

public class GameEntity {
    private int health;
    private int damage;
    public static int count;

    public GameEntity(int health, int damage) {
        this.setHealth(health);
        this.setDamage(damage);
        count++;
    }

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
}
