public class QueenBoard{

  private int[][]board;
  private int n;

  public QueenBoard(int size){
    n = size;
  }

  // private boolean addQueen(int r, int c){}
  // private boolean removeQueen(int r, int c){}

  public String toString(){
    String result = "";
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (j == n-1){
            result += "_" + "\n";
          } else {
            result += "_" + " ";
            }
          }
        }
      return result;
    }

    public static void main(String[] args) {
      QueenBoard test = new QueenBoard(4);
      System.out.println(test.toString());
    }


}
