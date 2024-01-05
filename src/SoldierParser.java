import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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

                System.out.println(inputSoldiers.toString());

            }
        } catch (IOException e) {
            // 파일을 찾을 수 없거나 읽는 동안 오류가 발생하면 예외를 던집니다.
            throw new IOException("파일을 읽는 중 오류 발생: " + e.getMessage());
        }

        return inputSoldiers.toString();
    }
}
