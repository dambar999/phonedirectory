package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CheckGroupAnagrams {


    public static void main(String[]args){
        System.out.println("Group Anagram test case 1..");
        String words1[]={"CAT","MAT","ATC"};
        findGroupAnagram(words1);

        System.out.println("Group Anagram test case 2..");
        String words2[]={"CAT","MAT","ATC","BGD"};
        findGroupAnagram(words2);

        System.out.println("Group Anagram test case 3..");
        String words3[]={"CAT","MAT","ATC","DOG","GOD","MATH","ATM"};
        findGroupAnagram(words3);

        System.out.println("Group Anagram test case 4..");
        String words4[]={"CAT","MAT","ATC","CARROT","ROTCAR"};
        findGroupAnagram(words4);


    }

   static  void findGroupAnagram(String []words){
       HashMap<String, List<String> > map = new HashMap<>();


        for(int i=0;i<words.length;i++){

            char tempArray[] = words[i].toCharArray();
            // sort tempArray
            Arrays.sort(tempArray);
            String tempStr=new String(tempArray);
            // return new sorted string

            if(map.containsKey(tempStr)){
               map.get(tempStr).add(words[i]);
            }else{
                List<String> listWord=new ArrayList<String>();
                listWord.add(words[i]);
                map.put(tempStr,listWord);

            }

        }
     map.forEach((k,v)->System.out.print(v));
    System.out.println();


    }




}
