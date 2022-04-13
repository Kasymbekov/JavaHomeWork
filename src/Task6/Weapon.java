package Task6;

public class Weapon {
    private Gun gun;
    private String desc;

    public Weapon(Gun gun, String desc) {
        this.setGun(gun);
        this.setDesc(desc);
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return " Weapon {" +
                " gun='" + getGun() + '\'' +
                ", desc='" + getDesc() + '\'' +
                '}';
    }
}
