package readUtil;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for BufferReader class
 */
public class BufferReaderTest {
    @Test
    public void testReadResponseTimesSuccessfullyFromCorrectFilePath() throws Exception {
        List<Integer> testResponseTimes = new ArrayList<>();
        BufferReader.readFile("D:\\RiotTest\\test\\var\\log\\httpd\\2019-11-29-00.log", testResponseTimes);
        List<Integer> realResponseTimes = new ArrayList<>();
        realResponseTimes.add(1230);
        realResponseTimes.add(4630);

        Assert.assertTrue(testResponseTimes.size() == realResponseTimes.size());

        for (int i = 0; i < realResponseTimes.size(); i++) {
            Assert.assertTrue(testResponseTimes.get(i).equals(realResponseTimes.get(i)));
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadResponseTimesThrowsFileNotFoundExceptionWhenTheFileNotExist() throws Exception {
        List<Integer> testResponseTimes = new ArrayList<>();
        BufferReader.readFile("D:\\RiotTest\\test\\var\\log\\httpd\\2019-11-28-00.log", testResponseTimes);
    }
}
