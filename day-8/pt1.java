import java.io.*;
import java.util.*;
class pt1{
  public void main() throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    ArrayList<Instruction> instrs = new ArrayList<>();
    String s;
    while((s=key.readLine())!=null){
      String[] ln = s.split(" ");
      instrs.add(new Instruction(ln[0], Integer.parseInt(ln[1])));
    }
    key.close();
    int accumulator = 0, ip = 0;
    HashSet<Integer> visited = new HashSet<>();
    while(ip >= 0 && ip < instrs.size()){
      if (visited.contains(ip)){
        break;
      }
      Instruction curr = instrs.get(ip);
      visited.add(ip);
      switch(curr.op){
        case "acc":
        accumulator += curr.arg;
        case "nop":
        ip++;
        break;
        case "jmp":
        ip += curr.arg;
        break;
      }
    }
    System.out.println(accumulator);
  }
}