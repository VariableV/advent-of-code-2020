import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String s;
    int valid = 0;
    while((s=key.readLine())!=null){
      String[] tokens = s.split("\\s+");
      String[] range = tokens[0].split("-");
      int min = Integer.parseInt(range[0]), max = Integer.parseInt(range[1]);
      char letter = tokens[1].charAt(0);
      String check = tokens[2];
      valid += (check.charAt(min-1)==letter ^ check.charAt(max-1)==letter) ? 1 : 0;
    }
    System.out.println(valid);
  }
}