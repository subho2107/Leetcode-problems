public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for (int pos = s.length() - 1, fact = 1; pos >= 0; pos--, fact *= 26)
            result += (s.charAt(pos) - 'A' + 1) * fact;
        return result;
    }

}
