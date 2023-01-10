import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){

            SingleSorting sorting = new SingleSorting();
            MultiSorting multiSorting = new MultiSorting();
            System.out.print("""
                1. Single-threading Sorting.
                2. Multi-threading Sorting.
                3. Exit.
                """);
            System.out.print("Please choose an option: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("\nPlease enter size of array: ");
                    int size = scanner.nextInt();
                    int[] array = SingleSorting.generateArray(size);
                    long start = System.nanoTime();
                    sorting.singleThreading(array);
                    System.out.println("\nProcess ended in: " +(System.nanoTime() - start) / 1000000.0 + "ms");
                    for (int index : array) {
                        System.out.print(index +", ");
                    }
                    System.out.println("\n");
                }

                case 2 -> {
                    System.out.print("\nPlease enter size of array: ");
                    int size = scanner.nextInt();
                    int[] array = SingleSorting.generateArray(size);
                    long start = System.nanoTime();
                    multiSorting.multiThreading(array);
                    System.out.println("Process ended in: " + (System.nanoTime() - start) / 1000000.0 + "ms");
                    for (int index : array) {
                        System.out.print(index +", ");
                    }
                    System.out.println("\n");
                }

                case 3 -> System.exit(0);

                default -> System.out.println("it is not a choice!");
            }
        }
    }
}
