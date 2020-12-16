import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader key=new BufferedReader(new FileReader("in.txt"));
    String[] fields = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
    String s;
    int valid = 0;
    String passport = "";
    ArrayList<String> passports = new ArrayList<>();
    while((s=key.readLine())!=null){
      if (s.length() == 0){
        passports.add(passport);
        passport = "";
      }
      else{
        passport += s + " ";
      }
    }
    passports.add(passport);
    for(String o : passports){
        String[] ln = o.split(" ");
        HashMap<String, String> hmap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(String i : fields){
          hmap.put(i, "");
        }
        for(String i : ln){
          String cat = i.substring(0, 3);
          String val = i.substring(4);
          hmap.put(cat, val);
        }
        for(String i : hmap.keySet()){
          String val = hmap.get(i);
          if (val.length() == 0){
            set.add(i);
            continue;
          }
          switch(i){
            case "byr":
            if (val.length() != 4 || val.compareTo("1920") < 0 || val.compareTo("2002")> 0)
              set.add(i);
            break;
            case "iyr":
            if (val.length() != 4 || val.compareTo("2010") < 0 || val.compareTo("2020")> 0)
              set.add(i);
            break;
            case "eyr":
            if (val.length() != 4 || val.compareTo("2020") < 0 || val.compareTo("2030")> 0)
              set.add(i);
            break;
            case "hgt":
            if(val.replaceAll("\\d+in","").length() == 0){
              int v = Integer.parseInt(val.replace("in",""));
              if (v<59 || v>76){
                set.add(i);
              }
            }
            else if(val.replaceAll("\\d+cm","").length() == 0){
              int v = Integer.parseInt(val.replace("cm",""));
              if (v<150 || v>193){
                set.add(i);
              }
            }
            else{
              set.add(i);
            }
            break;
            case "hcl":
            if(val.replaceAll("#[a-f0-9]{6}", "").length() != 0)
              set.add(i);
            break;
            case "ecl":
            if (!(val.equals("amb") || val.equals("blu") || val.equals("brn") || val.equals("gry") || val.equals("grn") || val.equals("hzl") || val.equals("oth")))
              set.add(i);
            break;
            case "pid":
            if (val.replaceAll("\\(|\\)|\\d{9}","").length() != 0)
              set.add(i);
            break;
          }
        }
        if (set.size() == 0){
          valid++;
        }
        else if (set.size() == 1){
          if (set.contains("cid")) valid++;
        }
    }
    System.out.println(valid);
  }
}