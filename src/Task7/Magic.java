package Task7;

public class Magic extends Hero {
    @Override
    public void applySuperAbility() {
        System.out.println(this.getClass().getSimpleName() + " применил суперспособность CRITICAL DAMAGE.");
    }
}
