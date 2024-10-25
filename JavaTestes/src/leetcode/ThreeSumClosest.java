package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSumClosest {

    static Map<String, String> mapDigits = new HashMap<>();
    static{
        mapDigits.put("2", "abc");
        mapDigits.put("3", "def");
        mapDigits.put("4", "ghi");
        mapDigits.put("5", "jkl");
        mapDigits.put("6", "mno");
        mapDigits.put("7", "pqrs");
        mapDigits.put("8", "tuv");
        mapDigits.put("9", "wxyz");
    }


    /*public int threeSumClosest(int[] nums, int target){

        int size = nums.length;


    }*/

    public static List<String> letterCombinations(String digits){


        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), digits, 0);

        return result;
    }

    // Função auxiliar de backtracking
    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Caso base: se o tamanho da string atual for igual ao tamanho dos dígitos, adicionar a combinação na lista
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Obter o conjunto de letras correspondente ao dígito atual
        String letters = mapDigits.get(String.valueOf(digits.charAt(index)));

        // Iterar sobre cada letra possível para o dígito atual
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Adicionar a letra atual
            backtrack(result, current, digits, index + 1);  // Chamada recursiva para o próximo dígito
            current.deleteCharAt(current.length() - 1);  // Remover a última letra e tentar outra opção
        }
    }
}
