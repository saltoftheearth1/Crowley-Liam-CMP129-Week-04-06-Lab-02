public class SortingBenchmarks {
    public static void main(String[] args) {
        int[][] testArrays = {
            {34, 7, 23, 1, 56, 12, 9, 45, 18, 3, 29, 41, 6, 52, 15, 37, 2, 48, 21, 11},
            {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        };

        for (int test = 0; test < testArrays.length; test++) {
            int[] bubbleArray = testArrays[test].clone();
            int[] selectionArray = testArrays[test].clone();

            int bubbleExchanges = bubbleSort(bubbleArray);
            int selectionExchanges = selectionSort(selectionArray);

            System.out.println("Test " + (test + 1));
            System.out.println("Bubble Sort Results");
            System.out.print("Sorted array: ");
            printArray(bubbleArray);
            System.out.println("Number of exchanges: " + bubbleExchanges);

            System.out.println("\nSelection Sort Results");
            System.out.print("Sorted array: ");
            printArray(selectionArray);
            System.out.println("Number of exchanges: " + selectionExchanges);

            if (bubbleExchanges < selectionExchanges) {
                System.out.println("\nBubble sort made fewer exchanges.");
            } else if (selectionExchanges < bubbleExchanges) {
                System.out.println("\nSelection sort made fewer exchanges.");
            } else {
                System.out.println("\nBoth algorithms made the same number of exchanges.");
            }

            boolean identical = true;
            for (int i = 0; i < bubbleArray.length; i++) {
                if (bubbleArray[i] != selectionArray[i]) {
                    identical = false;
                    break;
                }
            }
            System.out.println("Sorted arrays match: " + identical);
            System.out.println();
        }
    }

    public static int bubbleSort(int[] numbers) {
        int exchanges = 0;

        // compare neighbors and swap when out of order
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    exchanges++; // count each swap
                }
            }
        }
        return exchanges;
    }

    public static int selectionSort(int[] numbers) {
        int exchanges = 0;

        // find the smallest remaining value and move it into place
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
                exchanges++; // count only actual swaps
            }
        }
        return exchanges;
    }

    public static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
