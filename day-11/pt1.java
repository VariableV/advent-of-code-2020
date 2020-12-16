import java.io.*;
import java.util.*;
class pt1{
  private ArrayList<ArrayList<Character>> deepcopy(ArrayList<ArrayList<Character>> arr){
    ArrayList<ArrayList<Character>> copy = new ArrayList<>();
    for(int i = 0; i < arr.size(); i++){
      ArrayList<Character> narr = new ArrayList<>();
      for(int j = 0; j < arr.get(i).size(); j++){
        narr.add(arr.get(i).get(j));
      }
      copy.add(narr);
    }
    return copy;
  }
  public void main()throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    ArrayList<ArrayList<Character>> mat = new ArrayList<>();
    String s;
    while((s=key.readLine())!=null){
      ArrayList<Character> arr = new ArrayList<>();
      for(char c : s.toCharArray()){
        arr.add(c);
      }
      mat.add(arr);
    }
    ArrayList<ArrayList<Character>> save = new ArrayList<>(mat);
    int[][] delta = {{-1,-1}, {-1,1},{1,1},{1,-1},{-1,0},{0,-1},{1,0},{0,1}};
    int r = mat.size(), c = mat.get(0).size();
    while(true){
      save = deepcopy(mat);
      // transform mat
      boolean modified = false;
      for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
          char ch = save.get(i).get(j);
          if (ch == 'L'){
            // check surroundings
            int occ = 0;
            for(int[] d : delta){
              int nr = i+d[0], nc = j+d[1];
              if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
              char z = save.get(nr).get(nc);
              if (z == '#'){ 
                occ++; 
                break; 
              }
            }
            if (occ == 0){
              modified = true;
              ArrayList<Character> m = mat.get(i);
              m.set(j, '#');
              mat.set(i, m);
            }
          }
          else if (ch == '#'){
            int mt = 0;
            for(int[] d : delta){
              int nr = i+d[0], nc = j+d[1];
              if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
              char z = save.get(nr).get(nc);
              if (z == '#'){
                mt ++;
              }
            }
            if (mt >= 4){
              modified =true;
              ArrayList<Character> m = mat.get(i);
              m.set(j, 'L');
              mat.set(i, m);
            }
          }
        }
      }
      if (!modified){
        break;
      }
    }
    int len = 0;
    for(int i =0 ;i < r; i++){
      len += mat.get(i).toString().replaceAll("[^#]","").length();
    }
    System.out.println(len);
  }
}