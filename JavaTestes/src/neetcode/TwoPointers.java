package neetcode;

import java.util.*;

public class TwoPointers {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return res;

    }

    public static int maxArea(int[] heights) {
        int result = 0;

        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        while(leftPointer < rightPointer){
            int y = Math.min(heights[leftPointer], heights[rightPointer]);

            int x = rightPointer - leftPointer;
            int tempArea = x * y;
            result = Math.max(tempArea, result);

            if(y == heights[leftPointer]){
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }

        return result;
    }

    public static boolean isPalindrome(String s){

        int l = 0;


        s = s.replace(" ", "");
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        int r = s.length() - 1;
        while(l<r){
            if(!String.valueOf(s.charAt(l)).equalsIgnoreCase(String.valueOf(s.charAt(r)))){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

}
