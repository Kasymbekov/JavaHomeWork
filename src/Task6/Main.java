package Task6;

public class Main {
    public static void main(String[] args) {
        //Init boss and print
        Boss boss = new Boss(500, 90, new Weapon(Gun.COLD_WEAPON, "Katana"));
        System.out.println(boss.printInfo());

        //Init skeletons and print
        Skeleton skeleton = new Skeleton(40, 50, new Weapon(Gun.FIREARMS, "Desert Eagle"), 30);
        Skeleton skeleton1 = new Skeleton(60, 66, new Weapon(Gun.FIREARMS, "AWP"), 15);

        System.out.println(skeleton.printInfo());
        System.out.println(skeleton1.printInfo());
        System.out.println("Total created entities: " + GameEntity.count);
    }
}
