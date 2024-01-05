import java.util.*;

public class Main {

    public static void main(String[] args) {

        String data = "dummy-data.csv";
        Handler handler = new Handler();

        try {

            int count = handler.inputValueHandler();

            List<Soldier> soldierList = handler.soldierListParsingHandler(data, count);

            Shoot shooting = new Shoot();

            shooting.startShoot(soldierList, count);

            FindWinner findWinner = new FindWinner();

            findWinner.getWinner(soldierList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}