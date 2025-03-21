import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int x = input.nextInt();
        int[] data = new int[x];
        System.out.println("Enter the elements: ");
        for(int i=0; i<x; i++){
            data[i] = input.nextInt();
        }
        System.out.println("Unsorted Array: " );
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        insertionSort(data);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int current = data[i];
            int replace;
           for (replace = i - 1; replace >= 0 && data[replace] > current; replace--) {
                if (data[replace] > current) {
                    data[replace + 1] = data[replace];
                    data[replace] = current;
                }
           }
        }
    }
}