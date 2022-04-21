package Task8.players;

import Task8.general.RPG_Game;

public class Golem extends Hero {

    public Golem(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.DEFENDER);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int count = 0;
        int part_dmg = boss.getDamage() / 5;

        if(!RPG_Game.stun){
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && this != heroes[i]) {
                    heroes[i].setHealth(heroes[i].getHealth() + part_dmg);
                    count++;
                }
            }
            for (int i = 0; i < heroes.length; i++) {
                if (this.getHealth() > 0 && this == heroes[i]){
                    this.setHealth(this.getHealth()-(part_dmg*count));
                }
            }
        }
    }
}
