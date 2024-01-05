import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Handler {

    List<Soldier> soldierListParsingHandler(String dataName, int count) throws IOException, CreatedException {

        SoldierParser soldierParser = new SoldierParser();

        List<Soldier> soldierList = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();
        Set<String> typeSet = new HashSet<>();

        try {
            String inputPattern = "^[a-zA-Z]{1,10}:k[1-9]*$";

            String inputSoldiers = soldierParser.getSoldierList(dataName);

            String[] soldiers = inputSoldiers.split(",");

            System.out.println(Arrays.toString(soldiers));

            for (String soldier : soldiers) {

                if (!Pattern.matches(inputPattern, soldier))
                    throw new CreatedException("이름은 10자 이하의 영어만 입력할 수 있고, 총은 k1 ~ k9중 하나만 입력할 수 있습니다.");

                String[] soldierInfo = soldier.split(":");

                Soldier tempSoldier = new Soldier(soldierInfo[0], soldierInfo[1], count);

                soldierList.add(tempSoldier);
                nameSet.add(soldierInfo[0]);
                typeSet.add(soldierInfo[1]);
            }

            if ((soldierList.size() != nameSet.size()) || (soldierList.size() != typeSet.size()) ||
                    soldierList.size() < 2 || soldierList.size() > 6)
                throw new CreatedException("이름과 총은 모두 달라야하고, 이름:총,이름:총... 형태로 작성되어야 합니다.");

        } catch (CreatedException e) {
            throw new CreatedException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        return soldierList;
    }

    int inputValueHandler() throws CreatedException{
        Scanner sc = new Scanner(System.in);

        System.out.println("표적 개수를 입력해주세요");
        String strNum = sc.nextLine();

        String inputPattern = "^[0-9]{1,2}$";

        try {

            if (!Pattern.matches(inputPattern, strNum) || (Integer.parseInt(strNum) < 1 || Integer.parseInt(strNum) > 20))
                throw new CreatedException("1 ~ 20 사이의 수를 입력하세요.");

        } catch (CreatedException e) {
            throw new CreatedException(e.getMessage());
        } finally {
            sc.close();
            System.out.println();
        }

        return Integer.parseInt(strNum);
    }
}
