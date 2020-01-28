package readUtil;

import java.io.*;
import java.util.List;

/**
 * A class which provides buffered read and parse response time method
 */
public class BufferReader {
    /**
     * A method to read data from the file and fetch all responses times from it
     *
     * @param filePath      The path of the log file which we need to retrieve
     * @param responseTimes A list will collect all the response time that are parsed
     * @throws Exception
     */
    public static void readFile(String filePath, List<Integer> responseTimes) throws Exception {
        File file = new File(filePath);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 20 * 1024 * 1024);// Read file by using a 20M buffer

        String line = "";
        while ((line = reader.readLine()) != null) {
            //Split all the components by the space
            String[] components = line.split("[ ]");
            //The last components of each line is the response time, we need to add it to the list
            responseTimes.add(Integer.parseInt(components[components.length - 1]));
        }
    }
}
