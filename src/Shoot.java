import java.util.*;

public class Shoot {

    void startShoot(List<Soldier> soldierList, int count) {

        System.out.println("사격결과");

        for (int i = 0; i < count; i++) {

            System.out.println((i + 1) + " / " + count);

            for (Soldier soldier : soldierList) {

                if (Math.floor(Math.random() * 10) >= 4) soldier.setShootingHit(soldier.getHit(), i);

                System.out.println(soldier.getName() + "(" + soldier.getGunType() + "):" + soldier.getHit());
            }

            System.out.println();

        }

    }

}
