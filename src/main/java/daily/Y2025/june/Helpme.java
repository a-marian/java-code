package daily.Y2025.june;

public class Helpme {
    public static void main(String[] args) {
        String input = "453, 222,3,44,4.5,,,";
        // Split the string by comma and trim whitespace
        String[] result = input.split(",", -1); // -1 to include trailing empty strings

        // Ensure the array is exactly length 8
        String[] finalArray = new String[8];
        for (int i = 0; i < 8; i++) {
            finalArray[i] = result[i].trim(); // Trim whitespace from each element

        }

        // Print the resulting array
        System.out.println("Array length: " + finalArray.length);
        for (int i = 0; i < finalArray.length; i++) {
            System.out.println("Element " + i + ": '" + finalArray[i] + "'");
        }
    }
}
