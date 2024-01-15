import java.util.*;
import java.util.regex.Pattern;

public class InputHandler {

    int inputValueHandler() throws CreatedException{
        System.out.println("표적 개수를 입력해주세요");
        Scanner inputValueScanner = new Scanner(System.in);
        String strNum = inputValueScanner.nextLine();

        String inputPattern = "^[0-9]{1,2}$";

        try {

            if (!Pattern.matches(inputPattern, strNum) || (Integer.parseInt(strNum) < 1 || Integer.parseInt(strNum) > 20))
                throw new CreatedException("1 ~ 20 사이의 수를 입력하세요.");

        } catch (CreatedException e) {
            throw new CreatedException(e.getMessage());
        } finally {
            System.out.println();
        }

        return Integer.parseInt(strNum);
    }
}
