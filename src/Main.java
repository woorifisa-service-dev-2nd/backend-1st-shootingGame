import java.util.*;

public class Main {
    public static void main(String[] args) {
        RunShootingGame runShootingGame = new RunShootingGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("사격 개시 : 1\n사격 종료 : 0");

        while (true) {
            int isStart = scanner.nextInt();

            switch (isStart) {
                case 0: System.out.println("프로그램 종료");
                        break;
                case 1: runShootingGame.run();
                        System.out.println("사격 재개 : 1\n사격 종료 : 0");
                        break;
                default: System.out.println("1 또는 0을 입력해주세요.");
                        break;
            }
        }
    }
}
