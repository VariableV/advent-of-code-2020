import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String s;
    int[] freq = new int[26];
    int total = 0, groupcount = 0;
    while((s=key.readLine())!=null){
      if (s.length() == 0){
        for(int i = 0; i < 26; i++){
          if (freq[i] == groupcount){
            total++;
          }
        }
        freq = new int[26];
        groupcount = 0;
      }
      else{
        for(char c : s.toCharArray()){
          freq[c-'a']++;
        }
        groupcount++;
      }
    }
    System.out.println(total);
  }
}