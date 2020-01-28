import analyzeUtil.PercentileFinder;
import readUtil.BufferReader;
import readUtil.PathGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class for the log percentile analysis
 */
public class LogAnalyzer {

    private final static List<Integer> RESPONSE_TIMES = new ArrayList<>();
    private final static String OUTPUT_FORMAT = "%d%% of requests return a response within %f ms";

    /**
     * Program Entry
     * @param args
     * args[0]: start time that we want to retrieve
     * args[1]: end time that we want to retrieve
     */
    public static void main(String[] args) {
        String startTime = args[0];
        String endTime = args[1];

        long programStartTimeInMillis = System.currentTimeMillis();

        try {
            // Generate all log file paths based on the input start time and end time
            List<String> logFiles = PathGenerator.generateAllPaths(startTime, endTime);

            //Fetch all response times from all the log files
            for (String logFile : logFiles) {
                BufferReader.readFile(logFile, RESPONSE_TIMES);
            }

            //Calculate percentiles based on all the response times
            double theNinetyPercentile = PercentileFinder.findPercentileNumber(RESPONSE_TIMES, 0.9);
            double theNinetyFivePercentile = PercentileFinder.findPercentileNumber(RESPONSE_TIMES, 0.95);
            double theNinetyNinePercentile = PercentileFinder.findPercentileNumber(RESPONSE_TIMES, 0.99);

            //Print results
            System.out.println("READ API");
            System.out.println(String.format(OUTPUT_FORMAT, 90, theNinetyPercentile));
            System.out.println(String.format(OUTPUT_FORMAT, 95, theNinetyFivePercentile));
            System.out.println(String.format(OUTPUT_FORMAT, 99, theNinetyNinePercentile));
            System.out.println("My solution took " + (System .currentTimeMillis() - programStartTimeInMillis) + " milliseconds to process a log file containing " + RESPONSE_TIMES.size() + " lines and printed the results, with an i7-8750H core and 1TB HDD.");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
