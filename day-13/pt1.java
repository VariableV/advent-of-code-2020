import java.io.*;
import java.util.*;
class pt1{
  public void main()throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    int n = Integer.parseInt(key.readLine());
    String s = key.readLine();
    s = s.replaceAll("[x,]"," ");
    String[] ln = s.split("\\s+");
    int diff = Integer.MAX_VALUE;
    int ans = -1;
    for(int i = 0; i < ln.length; i++){
      int num = Integer.parseInt(ln[i]);
      int res = (n % num == 0) ? 0: (n/num+1)*num-n;
      if (res >= 0 && res < diff){
        diff = res;
        ans = num * res;
      }
    }
    System.out.println(ans);
  }
}