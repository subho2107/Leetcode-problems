import java.util.Arrays;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num :
                nums) {
            xor ^= num;
        }
        int bitSet = 0;
        for (int bit = 0; bit < 31; bit++) {
            if ((xor&(1<<bit))!=0){
                bitSet = bit;
                break;
            }
        }
        int firstNum = 0;
        for (int num :
                nums) {
            if ((num & (1 << bitSet))!=0){
                firstNum ^= num;
            }
        }
        int secNum  = xor^firstNum;
        return new int[]{firstNum, secNum};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(arr)));
    }
}
