import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(intToRoman(n));
    }

    private static String intToRoman(int n) {
        String s="";
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        for(String key:map.keySet()){
            while(n>=map.get(key)){
                s+=key;
                n-=map.get(key);
            }
        }
        return s;
    }

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i < s.length() - 1) {
                if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                    sum += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i++;
                } else {
                    sum += map.get(s.charAt(i));
                }
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
