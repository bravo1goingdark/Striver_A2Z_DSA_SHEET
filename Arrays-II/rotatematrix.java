import java.util.Arrays;

class rotatematrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int[] nums : mat){
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();

        rotate(mat);

        System.out.println();
        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int[] num : matrix){
            System.out.println(Arrays.toString(num));
        }
        

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                swap(matrix, i, start, end);
                start++;
                end--;
            }
        }
    }

    private static void swap(int[][] matrix, int row , int start , int end) {
        int temp = matrix[row][start];
        matrix[row][start] = matrix[row][end]; 
        matrix[row][end] = temp;
    }
}    