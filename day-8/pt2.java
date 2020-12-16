import java.io.*;
import java.util.*;
class pt2{
  static int accumulator;
  public void main() throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    ArrayList<Instruction> instrs = new ArrayList<>();
    String s;
    while((s=key.readLine())!=null){
      String[] ln = s.split(" ");
      instrs.add(new Instruction(ln[0], Integer.parseInt(ln[1])));
    }
    key.close();
    for(int i = 0; i < instrs.size(); i++){
      Instruction instr = instrs.get(i);
      // save and change instruction
      String oldop = instr.op;
      if (oldop.equals("jmp")){
        instrs.get(i).op = "nop";
      }
      else if (oldop.equals("nop")){
        instrs.get(i).op = "jmp";
      }
      else{
        continue;
      }
      // run program
      accumulator = 0;
      if (run(instrs)){
        System.out.println(accumulator);
        break;
      }
      // restore op
      instrs.get(i).op = oldop;
    }
  }
  private boolean run(ArrayList<Instruction> instrs){
    int ip = 0;
    HashSet<Integer> visited = new HashSet<>();
    while(ip >= 0 && ip < instrs.size()){
      if (visited.contains(ip)){
        return false;
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
    return true;
  }
}