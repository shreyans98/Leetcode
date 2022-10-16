class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++){
                //Only when we encounter the first letter we will start with the recursive approach
                if(board[i][j] == word.charAt(0))
                    if(backtrack(board, word, i, j, 0, new boolean[rows][columns]))
                    return true;
            }
        }
        
        return false;
        
    }
    
    public boolean backtrack(char[][] board, String word, int rows, int columns, int index, boolean visited[][]) {
        //base case -> when we reach the end of the word, it means every character is present and visited
        if(index == word.length())
            return true;
        
        //conditions for out of bounds check and if the character is previously visited or not
        //Here, we will ignore the border characters as they will be covered under different logic written for 'res'
        if(rows < 0 || columns < 0 || rows >= board.length || 
           columns >=  board[0].length || board[rows][columns] != word.charAt(index) || visited[rows][columns])
            return false;
        
        
        //mark the position as visited
        visited[rows][columns] = true;

        //check for the adjacent charcters in the board
        boolean res = (backtrack(board, word, rows-1, columns, index+1, visited) ||
                       backtrack(board, word, rows+1, columns, index+1, visited) ||
                       backtrack(board, word, rows, columns-1, index+1, visited) ||
                       backtrack(board, word, rows, columns+1, index+1, visited));
        
        //not choose option, hence marked visited as false
        visited[rows][columns] = false;
        return res;
            
        
    }
}