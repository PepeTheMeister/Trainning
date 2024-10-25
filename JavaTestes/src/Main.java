import neetcode.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println(ArraysEHashing.decode(ArraysEHashing.encode(new ArrayList<>())));
        //System.out.println(Arrays.toString(ArraysEHashing.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        //System.out.println(Arrays.toString(ArraysEHashing.productExceptSelf(new int[]{1, 2, 4, 6})));
        //System.out.println(SlidingWindow.maxProfit(new int[]{2,1,4}));
        //System.out.println(SlidingWindow.lengthOfLongestSubstring("zxyzxyz"));
        //System.out.println(new BackTracking().combinationSum(new int[]{2,5,6,9}, 9));
        System.out.println(ArraysEHashing.validAnagram("jam", "jar"));
    }

    public static List<List<Integer>> xorCount(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[i]);
            result.add(oneList);


        }

        return result;
    }

    public static String longestDiverseString(int a, int b, int c) {

        int counta = 0;
        int countb = 0;
        int countc = 0;

        int tentativas = 0;

        StringBuilder sb = new StringBuilder();

        boolean offW = true;

        int len = a + b + c;

        if(len == 0){
            return "";
        }

        while(sb.length() <= len && offW){
            int nAlea = (int) (Math.random() * 3);

            if(nAlea == 0 && counta < a){
                counta++;
                sb.append("a");
            }
            else if(nAlea == 1 && countb < b){
                countb++;
                sb.append("b");
            }
            else if(nAlea == 2 && countc < c){
                countc++;
                sb.append("c");
            }

            if(sb.length() == len){
                if(!sb.toString().contains("aaa") && !sb.toString().contains("bbb")
                        && !sb.toString().contains("ccc")){
                    offW = false;
                }
                else{
                    sb.setLength(0);
                    counta = 0;
                    countb = 0;
                    countc = 0;
                    tentativas++;
                    if(tentativas == 100){
                        offW = false;
                        return "";
                    }
                }
            }

        }
        return sb.toString();
    }
}