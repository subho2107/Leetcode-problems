public class AddDigitsFeb22 {
    public int addDigits(int num) {
        while(num / 10 != 0){
            int sum = 0;
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    public int addDigits2(int num) {
        if(num == 0)
            return 0;
        else
            return num %9==0?9:(num%9);
    }
}
