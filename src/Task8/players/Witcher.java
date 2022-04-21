package Task8.players;

public class Witcher extends Hero{

    public Witcher(String name, int health) {
        super(name, health, 0, SuperAbility.KAMIKAZE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        if(this.getHealth() > 0){
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() == 0 && this != heroes[i]){
                    heroes[i].setHealth(this.getHealth());
                    this.setHealth(0);
                    System.out.println(this.getName() + " gave his life to " + heroes[i].getName());
                }
            }
        }

    }
}
