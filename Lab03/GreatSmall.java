import java.util.Scanner;
import java.util.Arrays;

public class GreatSmall {

    static class MinMaxResult {
        int min;
        int max;

        MinMaxResult(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int n : numbers) if (n < min) min = n;
        return min;
    }

    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int n : numbers) if (n > max) max = n;
        return max;
    }

    public static MinMaxResult findBoth(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;
        
        int min = numbers[0];
        int max = numbers[0];
        
        for (int n : numbers) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new MinMaxResult(min, max);
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("--- Command Line Input ---");
            int[] clArray = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                clArray[i] = Integer.parseInt(args[i]);
            }
            displayResults(clArray);
        } else {
            System.out.println("No command line arguments found.");
        }

        System.out.println("\n--- Scanner Input ---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        
        if (size > 0) {
            int[] scArray = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                scArray[i] = sc.nextInt();
            }
            displayResults(scArray);
        }
        sc.close();
    }

    public static void displayResults(int[] arr) {
        MinMaxResult result = findBoth(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Calculated Min: " + result.min);
        System.out.println("Calculated Max: " + result.max);
    }
}