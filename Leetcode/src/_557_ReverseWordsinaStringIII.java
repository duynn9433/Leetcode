public class _557_ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse().toString());
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
