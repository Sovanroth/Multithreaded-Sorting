import java.util.Random;
public class SingleSorting extends Thread{

    /**
     * in this method is the process of sorting array using merge sort algorithm
     * @param array is a variable which ias used for sorting, and we get it from user input
     * @param start is a point that start from the first array
     * @param middle is a point that is in the middle of array, also it is a starting point for array 2
     * @param end is a point that end of an array
     */
    public void merge(int[] array, int start, int middle, int end) {

        int leftSide = middle - start + 1;
        int rightSide = end - middle;

        int[] left = new int[leftSide];
        int[] right = new int[rightSide];

        int index, index1;

        for (index = 0; index < leftSide; index++) {
            left[index] = array[start + index];
        }
        for (index1 = 0; index1 < rightSide; index1++) {
            right[index1] = array[middle + 1 + index1];
        }

        int result = start;
        index = 0;
        index1 = 0;

        while (index < leftSide && index1 < rightSide) {
            if (left[index] <= right[index1]) {
                array[result] = left[index];
                index++;
            } else {
                array[result] = right[index1];
                index1++;
            }
            result++;
        }

        while (index < leftSide) {
            array[result] = left[index];
            index++;
            result++;
        }

        while (index1 < rightSide) {
            array[result] = right[index1];
            index1++;
            result++;
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    /**
     * method for sorting using single threading
     * @param array is the array the get from user input, and we will use this parameter to sort
     */
    public void singleThreading(int[] array){
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * method for generate array
     * @param size is the size of array
     * @return array
     */
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            array[i] = random.nextInt(10000000);
        return array;
    }
}
