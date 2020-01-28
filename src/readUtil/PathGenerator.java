package readUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A helper class to generate all log file paths based on start time and end time
 */
public class PathGenerator {

    //    private final static String PATH_FORMAT_FOR_LOCAL_TESTING  = "D:\\RiotTest\\test\\var\\log\\httpd\\%s.log"; //For local testing
    private final static String LOG_FILE_PATH_FORMAT = "/var/log/httpd/%s.log";
    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH");

    /**
     * A method to generate all log file paths based on start time and end time
     *
     * @param startTime start time that we want to retrieve
     * @param endTime   end time that we want to retrieve
     * @return A list of strings of all generated file paths
     * @throws ParseException
     */
    public static List<String> generateAllPaths(String startTime, String endTime) throws ParseException {
        List<String> filePaths = new ArrayList<>();
        //Convert start and end time string to the date format
        Date startTS = TIME_FORMAT.parse(startTime);
        Date endTS = TIME_FORMAT.parse(endTime);

        //If endTS is before startTS, return a empty list directly
        if (endTS.before(startTS)) {
            return filePaths;
        }

        Date timestamp = (Date) startTS.clone();

        //Increment the timestamp by 1 hour iteratively to get all the files that need to be retrieved
        while (!timestamp.after(endTS)) {
            filePaths.add(String.format(LOG_FILE_PATH_FORMAT, TIME_FORMAT.format(timestamp)));
//            filePaths.add(String.format(PATH_FORMAT_FOR_LOCAL_TESTING, TIME_FORMAT.format(timestamp))); //For local testing
            timestamp.setHours(timestamp.getHours() + 1);
        }

        return filePaths;
    }
}
