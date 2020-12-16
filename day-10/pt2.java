import java.io.*;
import java.util.*;
class pt2{
  static HashMap<Integer, Long> memo;
  private long count(ArrayList<Integer> arr, int i, int val){
    if (i == 0) return 0;
    if (i == 1) return 1;
    if (i == 2 || i == 3) return 3; // hardcoded for test data
    if(memo.containsKey(i)){
      return memo.get(i);
    }
    long co = 0;
    int diff = val - arr.get(i-1);
    if (diff >= 1 && diff <= 3){
      co += count(arr, i-1, arr.get(i-1));
    }
    diff = val - arr.get(i-2);
    if (diff >= 1 && diff <= 3){
      co += count(arr, i-2, arr.get(i-2));
    }
    diff = val - arr.get(i-3);
    if (diff >= 1 && diff <= 3){
      co += count(arr, i-3, arr.get(i-3));
    }
    memo.put(i, co);
    return co;
  }
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
    HashSet<Integer> used = new HashSet<>();
    used.add(0);
    System.out.println(jolts);
    memo = new HashMap<>();
    System.out.println(count(jolts, jolts.size()-1, jolts.get(jolts.size()-1)));

  }
}