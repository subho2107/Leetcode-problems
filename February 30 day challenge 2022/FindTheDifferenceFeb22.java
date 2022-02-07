import java.io.*;

public class FindTheDifferenceFeb22 {
    public char findTheDifference(String s, String t) {
        char [] arrS = s.toCharArray(), arrT = t.toCharArray();
        for(char ch = 'a'; ch <= 'z'; ch++){
            int freqInS = 0, freqInT = 0;
            for(char c : arrS){
                if(c == ch)
                    freqInS++;
            }
            for(char c : arrT){
                if(c == ch)
                    freqInT++;
            }
            if(freqInT - freqInS > 0)
                return ch;
        }
        return 'a';
    }
}
