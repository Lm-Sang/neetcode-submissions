
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        HashSet<Integer> box = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            row.clear();
            column.clear();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    if (row.contains(num)) {
                        return false;
                    }
                    row.add(num);
                }

                if (board[j][i] != '.') {
                    int num = Character.getNumericValue(board[j][i]);
                    if (column.contains(num)) {
                        return false;
                    }
                    column.add(num);
                }
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                box.clear();

                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        if (board[i][j] != '.') {
                            int num = Character.getNumericValue(board[i][j]);

                            if (box.contains(num)) {
                                return false;
                            }

                            box.add(num);
                        }
                    }
                }
            }
        }

        return true;
    }
}