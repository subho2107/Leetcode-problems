import java.io.*;
import java.util.*;

public class ComplexNumberMultiplication {
    public void getRealAndImgParts(String num, int [] real, int [] img, int ind){
        boolean realCompl = false, realNeg = false, imgNeg = false;
        for(char ch : num.toCharArray()){
            if(ch == '+')
            {
                realCompl = true;
                continue;
            }
            if(ch == '-'){
                if(realCompl)
                    imgNeg = true;
                else
                    realNeg = true;
                continue;
            }
            if(ch == 'i')
                continue;
            if(!realCompl)
                real[ind] = real[ind]*10 + Character.getNumericValue(ch);
            else
                img[ind] = img[ind]*10 + Character.getNumericValue(ch);
        }
        if(realNeg)
            real[ind] *= -1;
        if(imgNeg)
            img[ind] *= -1;
    }
    public String complexNumberMultiply(String num1, String num2) {
        int [] real = new int[2], img = new int[2];
        getRealAndImgParts(num1, real, img, 0);
        getRealAndImgParts(num2, real, img, 1);
        System.out.println(Arrays.toString(real));
        System.out.println(Arrays.toString(img));
        int ansReal = real[0]*real[1] - img[0]*img[1];
        int ansImg = real[0]*img[1]+img[0]*real[1];
        String ans = Integer.toString(ansReal)+"+"+Integer.toString(ansImg)+"i";
        return ans;
    }
}
