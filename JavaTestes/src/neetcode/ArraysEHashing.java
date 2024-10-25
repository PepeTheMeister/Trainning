package neetcode;

import java.util.*;

public class ArraysEHashing {


    public static boolean hasDuplicate(int[] nums){

        Set<Integer> map = new HashSet<>();

        for (int num : nums) {
            if (map.contains(num)) {
                return true;
            } else {
                map.add(num);
            }
        }


        return false;
    }

    public static  int[] topKFrequent(int[] nums, int k){


            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            List<int[]> arr = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                arr.add(new int[] {entry.getValue(), entry.getKey()});
            }
            arr.sort((a, b) -> b[0] - a[0]);

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr.get(i)[1];
            }
            return res;
    }

    public static int[] productExceptSelf(int[] nums){

        int[] result = new int[nums.length];

        return execute(nums, 0, result);
    }

    public static int[] execute(int[] nums, int index, int[] result){
        if(index == nums.length){
            return result;
        }

        int c = 1;
        for(int i = 0; i < nums.length; i++){
            if(i != index){
                c *= nums[i];
            }
        }
        result[index] = c;
        index += 1;
        execute(nums, index, result);

        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());


    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        if(strs.isEmpty()){
            return "";
        }

        for(String s: strs){
            sb.append(s).append(",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1,"");
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        if(str.isEmpty() || str.trim().isEmpty()){
            strs.add("");
        }
        else{
            strs = List.of(str.split(","));
        }
        return strs;
    }

    public static int longestConsecutive(int[] nums){
        Set<Integer> setI = new HashSet<>();

        for(int n : nums){
            setI.add(n);
        }

        int longest = 0;

        for(int n : nums){
            if(!setI.contains(n - 1)){
                int count = 0;
                while(setI.contains(n + count)){
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }

    public static boolean validAnagram(String s, String t){

        HashMap<String, List<String>> res = new HashMap<>();

        String[] ss = new String[]{s,t};

        for(String str : ss){
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        return res.size() == 1;
    }

}
