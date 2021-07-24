public class _1455 {
    public static void main(String[] args) {
        String sentence = "love errichto jonathan dumb";
        String prefix = "dumb";
        int prefixOfWord = isPrefixOfWord(sentence, prefix);
        System.out.println("prefixOfWord = " + prefixOfWord);
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int wordStart = 0;
        int wordEnd = 0;
        int wordCount = 0;
        for(int i=1;i<sentence.length();i++){
            if(sentence.charAt(i) == ' '){
                wordEnd = i-1;
                wordCount++;
            }
            if(wordEnd >= wordStart){
                if(searchPrefix(sentence,searchWord,wordStart,wordEnd)) return wordCount;
            }
            if(sentence.charAt(i) == ' ' && i+1 < sentence.length()){
                wordStart = i+1;
            }
        }
        wordCount++;
        if (searchPrefix(sentence,searchWord,wordStart,sentence.length()-1)) return wordCount;
        return -1;
    }

    static boolean searchPrefix(String sentence,String searchWord,int wordStart,int wordEnd){
        int length = wordEnd - wordStart + 1;
        int i = 0;
        for(;i<length;i++){
            if(i>=searchWord.length()) return true;
            if(searchWord.charAt(i) != sentence.charAt(wordStart+i)) return false;
        }
        return i == searchWord.length();
    }
}
