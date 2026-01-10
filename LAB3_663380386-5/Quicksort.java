// Quicksort.java
public class Quicksort {
    public static void quicksort(int[] a) {
        if (a == null || a.length <= 1) return;
        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quicksort(a, low, p - 1);
            quicksort(a, p + 1, high);
        }
    }

    // Lomuto partition scheme
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    // Demo main: if args provided they are parsed as integers, otherwise uses a sample array
    public static void main(String[] args) {
        int[] arr;
        if (args.length > 0) {
            arr = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }
        } else {
            arr = new int[] {33, 10, 55, 71, 29, 3, 18, 42};
        }

        System.out.println("Before:");
        printArray(arr);

        quicksort(arr);

        System.out.println("After:");
        printArray(arr);
    }
}    