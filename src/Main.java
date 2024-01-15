import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Formatter;

public class Main {
    public static Handler handler;
    public static int countLog = 0;

    public static final Logger logger = Logger.getLogger(WinnerLogger.class.getName());
    public static void main(String[] args) throws IOException {

        handler = new FileHandler("winnerLogFile.log"); // 로그 핸들러 여기서 한번만 생성

        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage();
            }
        };

        handler.setFormatter(formatter);
        logger.addHandler(handler);

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
