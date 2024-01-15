import java.util.logging.*;

public class WinnerLogger {

    public void loggingWinner(Soldier winner) {

            String logMessage = Main.countLog + "회차 우승자 : " + winner.getName() + " 맞춘 횟수 : " + winner.getHitted() + "\n";

            LogRecord logRecord = new LogRecord(Level.INFO, logMessage);

            Main.logger.log(logRecord);

    }
}
