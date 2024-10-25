package leetcode;

public class ReverseConvertor {

    public static int reverse(int x){

        StringBuilder yStr = new StringBuilder();

        int y = 0;

        String xStr = String.valueOf(x);

        boolean isNegative = false;

        if(xStr.contains("-")){
            xStr = xStr.replace("-", "");
            isNegative = true;
        };

        for(int i = xStr.length() - 1; i >= 0; i--){
            yStr.append(xStr.charAt(i));
        }
        try{

            y = Integer.parseInt(yStr.toString());

            y = !isNegative ? y : y / -1;
        }
        catch (NumberFormatException e){
            return 0;
        }
        if (y == Integer.MIN_VALUE) {
            return 0;
        }

        return y;
    }
}
