import java.io.IOException;
import java.util.logging.*;

public class WinnerLogger {
    private static final Logger logger = Logger.getLogger(WinnerLogger.class.getName());
    int count = 0;

    public WinnerLogger() {
        this.count++;
    }

    public void loggingWinner(Soldier winner) {
        final String logfile = "winnerlogfile" + count + ".log";

        try {
            Handler handler = new FileHandler(logfile);

            Formatter formatter = new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return count + "회차 우승자 : " + winner.getName() + " 맞춘 횟수 : " + winner.getHitted();
                }
            };

            handler.setFormatter(formatter);

            logger.addHandler(handler);

            LogRecord logRecord = new LogRecord(Level.INFO, "완료");

            logger.log(logRecord);
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
