class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        //initially assigned the grid with default value
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++) 
                board[i][j] = '.';
        //to store the final result
        List<List<String>> res = new ArrayList<List<String>>();
        
        solve(0, board, res);
        
        return res;

    }
    /*
    Idea is that we will take 1 column and check for all rows in that column if we can place the queen.
    For checking purpose we will only check for left upper diagonal, left side and left lower diagonal.
    Because we will start placing the queen from left side so we will not check for right side and anyways we do not have to check for up side and down side
    */
    public void solve(int col, char[][] board, List<List<String>> res) {
        if(col == board.length) {//if fwe reach the end then we will return the board positions
            res.add(construct(board));
            return;
        }
        //taking 1 row at a time
        for(int row =0;row<board.length;row++) {
            if(validate(board, row, col)) { //method call for validating the position
                board[row][col] = 'Q';
                solve(col+1, board, res); //if true then we will move to the next column
                board[row][col] = '.'; //backtrack to primary decision point if we don;t get the answer in further steps
            }
        }
    }
    //for validation of position
    public boolean validate(char[][] board, int row, int col) {
        //to keep the duplicates
        int duprow = row;
        int dupcol = col;
        //left upper diagonal validation
        while(row>=0 && col >=0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        //left lower diagonal validation
        while(col >=0 && row < board.length) {
            if(board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        
        row = duprow;
        col = dupcol;
        
        //left column validation
        while(col >=0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }
        
        return true;
    }
    //method to convert the array to list(column will be fixed here)
    public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        
        for(int i=0;i<board.length;i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }
}