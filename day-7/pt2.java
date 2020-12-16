import java.io.*;
import java.util.*;
class Node{
  public String name;
  public int count;
  public Node(String n, int c){
    name = n;
    count = c;
  }
}
class pt2 {
  int recurse(HashMap<String, ArrayList<Node>> mat, String current, ArrayList<Node> children){
    if (children.size() == 0) return 0;
    int sum = 0;
    for(Node i : children){
      sum += i.count + i.count*recurse(mat, i.name, mat.get(i.name));
    }
    return sum;
  }
  public void main() throws IOException {
    BufferedReader key = new BufferedReader(new FileReader("in.txt"));
    String s;
    ArrayList<String> arr = new ArrayList<>();
    while((s=key.readLine())!=null){
      arr.add(s);
    }
    key.close();
    HashMap<String, ArrayList<Node>> mat = new HashMap<>();
    for(String i : arr){
      String[] ln = i.split(" ");
      ArrayList<Node> children = new ArrayList<>();
      if (i.indexOf("no other bags")==-1){
        String t = i.substring(i.indexOf("contain") + 8);
        String[] tl = t.split(", ");
        for(String j : tl){
          String[] z = j.split(" ");
          children.add(new Node(z[1] + " " + z[2], Integer.parseInt(z[0])));
        }
      }
      mat.put(ln[0] + " " + ln[1], children);
    }
    System.out.println(recurse(mat,"shiny gold",mat.get("shiny gold")));
  }
}