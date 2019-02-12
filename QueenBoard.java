public class QueenBoard{

  private int[][]board;


  public QueenBoard(int size){
    board = new int[size][size];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          board[i][j] = 0;
        }
      }
    }

  public String toString(){
    String result = "";
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){

          //if (board[i][j] == -1){result += "Q "; j+=1;}

          if (j == board[i].length - 1){
            result += board[i][j] + "\n";
            } else {
            result += board[i][j] + " ";
            }
          }
        }

      return result;
    }

   private boolean addQueen(int r, int c){
     for (int i = 0; i < board.length; i++){
       if (board[r][i] != -1 && board[i][i] != -1){
         board[r][i] = 1;
       }
     }

     for (int i = 0; r - i >= 0 && c + i < board.length; i++) {
        board[r-i][c+i] = 1;
      }

     for (int j = 0; r + j < board.length && c + j < board.length; j++){
         board[r+j][c+j] = 1;
     }

    board[r][c] = -1; //Queen is represented by -1
    return true;
    }

  //Will prove v problematic later
   private boolean removeQueen(int r, int c){
     for (int i = 0; i < board.length; i++) {
      board[r][i] = 0;
    }

    for (int i = 1; r - i >= 0 && c + i < board.length; i++) {
      board[r-i][c+i] = 0;
    }

    for (int i = 0; r + i < board.length && c + i < board.length; i++) {
      board[r+i][c+i] = 0;
    }

    board[r][c] = 0;
    return true;
  }

  /**
 *@return false when the board is not solveable and leaves the board filled with zeros;
 *        true when the board is solveable, and leaves the board in a solved state
 *@throws IllegalStateException when the board starts with any non-zero value
 */

 public boolean solveHelper(int col){
   if (col == board.length){
     return true;
   }

   for (int i = 0; i < board.length; i++){
     if (addQueen(i, col)){
       if (solveHelper(col + 1)){
         return true;
       }
     } else {
       removeQueen(i, col);
     }
   }
   return false;
 }


 public boolean solve(){
   return solveHelper(0);
 }



    public static void main(String[] args) {
      QueenBoard test = new QueenBoard(8);
      test.addQueen(1,1);
      test.addQueen(5,3);
      test.removeQueen(1,1);
      test.removeQueen(5,3);
      System.out.println(test.toString());
    }


}
