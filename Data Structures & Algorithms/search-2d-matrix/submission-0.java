class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;
        for (int i = 1; i < matrix.length; i++){
            if (target < matrix[i][0]){
                for (int j = 0; j < matrix[i].length; j++){
                    if (target == matrix[i - 1][j]) return true;
                }
                return false;
            }
        }
        return false;
    }
}
