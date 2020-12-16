import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String s;
    ArrayList<Integer> ids = new ArrayList<>();
    while((s=key.readLine())!=null){
      String row = s.substring(0,7);
      String col = s.substring(7);
      row = row.replace("F","0").replace("B","1");
      col = col.replace("L","0").replace("R","1");
      int r = Integer.parseInt(row,2);
      int c = Integer.parseInt(col,2);
      ids.add(r*8+c);
    }
    Collections.sort(ids);
    for(int i = 0; i < ids.size()-1; i++){
      if (ids.get(i) + 1 != ids.get(i+1)){
        System.out.println(ids.get(i) + " " + ids.get(i+1));
      }
    }
  }
}