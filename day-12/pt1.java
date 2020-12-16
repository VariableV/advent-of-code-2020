import java.io.*;
import java.util.*;
class pt1{
  public void main()throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    int dir = 0;
    int x = 0, y = 0;
    String s;
    while((s=key.readLine())!=null){
      char a = s.charAt(0);
      int arg = Integer.parseInt(s.substring(1));
      switch(a){
        case 'N':
        y += arg;
        break;
        case 'S':
        y -= arg;
        break;
        case 'E':
        x += arg;
        break;
        case 'W':
        x -= arg;
        break;
        case 'L':
        dir += arg;
        break;
        case 'R':
        dir -= arg;
        break;
        case 'F':
        int xmul = (int)Math.cos(Math.toRadians(dir));
        int ymul = (int)Math.sin(Math.toRadians(dir));
        x += xmul*arg;
        y += ymul*arg;
        break;
      }
    }
    System.out.println(Math.abs(x) + Math.abs(y));
  }
}