import java.io.*;
import java.util.Random;

/**
 * A class to generate mocked log data for test use
 */
public class TestDataGeneratorUtil {

    private final static String LOG_FORMAT = "10.2.3.4 [2019/11/29:03:02:39] \"GET /api/playeritems?playerId=3\" 200 %d\n";

    public static void main(String[] args) {
        String testLogPath = "D:\\RiotTest\\test\\var\\log\\httpd\\2019-11-30-00.log";
        writeFile(testLogPath, 20000000);
    }

    public static void writeFile(String outputFile, int numOfLines) {
        try {

            FileWriter fw = new FileWriter(outputFile);
            Random random = new Random();
            for (int i = 0; i < numOfLines; i++) {
                fw.write(String.format(LOG_FORMAT, random.nextInt(100000) + 1));
            }

            fw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
