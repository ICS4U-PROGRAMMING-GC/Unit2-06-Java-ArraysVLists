import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ArraysVLists program.
 */
public final class ArraysVLists {

    private ArraysVLists() {
    }

    /**
     * Calculate mean.
     *
     * @param array the input array
     * @return the calculated mean
     */
    public static double calcMean(final int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    /**
     * Calculate median.
     *
     * @param array the input array
     * @return the calculated median
     */
    public static double calcMedian(final int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        int middle = array.length / 2;
        if (array.length % 2 == 0) {
            return (double) (array[middle - 1] + array[middle]) / 2.0;
        } else {
            return (double) array[middle];
        }
    }

    /**
     * Calculate mode.
     *
     * @param array the input array
     * @return the calculated mode
     */
    public static int calcMode(final int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int maxCount = 0;
        int mode = array[0];

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = array[i];
            }
        }
        return mode;
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final String[] fileNames = {
            "Unit2-06-Set1",
            "Unit2-06-Set2",
            "Unit2-06-Set3"
        };

        for (String fileName : fileNames) {
            System.out.println(fileName);
            final ArrayList<Integer> tempList = new ArrayList<>();

            // Read file into list
            try {
                final Scanner fileScanner = new Scanner(new File(fileName));
                while (fileScanner.hasNextInt()) {
                    tempList.add(fileScanner.nextInt());
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: File " + fileName + " not found.");
                continue;
            }

            // Copy list to array
            final int[] array = new int[tempList.size()];
            for (int i = 0; i < tempList.size(); i++) {
                array[i] = tempList.get(i);
            }

            // Sort array first
            Arrays.sort(array);

            // Print sorted numbers
            System.out.print("Numbers: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Get stats
            final double mean = calcMean(array);
            final double median = calcMedian(array);
            final int mode = calcMode(array);

            // Print results
            System.out.println("Mean: " + mean);
            System.out.println("Median: " + median);
            System.out.println("Mode: " + mode);
            System.out.println();
        }
    }
}

