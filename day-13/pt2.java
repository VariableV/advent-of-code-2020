import java.io.*;
import java.util.*;
class pt2{
  private long inv(long a, long m) { 
    long m0 = m, t, q; 
    long x0 = 0, x1 = 1; 
    if (m == 1) return 0l;
    while (a > 1) { 
      q = a / m; 
      t = m; 
      m = a % m;a = t; 
      t = x0; 
      x0 = x1 - q * x0; 
      x1 = t; 
    } 
    if (x1 < 0) x1 += m0; 
    return x1; 
  }
  private long crt(ArrayList<Long> num, ArrayList<Long> rem, int k) {
    long prod = 1l; 
    for (int i = 0; i < k; i++) 
      prod *= num.get(i); 
    
    long result = 0l;
    
    for (int i = 0; i < k; i++) {
      long pp = prod / num.get(i);
      result += rem.get(i) * inv(pp, num.get(i)) * pp;
    }
    
    return result % prod; 
  }
  public void main()throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    key.readLine();
    String s = key.readLine();
    String[] ln = s.split(",");
    ArrayList<Long> rem = new ArrayList<>(), mod = new ArrayList<>();
    for(int i = 0; i < ln.length; i++){
      if (ln[i].equals("x")) continue;
      long n = Long.parseLong(ln[i]);
      rem.add((-i+n*100)%n);
      mod.add(n);
    }
    System.out.println(rem);
    System.out.println(mod);
    System.out.println(crt(mod, rem, rem.size()));
  }
}