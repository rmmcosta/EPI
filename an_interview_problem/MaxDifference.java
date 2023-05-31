public class MaxDifference {

    public static int maxDifference(int[] arr) {
        int minAbs = arr[0];
        int maxAbs = arr[1];
        int diffAbs = maxAbs-minAbs;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]<minAbs)
                minAbs = arr[i];
            int diff = arr[i]-minAbs;
            if(diff>diffAbs)
                    diffAbs = diff;
        }
        return max(diffAbs,localMaxDifference(arr));
    }

    private static int localMaxDifference(int[] arr) {
        if (arr.length < 2) {
            return 0; // If the array has less than 2 elements, there is no difference.
        }
        
        if (arr.length==2) {
            return arr[1]-arr[0];
        }

        int pivot = arr.length/2-1;
        return max(
                    localMaxDifference(getSubArray(arr,0,pivot)),
                    localMaxDifference(getSubArray(arr,pivot+1,arr.length-1))
                );
    }
    
    private static int max(int x, int y) {
        if(x<y)
            return y;
        else 
            return x;
    }
     
    private static int[] getSubArray(int[] arr, int leftPos, int rightPos) {
        int[] subArr = new int[rightPos-leftPos+1];
        for(int i=0; i<subArr.length;i++)
            subArr[i] = arr[leftPos+i];
        return subArr;
    }
	
	/*private static void printArr(int[] arr) {
        if(arr.length==0)
            return;
        System.out.print(arr[0]);
        for(int i=1;i<arr.length;i++)
            System.out.print(", " + arr[i]);
        System.out.println();
    }*/

    public static void main(String[] args) {
        int[] values = {3, 1, 2, 5, 10, 9, 4, 6, 7};
        int result = maxDifference(values);
        System.out.println("Maximum difference: " + result);
        int[] similarValues = {3, 10, 2, 5, 1, 9, 4, 6, 7};
        result = maxDifference(similarValues);
        System.out.println("Maximum difference: " + result);
        /*System.out.println(max(5,4));
        System.out.println(max(6,7));
        System.out.println(max(1,1));
        int pivot = values.length/2-1;
        printArr(getSubArray(values,0,pivot));
        printArr(getSubArray(values,pivot+1,values.length-1));*/
    }
}