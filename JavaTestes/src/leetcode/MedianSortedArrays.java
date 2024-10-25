package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {

    public static double medianSortedArrays(int[] nums1, int[] nums2){
        double result = 0;



        List<Integer> lista = new ArrayList<>();

        // Adicionar elementos do primeiro array
        for (int num : nums1) {
            lista.add(num);
        }

        // Adicionar elementos do segundo array
        for (int num : nums2) {
            lista.add(num);
        }

        List<Integer> listaSorted = lista.stream().sorted().toList();

        if(listaSorted.size() % 2 == 0){
            int meioInteiro = listaSorted.size() / 2;
            result = (double) (listaSorted.get(meioInteiro - 1) + listaSorted.get(meioInteiro)) / 2;
        }
        else{
            result = listaSorted.get((listaSorted.size() - 1) / 2);
        }
        return result;
    }
}
