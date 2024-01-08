import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class SoldierParser {

    private final String RESOURCES = "/resources/";

    String getSoldierList(String dataName) throws IOException {
        String route = RESOURCES + dataName;
        StringBuilder inputSoldiers = new StringBuilder();

        try {
            InputStream inputStream = SoldierParser.class.getResourceAsStream(route);

            if (inputStream == null) throw new IOException("파일을 찾을 수 없습니다: " + route);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

                String line;

                while ((line = br.readLine()) != null) {
                    inputSoldiers.append(line);
                }

                System.out.println(inputSoldiers.toString() + "\n");

            }
        } catch (IOException e) {
            // 파일을 찾을 수 없거나 읽는 동안 오류가 발생하면 예외를 던집니다.
            throw new IOException("파일을 읽는 중 오류 발생: " + e.getMessage());
        }

        return inputSoldiers.toString();
    }

    List<Soldier> soldierListParsingHandler(String dataName, int count) throws IOException, CreatedException {

        List<Soldier> soldierList = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();
        Set<String> typeSet = new HashSet<>();

        try {
            String inputPattern = "^[a-zA-Z]{1,10}:k[1-9]*$";

            String inputSoldiers = getSoldierList(dataName);

            String[] soldiers = inputSoldiers.split(",");

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
}
