package analyzeUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for PercentileFinder class
 */
public class PercentileFinderTest {
    @Test
    public void testFindPercentileNumberCorrectlyWhenInputsAreValid() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        double test90Percent = PercentileFinder.findPercentileNumber(numbers, 0.9);

        double test95Percent = PercentileFinder.findPercentileNumber(numbers, 0.95);

        double test99Percent = PercentileFinder.findPercentileNumber(numbers, 0.99);

        int test90PercentCount = 0;
        int test95PercentCount = 0;
        int test99PercentCount = 0;

        for (int number : numbers) {
            if (number < test90Percent) {
                test90PercentCount++;
            }
            if (number < test95Percent) {
                test95PercentCount++;
            }
            if (number < test99Percent) {
                test99PercentCount++;
            }
        }

        Assert.assertEquals((double) test90PercentCount / numbers.size(), 0.9, 0);
        Assert.assertEquals((double) test95PercentCount / numbers.size(), 0.95, 0);
        Assert.assertEquals((double) test99PercentCount / numbers.size(), 0.99, 0);
    }
}
