import java.io.*;
import java.util.*;
class pt2{
  public void main() throws IOException{
    BufferedReader key =new BufferedReader(new FileReader("in.txt"));
    String mask = "";
    HashMap<Long, Long> memory = new HashMap<>();
    String s;
    while((s=key.readLine())!=null){
      if (s.indexOf("mask")!=-1){
        mask = s.split(" ")[2];
      }
      else{
        String[] ln = s.split(" ");
        int address = Integer.parseInt(
          ln[0].substring(
            ln[0].indexOf("[")+1,
            ln[0].indexOf("]")
          )
        );
        long val = Long.parseLong(ln[2]);
        long n = address;
        n |= Long.parseLong(mask.replace("X", "0"),2);
        int floating = mask.replaceAll("[01]","").length();
        for(long i = 0; i < (long)Math.pow(2,floating); i++){
          long ans = n;
          int bit = 0;
          for(int j = 0; j < mask.length(); j++){
            if (mask.charAt(mask.length()-1-j) == 'X'){
              long b = (i & (1l << bit)) >> bit;
              ans = (ans & ~(1l << j)) |  ((b << j) & (1l << j)); 
              bit++;
            }
          }
          memory.put(ans, val);
        }
      }
    }
    long sum = 0;
    for(long l : memory.keySet()){
      sum += memory.get(l);
    }
    System.out.println(sum);

  }
}