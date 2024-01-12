import java.util.*;

public class Main {
    public static void main(String[] args) {
        RunShootingGame runShootingGame = new RunShootingGame();

        System.out.println("사격 개시 : 1\n사격 종료 : 0");

        Scanner scanner = new Scanner(System.in);

        int isStart = 0;

        while (true) {

            isStart = scanner.nextInt();

            if (isStart == 0) {
                System.out.println("프로그램 종료");
                break;
            } else if (isStart == 1) {
                runShootingGame.run();
            } else {
                System.out.println("1 또는 0을 입력해주세요.");
            }

        }
    }
}
