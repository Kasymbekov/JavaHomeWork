package Task8.players;

import Task8.general.RPG_Game;

public class Thor extends Hero{

    public Thor(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.STUN_BOSS);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        RPG_Game.stun = RPG_Game.random.nextBoolean();
    }
}
