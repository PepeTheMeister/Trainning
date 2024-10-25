package neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stack {




    public boolean isValid(String s){
        Map<String, String> optionsMap = new HashMap<>();
        optionsMap.put(")", "(");
        optionsMap.put("}", "{");
        optionsMap.put("]", "[");

        List<String> lstE = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(optionsMap.containsKey(String.valueOf(c))){
                if(!lstE.isEmpty() && lstE.get(lstE.size() - 1).equals(optionsMap.get(String.valueOf(c)))){
                    lstE.remove(lstE.size() -1);
                }
                else{
                    return false;
                }
            }
            else{
                lstE.add(String.valueOf(c));
            }

        }

        return lstE.isEmpty();
    }
}
