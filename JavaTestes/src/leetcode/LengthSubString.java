package leetcode;

public class LengthSubString {

    public static int lengthOfLongestSubstring(String s) {

        String sub = "";

        for(int i = 0; i < s.length(); i++){
            StringBuilder subTemp = new StringBuilder(String.valueOf(s.charAt(i)));
            if(i + 1 <= s.length() - 1){
                for(int j = i +1; j<s.length(); j++){
                    if(!subTemp.toString().contains(String.valueOf(s.charAt(j)))){
                        subTemp.append(s.charAt(j));
                    }
                    else{
                        break;
                    }
                }
            }
            sub = subTemp.length() > sub.length() ? subTemp.toString() : sub;

        }

        return sub.length();
    }
}
