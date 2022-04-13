package Task6;

public class Boss extends GameEntity{
    private Weapon weapon;

    public Boss(int health, int damage, Weapon weapon) {
        super(health, damage);
        this.setWeapon(weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String printInfo(){
        return this.getClass().getSimpleName()  +
                " { health=" + getHealth() +
                ", damage=" + getDamage() +
                ", weapon=" + getWeapon() +
                '}';
    }
}
