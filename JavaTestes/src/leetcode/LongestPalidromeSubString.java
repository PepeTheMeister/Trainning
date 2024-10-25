package leetcode;

public class LongestPalidromeSubString {


    public static String longestPalidrome(String s){

        String palidrome = "";

        if(s.length() == 1 ){
            return s;
        }

        for(int i = 0; i < s.length(); i++){
            StringBuilder tempStr = new StringBuilder();
            tempStr.append(s.charAt(i));

            if(isPalidrome(tempStr.toString()) && tempStr.length() > palidrome.length()){
                palidrome = tempStr.toString();
            }

            if(i + 1 <= s.length() - 1){
                for(int j = i + 1; j < s.length(); j++){
                    tempStr.append(s.charAt(j));

                    if(isPalidrome(tempStr.toString()) && tempStr.length() > palidrome.length()){
                        palidrome = tempStr.toString();
                    }
                }
            }
            tempStr.setLength(0);
        }

        return palidrome;
    }

    public static boolean isPalidrome(String s){

        StringBuilder tempStr = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            tempStr.append(s.charAt(i));
        }

        return tempStr.toString().equalsIgnoreCase(s);

    }

    public class LongestPalindrome {

        public static void main(String[] args) {
            String input = "babad";  // Exemplo de teste
            System.out.println("Maior palíndromo substring: " + longestPalindrome(input));
        }

        // Método para encontrar o maior palíndromo substring
        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }

            int start = 0, end = 0;

            // Iterar sobre cada caractere da string
            for (int i = 0; i < s.length(); i++) {
                // Expansão para palíndromos de comprimento ímpar
                int len1 = expandAroundCenter(s, i, i);
                // Expansão para palíndromos de comprimento par
                int len2 = expandAroundCenter(s, i, i + 1);
                // Pega o maior comprimento encontrado
                int len = Math.max(len1, len2);

                // Atualiza as posições do início e fim do maior palíndromo encontrado
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            // Retorna a substring que representa o maior palíndromo
            return s.substring(start, end + 1);
        }

        // Função auxiliar que expande em torno de um centro
        private static int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Retorna o comprimento do palíndromo expandido
            return right - left - 1;
        }
    }

}
