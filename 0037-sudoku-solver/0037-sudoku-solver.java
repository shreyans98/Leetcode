class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
        
    }
    
    public boolean solve(char[][] board) {
        for(int row =0;row<board.length;row++){
            for(int column = 0; column< board.length; column++) {
                
                //as soon as we get a empty position we will check for all the numbers to be inserted into that position recursively
                if(board[row][column] == '.'){
                    for(char choice ='1';choice<='9';choice++) {
                        if(validate(board, row, column, choice)){//validation to check if the operation satisfies all 3 conditions
                            board[row][column] = choice;
                            
                            if(solve(board))
                                return true;
                            else
                                //if invalid at some case, then undo the changes
                                board[row][column] = '.';
                            
                        }
                    }
                    //here it means the element is already visited
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validate(char[][] board, int row, int column, char choice) {
        for(int i=0;i<9;i++){
            if(board[i][column] == choice) //same column validation
                return false;
            
            if(board[row][i] == choice) //same row validation
                return false;
            
            if(board[3 * (row/3) + i%3][3 * (column/3) + i / 3] == choice)
                return false;
            

        }
        return true;
        
    }
}