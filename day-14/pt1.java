import java.io.*;
class pt1{
  public void main() throws IOException{
    BufferedReader key =new BufferedReader(new FileReader("in.txt"));
    long mask = 0;
    long clear = 0;
    long[] memory = new long[100000];
    String s;
    while((s=key.readLine())!=null){
      if (s.indexOf("mask")!=-1){
        String m = s.split(" ")[2];
        clear = Long.parseLong(m.replaceAll("[10]","0").replaceAll("X","1"),2);
        mask = Long.parseLong(m.replace("X","0"),2);
      }
      else{
        String[] ln = s.split(" ");
        int address = Integer.parseInt(
          ln[0].substring(
            ln[0].indexOf("[")+1,
            ln[0].indexOf("]")
          )
        );
        long n = Long.parseLong(ln[2]);
        memory[address] = (n & clear) | mask;
      }
    }
    long sum = 0;
    for(long l : memory){
      sum += l;
    }
    System.out.println(sum);
  }
}