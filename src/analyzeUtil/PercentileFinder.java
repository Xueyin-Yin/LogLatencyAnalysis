package analyzeUtil;

import java.util.List;

/**
 * A class providing method to find the percent percentile Number among an array
 */
public class PercentileFinder {

    /**
     * A method to find the percentile Number among an array list
     *
     * @param numbers An integer array list
     * @param percent The percent position
     * @return A specific percent percentile
     */
    public static double findPercentileNumber(List<Integer> numbers, double percent) {

        //The SASS approach to calculate percentiles
        double x = (numbers.size() + 1) * percent;
        int intX = (int) x;
        if (x == intX) {
            // Convert the the find-K-smallest problem to find-K-largest problem to reduce necessary computations. Because in the context, we only need to figure out 90%, 95%, 99% percentiles.
            int k = (int) (numbers.size() - intX + 1);
            // Find the kth largest number in the array and return it
            return numbers.get(quickSelect(numbers, k, 0, numbers.size() - 1));
        } else {
            double g = x - intX;
            // Convert the the find-K-smallest problem to find-K-largest problem to reduce necessary computations.
            int k1 = (int) (numbers.size() - intX + 1);
            // Convert the the find-K-smallest problem to find-K-largest problem to reduce necessary computations.
            int k2 = (int) (numbers.size() - intX);

            // Find the kth largest number in the array
            int x1 = numbers.get(quickSelect(numbers, k1, 0, numbers.size() - 1));
            // Find the k-1th largest number in the array
            int x2 = numbers.get(quickSelect(numbers, k2, 0, numbers.size() - 1));

            // Calculate the percentile number
            return x1 + g * (x2 - x1);
        }

    }

    /**
     * A private method to partition the array based on the pivot
     *
     * @param numbers A list of integer
     * @param start   the start index
     * @param end     the end index
     * @return the pivot index
     */
    private static int getPivotByPartition(List<Integer> numbers, int start, int end) {
        //Take the first element as the pivot
        int pivot = start;
        int lessThan = start;

        //Rearrange the array list. Move all the elements which are larger than the pivot to the left side of the pivot
        for (int i = start; i <= end; i++) {
            int currentElement = numbers.get(i);
            if (currentElement > numbers.get(pivot)) {
                lessThan++;
                int tmp = numbers.get(lessThan);
                numbers.set(lessThan, numbers.get(i));
                numbers.set(i, tmp);
            }
        }
        int tmp = numbers.get(lessThan);
        numbers.set(lessThan, numbers.get(pivot));
        numbers.set(pivot, tmp);

        //return pivot index
        return lessThan;
    }

    /**
     * A private method to do quick select in order to find the kth largest elements
     *
     * @param numbers A array list of integer
     * @param k       The kth largest
     * @param start   Start index
     * @param end     End index
     * @return The index of the kth largest element in the array list
     */
    private static int quickSelect(List<Integer> numbers, int k, int start, int end) {
        //initial partition
        int pivot = getPivotByPartition(numbers, start, end);

        if (k == (pivot - start + 1)) {
            return pivot;
        } else if (k < (pivot - start + 1)) {
            return quickSelect(numbers, k, start, pivot - 1);
        } else {
            return quickSelect(numbers, k - (pivot - start + 1), pivot + 1, end);
        }
    }

}
