package Task8.players;

import Task8.general.*;

public class Warrior extends Hero {

    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int crit = (this.getDamage() * (RPG_Game.random.nextInt(2) + 2));
        boss.setHealth(boss.getHealth() - (crit - this.getDamage()));
        System.out.println(this.getName() + " caused critical damage by " + crit + ".");
    }
}
