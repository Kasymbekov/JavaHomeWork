package Task8.players;

import Task8.general.*;

public class Magic extends Hero {

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            int boost = RPG_Game.random.nextInt(5) + 2;
            int heroIndex = RPG_Game.random.nextInt(heroes.length);
            if (heroes[heroIndex].getHealth() > 0) {
                heroes[heroIndex].setDamage(heroes[heroIndex].getDamage() + boost);
                System.out.println(this.getName() + " boosted " + heroes[heroIndex].getName() + " by " + boost + " damage.");
            }
        }
    }
}
