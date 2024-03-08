package algorithms.homework.hw5;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr, n);

        for (int i = n - 1; i > 0; i--) {
            // move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public void buildMaxHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i; // root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            // swap
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, largest, n);
        }
    }

    public static void main(String[] args) {
        /*
            test cases
            1. unique elements [12, 11, 13, 5, 6, 7]
            2. duplicate elements [12, 12, 5, 6, 6]
            3. sorted ascending order [1, 2, 3, 4, 5, 6]
            4. sorted descending order [6, 5, 4, 3, 2, 1]
            5. empty array []
            6. single element [1]
            7. negative elements [-4, -1, -9, -2, -3, -5]

            I chose these test cases as I found they tested
            most of the edge cases I could think of when sorting
            a list of integers.
         */

        HeapSort hs = new HeapSort();

        int[][] testCases = {
                {12, 11, 13, 5, 6, 7},
                {12, 12, 5, 6, 6},
                {1, 2, 3, 4, 5, 6},
                {6, 5, 4, 3, 2, 1},
                {},
                {1},
                {-4, -1, -9, -2, -3, -5}
        };

        for (int[] testCase : testCases) {
            System.out.print("Unsorted array: ");
            for (int num : testCase) {
                System.out.print(num + " ");
            }

            hs.sort(testCase);

            System.out.print("\nSorted array: ");
            for (int num : testCase) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
}
