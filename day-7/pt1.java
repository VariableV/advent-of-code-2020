import java.io.*;
import java.util.*;
class pt1 {
  public void main() throws IOException {
    BufferedReader key = new BufferedReader(new FileReader("in.txt"));
    String s;
    ArrayList<String> arr = new ArrayList<>();
    while((s=key.readLine())!=null){
      arr.add(s);
    }
    key.close();
    HashMap<String, ArrayList<String>> mat = new HashMap<>();
    for(String i : arr){
      String[] ln = i.split(" ");
      ArrayList<String> children = new ArrayList<>();
      if (i.indexOf("no other bags")==-1){
        String t = i.substring(i.indexOf("contain") + 8);
        String[] tl = t.split(", ");
        for(String j : tl){
          String[] z = j.split(" ");
          children.add(z[1] + " " + z[2]);
        }
      }
      mat.put(ln[0] + " " + ln[1], children);
    }
    int good = 0;
    for(String color : mat.keySet()){
      if (!color.equals("shiny gold")){
        HashSet<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        ArrayList<String> ch = mat.get(color);
        for(String i : ch){
          bfs.add(i);
          visited.add(i);
        }
        while(bfs.size() > 0){
          String top = bfs.poll();
          if (top.equals("shiny gold")){
            good++;
            break;
          }
          ch = mat.get(top);
          for(String i : ch){
            if(!visited.contains(i)){
              bfs.add(i);
              visited.add(i);
            }
          }
        }
      }
    }
    System.out.println(good);
  }
}