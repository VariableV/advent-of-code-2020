import java.io.*;
import java.util.*;
class pt2{
  private int xrotate(int x, int y, int angle){
    return x*(int)Math.cos(Math.toRadians(angle)) - y*(int)Math.sin(Math.toRadians(angle));
  }
  private int yrotate(int x, int y, int angle){
    return y*(int)Math.cos(Math.toRadians(angle)) + x*(int)Math.sin(Math.toRadians(angle));
  }
  public void main()throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    int x = 10, y = 1;
    int sx = 0, sy = 0;
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
        int ty = yrotate(x,y,arg);
        x = xrotate(x,y,arg);
        y = ty;
        break;
        case 'R':
        ty = yrotate(x,y,-arg);
        x = xrotate(x,y,-arg);
        y = ty;
        break;
        case 'F':
        sx += arg*x;
        sy += arg*y;
        break;
      }
    }
    System.out.println(Math.abs(sx) + Math.abs(sy));
  }
}