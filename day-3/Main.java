import java.io.*;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    char[][] mat = new char[323][31];
    String s;
    int r = 0;
    while((s=key.readLine()) != null){
      mat[r] = s.toCharArray();
      r++;
    }
    key.close();

    int[][] slopes = {{1,1}, {3,1}, {5,1}, {7,1}, {1,2}};
    long ans = 1;
    for(int[] slope : slopes){
      int i = 0, j = 0;
      int count = 0;
      while(i<r){
        if (mat[i][j] == '#') count++;
        i+=slope[1];
        j+=slope[0];
        j%=31;
      }
      ans *= count;
    }
    System.out.println(ans);
  }
}