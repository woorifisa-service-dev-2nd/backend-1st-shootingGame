import java.util.*;

public class Main {

    public static void main(String[] args) {

        String data = "dummy-data.csv";
        InputHandler handler = new InputHandler();
        SoldierParser soldierParser = new SoldierParser();

        try {

            int count = handler.inputValueHandler();

            List<Soldier> soldierList = soldierParser.soldierListParsingHandler(data, count);

            Shoot shooting = new Shoot();

            shooting.startShoot(soldierList, count);

            FindWinner findWinner = new FindWinner();

            findWinner.getWinner(soldierList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}