package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static boolean existSum(int target, List<Integer>sums, int deep, Map<Integer,Boolean> memo ){
        if(target == 0) return true;
        if(memo.containsKey(target)) return memo.get(target);
        if(target < 0 || deep == 2 ) return false;
        for (Integer s : sums) {
            var res = target - s;
            if (res >= 0){
                var newList = new ArrayList<>(sums);
                newList.remove(s);
                if(existSum(res, newList, deep + 1,memo)){
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }


    public static boolean stringOnDictionary(String str, List<String>Dictionary,Map<String,Boolean> memo){
        if(memo.containsKey(str)) return memo.get(str);
        if(str.equals("")) return true;
        for (String d : Dictionary) {
            if(str.indexOf(d)==0){
                var word_less = str.substring(d.length());
               if( stringOnDictionary(word_less,Dictionary,memo)==true){
                   memo.put(word_less, true);
                   return true;
               }
            }
        }
        memo.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        List<Integer>sums = List.of(3,4,8,9,0,33,1);
        Map<Integer, Boolean> memo_int = new HashMap<>();
        int target = 34;
        System.out.println(existSum(target, sums, 0, memo_int ));
        Map<String, Boolean> memo_str = new HashMap<>();
        System.out.println(stringOnDictionary("applepie", List.of("apple","apple","pear","pie"), memo_str));
        System.out.println(stringOnDictionary("applepeer", List.of("apple","apple","pear","pie"), memo_str));
    }
}
