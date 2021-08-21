public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        char []arr = new char[word.length()+1];
        arr[0] = 'a';
        for (int i = 1; i <= word.length(); i++) {
            arr[i] = word.charAt(i-1);
        }
        int ans = 0;
        for(int i = 0; i < arr.length-1; i++){
            char a = arr[i], b = arr[i+1];
            if (a > b)
            {
                char temp = a;
                a = b;
                b = temp;
            }
            ans += Math.min(b-a, a-'a'+'z'-b+1)+1;
        }
        return ans;
    }
}
