public class ArrayResizer {

    // Return true if every row in array is non zero
    public static boolean isNonZeroRow(int[][] array2D, int r) {
        // Loop Through array rows
        for (int i = 0; i < array2D[r].length; i++) {
            // If anything is zero in row return false
            if (array2D[r][i] == 0) {
                return false;
            }
        }
        // Otherwise return true
        return true;
    }

    // Return the number of rows in array2D that contain all non-zero values
    public static int numNonZeroRows(int[][] array2D) {
        // Define count to keep track of non zero rows
        int count = 0;
        // loop through all rows
        for (int r = 0; r < array2D.length; r++) {
            // Add to count if it is non zero
            if (isNonZeroRow(array2D, r)) {
                count++;
            }
        }
        return count;
    }

    // Create an array with no zeros
    public static int[][] resize(int[][] array2D) {
        // Get the number of non zero rows
        int numRows = numNonZeroRows(array2D);
        
        // Create a new array with the same amount of rows
        int[][] resizedArray = new int[numRows][];

        // Array position for loop
        int index = 0;

        // For every row
        for (int r = 0; r < array2D.length; r++) {
            // If tis non zero copy it over to the new array
            if (isNonZeroRow(array2D, r)) {
                resizedArray[index] = array2D[r];
                // Move up a position
                index++;
            }
        }
        // Return new array
        return resizedArray;
    }
}
