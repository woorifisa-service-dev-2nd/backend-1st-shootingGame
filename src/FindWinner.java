import java.util.*;

public class FindWinner {

    void getWinner(List<Soldier> soldierList) {

        soldierList.sort(Comparator.comparingInt(Soldier::getHitted)
                .reversed()
                .thenComparing(Soldier::getGunType));

        Soldier winner = soldierList.get(0);

        System.out.println("축하합니다! 사격 성적 최우수자는 " + winner.getName() + "님 입니다!");

    }
}
