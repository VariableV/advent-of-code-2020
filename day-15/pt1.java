import java.io.*;
import java.util.*;
class pt1{
  public void main() throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String[] ln = key.readLine().split(",");
    ArrayList<Integer> spoken = new ArrayList<>();
    HashMap<Integer,Integer> lastspoken = new HashMap<>();
    HashSet<Integer> spokenalready = new HashSet<>();
    int $ = 0;
    for(String s : ln){
      spoken.add(Integer.parseInt(s));
      lastspoken.put(Integer.parseInt(s), $++);
    }
    int orig = spoken.size();
    for(int i = spoken.size(); i < 20; i++){
      int last = spoken.get(i-1);
      int f0 = -1, f1 = -1;
      for(int j = i-1; j >= 0; j--){
        if (last == spoken.get(j)){
          if (f1 == -1){
            f1 = j;
          }else{
            f0 = j;
            break;
          }
        }
      }
      if (f1 != -1 && f0 != -1){
        spoken.add(f1-f0);
      }
      else{
        spoken.add(0);
      }
    }
    System.out.println(spoken);
    //System.out.println(spoken.get(spoken.size()-1));
  }
}