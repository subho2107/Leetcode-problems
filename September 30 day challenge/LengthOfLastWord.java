public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String [] arr = s.split(" ");
        if(arr.length == 0 || arr[arr.length - 1].equals(""))
            return 0;
        return arr[arr.length - 1].length();
    }
}
