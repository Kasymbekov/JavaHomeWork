package Task8.players;

import Task8.general.*;

public class Berserk extends Hero {

    private int savedDamage;

    public Berserk(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int extra_dmg = RPG_Game.random.nextInt(boss.getDamage())+1;
        boss.setHealth(boss.getHealth()-extra_dmg);
        System.out.println(this.getName() + " hit extra " + extra_dmg + " damage.");
    }
}
