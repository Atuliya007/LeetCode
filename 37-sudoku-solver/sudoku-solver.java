class Solution {
    boolean[][] rowmap ;
        boolean[][] colmap ;
        boolean[][] boxmap ;
    public void solveSudoku(char[][] board) {
         rowmap = new boolean[9][9];
         colmap = new boolean[9][9];
         boxmap = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                int val=board[i][j]-'0';
                int box= (i/3)*3+(j/3);
                rowmap[i][val-1]=true;
                colmap[j][val-1]=true;
                boxmap[box][val-1]=true;
            }
        }
        helper(board);
     }
     public boolean helper(char[][] board){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]!='.')continue;
                    for(char k='1';k<='9';k++){
                        int box=i/3*3+j/3;
                        int idx=k-'1';
                    if(!rowmap[i][idx] && !colmap[j][idx] && !boxmap[box][idx]){
                       board[i][j] = k;
                        rowmap[i][idx]=true;
                        colmap[j][idx]=true;
                        boxmap[box][idx]=true;
                        if(helper(board)){
                            return true;
                        }
                        board[i][j]='.';
                        rowmap[i][idx]=false;
                        colmap[j][idx]=false;
                        boxmap[box][idx]=false;
                    }
                }
                return false;
            }
     }
    return true;
}
}