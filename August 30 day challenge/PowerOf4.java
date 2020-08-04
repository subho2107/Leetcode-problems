public class PowerOf4 {
    public boolean isPowerOfFour(int num) {
        if(num < 0)return false;
        float pow = (float)(Math.log(num)/Math.log(4));
        return pow==(int)pow;

    }
}
