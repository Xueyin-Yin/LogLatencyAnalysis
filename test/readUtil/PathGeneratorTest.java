package readUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for PathGenerator class
 */
public class PathGeneratorTest {

    @Test
    public void testPathGenerateCorrectlyWhenTimeRangeIsCorrect() throws ParseException {
        String startTime = "2019-11-29-00";
        String endTime = "2019-11-29-03";
        List<String> testPaths = PathGenerator.generateAllPaths(startTime, endTime);
        List<String> realPaths = new ArrayList<>();
        realPaths.add("/var/log/httpd/2019-11-29-00.log");
        realPaths.add("/var/log/httpd/2019-11-29-01.log");
        realPaths.add("/var/log/httpd/2019-11-29-02.log");
        realPaths.add("/var/log/httpd/2019-11-29-03.log");

        Assert.assertTrue(testPaths.size() == realPaths.size());

        for (int i = 0; i < realPaths.size(); i++) {
            Assert.assertTrue(testPaths.get(i).equals(realPaths.get(i)));
        }
    }

    @Test
    public void testPathGenerateEmptyWhenTimeRangeIsIncorrect() throws ParseException {
        String startTime = "2019-11-29-03";
        String endTime = "2019-11-29-01";
        List<String> testPaths = PathGenerator.generateAllPaths(startTime, endTime);
        Assert.assertTrue(testPaths.size() == 0);
    }
}
