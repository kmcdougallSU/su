package algorithms.homework.hw4;

public class MergeSort {
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int length1 = m - l + 1;
        int length2 = r - m;

        int[] leftArr = new int[length1];
        int[] rightArr = new int[length2];

        // copy left and right sorted array into temp arrays
        for (int i = 0; i < length1; i++) {
            leftArr[i] = arr[l + i];
        }

        for (int j = 0; j < length2; j++) {
            rightArr[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // merge two sorted halves into original array
        while (i < length1 && j < length2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of leftArr[] if any
        while (i < length1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[] if any
        while (j < length2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
//         int[] arr = new int[]{};
//         int[] arr = new int[]{0,1,2,3};
//         int[] arr = new int[]{0,1,2,3,4};
//         int[] arr = new int[]{3,1,4,1,5,9,2,6,5};
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        // display initial array
        System.out.println("initial array");
        for (int n : arr
        ) {
            System.out.print(n + " ");
        }

        // display sorted array
        sort(arr, 0, arr.length - 1);
        System.out.println("\nsorted array");
        for (int n : arr
        ) {
            System.out.print(n + " ");
        }
    }
}
