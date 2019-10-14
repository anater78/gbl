package gblerningLesson3Task1;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("HW lesson3");

        List <String> al = new ArrayList<>();

        Map<String,Integer> ml = new TreeMap<>();

        al.add("Yellow");
        al.add("Green");
        al.add("Blue");
        al.add("Brown");
        al.add("White");
        al.add("Red");
        al.add("Orange");
        al.add("Pink");
        al.add("Gray");
        al.add("Black");
        al.add("Yellow");
        al.add("Green");
        al.add("Blue");
        al.add("Brown");
        al.add("White");

        for(String str : al){
            System.out.println("FULL LIST = " + str + " " + ml.containsKey(str));
            int count = ml.containsKey(str)? ml.get(str):0;
            ml.put(str,++count);

        }
        for(String s : ml.keySet()){

           Integer value = ml.get(s);
            System.out.println("Counter " + s + " = " + value);

        }

    }
}
