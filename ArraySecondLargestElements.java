import java.util.Scanner;

/**
 * ArraySecondLargestElement
 *
 * Description:
 * This program finds the second largest element in an integer array.
 * It traverses the array once, keeping track of the largest and second largest numbers.
 *
 * Algorithm:
 * 1. Initialize two variables: largest and secondLargest to Integer.MIN_VALUE.
 * 2. Traverse the array:
 *      - If current number > largest, update secondLargest = largest, largest = number.
 *      - Else if number > secondLargest and number != largest, update secondLargest.
 * 3. After traversal, secondLargest holds the second largest element.
 *
 * Use Cases:
 * - Finding top 2 scores in a game
 * - Ranking data
 * - Identifying threshold values in datasets
 *
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(1) - only two extra variables used
 */
public class ArraySecondLargestElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Initialize largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse array to find largest and second largest
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; // previous largest becomes second largest
                largest = num;           // update largest
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;     // update second largest if applicable
            }
        }

        // Handle edge cases: array has less than 2 distinct elements
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element exists (array may have duplicates or only one element).");
        } else {
            System.out.println("Second largest element is: " + secondLargest);
        }

        sc.close();

        // Optional Test Cases
        System.out.println("\nExample Test Cases:");
        int[] test1 = {10, 25, 7, 30, 18};
        int[] test2 = {5, 5, 5};
        int[] test3 = {-10, -20, -5, -15};

        System.out.println("Test 1: Expected 25, Got: " + findSecondLargest(test1));
        System.out.println("Test 2: Expected None, Got: " + findSecondLargest(test2));
        System.out.println("Test 3: Expected -10, Got: " + findSecondLargest(test3));
    }

    /**
     * Utility method to find second largest element in an array
     * @param arr input array
     * @return second largest integer or null if not found
     */
    public static Integer findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return null; // No second largest exists
        } else {
            return secondLargest;
        }
    }
}
