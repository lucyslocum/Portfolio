import java.util.Scanner;
public class MergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int x = input.nextInt();
        int[] data = new int[x];
        System.out.println("Enter the elements: ");
        for(int i=0; i<x; i++) {
            data[i] = input.nextInt();
        }
        System.out.print("Unsorted Array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        mergeSort(data);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
    public static void mergeSort(int[] data) {
        if (data.length > 1) {
            int midPoint = data.length / 2;
            int[] left = new int[midPoint];
            int[] right = new int[data.length - midPoint];
            for (int i = 0; i < midPoint; i++) {
                left[i] = data[i];
            }
            for (int i = midPoint; i < data.length; i++) {
                right[i - midPoint] = data[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(data, left, right);
        }
    }
    public static void merge(int[] data, int[] left, int[] right) {
        int x = 0;
        int y = 0;
        int z = 0;
        while (x < left.length && y < right.length) {
            if (left[x] <= right[y]) {
                data[z] = left[x];
                x++;
            }
            else {
                data[z] = right[y];
                y++;
            }
            z++;
        }
        if (x < left.length) {
            while (x < left.length) {
                data[z] = left[x];
                x++;
                z++;
            }
        }
        if (y < right.length) {
            while (y < right.length) {
                data[z] = right[y];
                y++;
                z++;
            }
        }
    }
}