package Task7;

public class Medic extends Hero {
    private int healPoint;

    @Override
    public void applySuperAbility() {
        System.out.println(this.getClass().getSimpleName() + " применил суперспособность HEALTH RECOVERY.");
    }

    public void increaseExperience() {
        this.healPoint += (healPoint / 10);
    }
}
