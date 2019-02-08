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

          if (board[i][j] == -1){result += "Q "; j+=1;}

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
       board[r][i] = 1;
       board[i][i] = 1;
     }

    board[r][c] = -1; //Queen is represented by -1
    return true;
    }


  // private boolean removeQueen(int r, int c){}


    public static void main(String[] args) {
      QueenBoard test = new QueenBoard(8);
      test.addQueen(1,1);
      System.out.println(test.toString());
    }


}
