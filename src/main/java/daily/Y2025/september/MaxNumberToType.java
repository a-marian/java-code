package daily.Y2025.september;

public class MaxNumberToType {

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("leet code", "lt"));
    }
        public static int canBeTypedWords(String text, String brokenLetters) {
            String[] words = text.split(" ");
            int wordsWithBL = 0;
            int wordsToQuit = 0;
            for(String word: words){
                for(char f: brokenLetters.toCharArray()){
                    if(word.indexOf(f) != -1){
                        wordsWithBL++;
                    }
                }
                if(wordsWithBL > 0){
                    wordsToQuit++;
                }
            }
            return words.length-wordsToQuit;
        }

        public static int  canBeTypedWordsFast(String text, String brokenLetters) {
            int count = 1;
            boolean flag = true;
            boolean[] c = new boolean[26];
            for(int i = 0; i < brokenLetters.length(); i++) c[brokenLetters.charAt(i) - 97] = true;
            for(char ch : text.toCharArray()) {
                if(ch == ' ') {
                    flag = true;
                    count++;
                }
                else if(c[ch - 97] && flag) {
                    count--;
                    flag = false;
                }
            }
            return count < 1 ? 0 : count;
        }



}
