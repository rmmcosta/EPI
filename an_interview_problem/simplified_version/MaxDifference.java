package simplified_version;

import java.util.Arrays;

public class MaxDifference {

    public static int maxDifference(int[] arr) {
        int minAbs = arr[0];
        int diffAbs = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minAbs) {
                minAbs = arr[i];
            } else {
                diffAbs = Math.max(diffAbs, arr[i] - minAbs);
            }
        }

        return Math.max(diffAbs, localMaxDifference(arr));
    }

    private static int localMaxDifference(int[] arr) {
        if (arr.length < 2) {
            return 0; // If the array has less than 2 elements, there is no difference.
        }

        int pivot = arr.length / 2 - 1;
        return Math.max(
                localMaxDifference(Arrays.copyOfRange(arr, 0, pivot + 1)),
                localMaxDifference(Arrays.copyOfRange(arr, pivot + 1, arr.length))
        );
    }

    public static void main(String[] args) {
        int[] values = {3, 1, 2, 5, 10, 9, 4, 6, 7};
        int result = maxDifference(values);
        System.out.println("Maximum difference: " + result);

        int[] similarValues = {3, 10, 2, 5, 1, 9, 4, 6, 7};
        result = maxDifference(similarValues);
        System.out.println("Maximum difference: " + result);
    }
}