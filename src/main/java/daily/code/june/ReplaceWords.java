package daily.code.june;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dictionary, sentence));
    }
    public static String replaceWords(List<String> dictionary, String sentence){
        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }
        StringBuilder result = new StringBuilder();
        for (String word: sentence.split(" ")) {
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(findRoot(word, root));
        }
        return  result.toString();
    }

    private static String findRoot(String word, Trie root){
        Trie current = root;
        StringBuilder prefix = new StringBuilder();
        for(char c: word.toCharArray()){
            int index= c - 'a';
            if(current.children[index] != null){
                prefix.append(c);
                current = current.children[index];
                if(current.isWord){
                    return prefix.toString();
                }else{
                    return prefix.toString();
                }
            } else {
                break;
            }
        }
        return word;
    }
}

class Trie {
    boolean isWord;
    Trie[] children;

    public Trie(){
        this.isWord = false;
        this.children= new Trie[26];
    }

    public void insert(String word){
        Trie current = this;
        for(char c: word.toCharArray()){
            int index= c-'a';
            if(current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
            if(current.isWord){
                break;
            }
            current.isWord = true;
        }
    }
}
