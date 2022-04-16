package Task7;

public class Warrior extends Hero {
    @Override
    public void applySuperAbility() {
        System.out.println(this.getClass().getSimpleName() + " применил суперспособность INFINITE DAMAGE.");
    }
}
