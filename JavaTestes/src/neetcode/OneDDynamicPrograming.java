package neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OneDDynamicPrograming {

    public int climbStairs(int n){

        int one = 1;
        int two = 1;

        for(int i = 0; i < n; i ++){
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }

}
