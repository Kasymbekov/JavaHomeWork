package Task6;

public class Skeleton extends Boss{
    private int arrows;

    public Skeleton(int health, int damage, Weapon weapon, int arrows) {
        super(health,damage, weapon);
        this.setArrows(arrows);
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    @Override
    public String printInfo() {
        return super.printInfo() + ", arrows=" + getArrows();
    }
}
