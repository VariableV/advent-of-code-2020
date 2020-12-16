class Instruction{
  public String op;
  public int arg;
  public Instruction(String o, int a){
    op = o;
    arg = a;
  }
  public String toString(){
    return String.format("%s %d", op,arg);
  }
}