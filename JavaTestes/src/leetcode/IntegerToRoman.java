package leetcode;

import java.util.*;

public class IntegerToRoman {
    private static final Map<Character, Integer> mapaRomano = new HashMap<>();

    static {
        mapaRomano.put('I', 1);
        mapaRomano.put('V', 5);
        mapaRomano.put('X', 10);
        mapaRomano.put('L', 50);
        mapaRomano.put('C', 100);
        mapaRomano.put('D', 500);
        mapaRomano.put('M', 1000);
    }


    public static String convertIntegerToRoman(int num){
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        StringBuilder resultado = new StringBuilder();


        for (int i = 0; i < valores.length; i++) {
            while (num >= valores[i]) {
                resultado.append(simbolos[i]);
                num -= valores[i];
            }
        }

        return resultado.toString();
    }

    public static int convertRomanToInteger(String s){
        int resultado = 0;
        int tamanho = s.length();

        for (int i = 0; i < tamanho; i++) {
            int valorAtual = mapaRomano.get(s.charAt(i));

            // Verifica se o próximo algarismo é maior (caso de subtração)
            if (i < tamanho - 1 && valorAtual < mapaRomano.get(s.charAt(i + 1))) {
                resultado -= valorAtual;
            } else {
                resultado += valorAtual;
            }
        }

        return resultado;
    }


}
