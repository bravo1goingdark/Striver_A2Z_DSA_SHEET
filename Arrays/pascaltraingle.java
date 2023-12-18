import java.util.ArrayList;
import java.util.List;

public class pascaltraingle {
    // Pascal Triangle I
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            res.add(generateRow(i));
        }
        return res;
    }
    public List<Integer> generateRow(int row){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1 ; col < row ; col++){
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    // Pascal Triangle II
    public List<Integer> generateRow2(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add((int) 1);
    
        for (int col = 1; col <= row; col++) {
            ans = ans * (row - col + 1) / col;
            ansRow.add((int) ans);
        }
    
        return ansRow;
    }
    
    public List<Integer> getRow(int rowIndex) {
        return generateRow(rowIndex);
    }
    
}
