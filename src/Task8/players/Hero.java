package Task8.players;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility power;

    public Hero(String name, int health, int damage, SuperAbility power) {
        super(name, health, damage);
        this.power = power;
    }

    public void hit(Boss boss) {
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
}
