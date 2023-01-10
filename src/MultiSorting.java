import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiSorting extends Thread {

    static SingleSorting singleSorting = new SingleSorting();

    public static void merge(int[] array, int[] left, int[] right){
        int index = 0, index1 = 0, result = 0;

        while (index < left.length && index1 < right.length){
            if (left[index] <= right[index1]){
                array[result] = left[index];
                index++;
            } else {
                array[result] = right[index1];
                index1++;
            }
            result++;
        }
        while (index < left.length){
            array[result] = left[index];
            index++;
            result++;
        }
        while (index1 < right.length){
            array[result] =right[index1];
            index1++;
            result++;
        }
    }

    public void multiThreading(int[] array){

        int middle = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, array.length);

        Thread leftThread = new Thread(() -> singleSorting.mergeSort(leftArray, 0, leftArray.length - 1));
        Thread rightThread = new Thread(() -> singleSorting.mergeSort(rightArray, 0, rightArray.length - 1));

        ExecutorService executor = Executors.newFixedThreadPool(2);//creating a pool of 2 threads
        executor.execute(leftThread);//calling execute method of Executor Service
        executor.execute(rightThread);//calling execute method of Executor Service
        executor.shutdown();
        while (!executor.isTerminated()) {}

        merge(array, leftArray, rightArray);
    }
}
