package neetcode;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public static int maxProfit(int[] prices){

        int maxProfit = 0;
        int sell = 1;
        int buy = 0;

        while(buy < prices.length - 1 && sell <= prices.length - 1){
            if(prices[buy] > prices[sell]){
                buy = sell;
            }
            else{
                maxProfit = Math.max(prices[sell] - prices[buy], maxProfit);

                if(sell == prices.length - 1){
                    buy++;
                }
            }
            sell++;
        }

        return maxProfit;
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;

        int sizeStr = s.length();

        int l = 0;
        int r = 0;

        StringBuilder sb = new StringBuilder();
        while(l < sizeStr && r < sizeStr){
            if(!sb.toString().contains(String.valueOf((s.charAt(r))))){
                sb.append(s.charAt(r));
                r++;
                result = Math.max(result, sb.toString().length());
            }
            else{
                sb.setLength(0);
                l++;
                r = l;
            }

        }

        return result;
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> occor = new HashMap<>();
        int res = 0;
        int l = 0;


        for(int r = 0; r < s.length(); r++){
            if(!occor.containsKey(s.charAt(r))){
                occor.put(s.charAt(r), 1);
            }
            else{
                occor.put(s.charAt(r), occor.get(s.charAt(r)) + 1);
            }
            while((r - l + 1) - occor.size() > k){
                occor.put(s.charAt(l), occor.get(s.charAt(l)) -1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
