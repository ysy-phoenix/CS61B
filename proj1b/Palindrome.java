public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++)
            deque.addLast(word.charAt(i));
        return deque;
    }

    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        String palindrome = "";
        for (int i = 0; i < word.length(); i++)
            palindrome += d.removeLast();
        return word.equals(palindrome);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        String palindrome = "";
        for (int i = 0; i < word.length() / 2; i++)
            palindrome += d.removeLast();
        for (int i = 0; i < word.length() / 2; i++)
            if (!cc.equalChars(palindrome.charAt(i), word.charAt(i)))
                return false;
        return true;
    }
}
