public class RecursiveBinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                return binarySearch(arr, left, mid - 1, target);

            return binarySearch(arr, mid + 1, right, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11};
        int target = 7;

        int result = binarySearch(numbers, 0, numbers.length - 1, target);
        if (result == -1)
            System.out.println("Element not found.");
        else
            System.out.println("Element found at index: " + result);
    }
}
