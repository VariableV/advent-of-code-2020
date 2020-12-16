import java.io.*;
import java.util.*;
class pt1{
  public void main() throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String s;
    ArrayList<Integer> jolts = new ArrayList<>();
    jolts.add(0);
    while((s=key.readLine())!=null){
      jolts.add(Integer.parseInt(s));
    }
    Collections.sort(jolts);
    jolts.add(jolts.get(jolts.size()-1) + 3);
    int one = 0, three = 0;
    for(int i = 1; i < jolts.size(); i++){
      int a = jolts.get(i), b = jolts.get(i-1);
      a -= b;
      if (a == 1){
        one ++;
      }
      else if (a == 3){
        three ++;
      }
    }
    //System.out.println(jolts);
    System.out.println(one * three);
  }
}