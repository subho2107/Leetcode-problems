public class ImplementRand10UsingRand7 {
    public int rand7(){
        return (int) (Math.random()%7+1);
    }
    public int rand10() {
        int num1 = this.rand7();
        int num2 = 7;
        while (num1 > 5) {
            num2 = num1 - 5;
            num1 = rand7();
        }
        while (num2 == 7)
            num2 = rand7();
        return (num2 % 2 == 0 ? 5 : 0) + num1;
    }
}
