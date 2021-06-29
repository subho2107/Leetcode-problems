public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        while (true){
            boolean check = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.startsWith(part, j))
                {
                    check = true;
                    s = s.substring(0, j)+s.substring(j+part.length());
                    break;
                }
            }
            if (!check)
                break;
        }
        return s;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new RemoveAllOccurrencesOfASubstring().removeOccurrences("daabcbaabcbc", "abc"));
    }
}
