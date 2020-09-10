public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] temp = version1.split("\\.");
        int n = temp.length;
        temp = version2.split("\\.");
        int m = temp.length;
        n = Math.max(n, m);
        temp = version1.split("\\.");
        int[] arr1 = new int[n];
        for (int pos = 0; pos < temp.length; pos++) {
            arr1[pos] = Integer.parseInt(temp[pos]);
        }
        temp = version2.split("\\.");
        int[] arr2 = new int[n];
        for (int pos = 0; pos < temp.length; pos++) {
            arr2[pos] = Integer.parseInt(temp[pos]);
        }
        for (int pos = 0; pos < n; pos++) {
            if (arr2[pos] > arr1[pos]) {
                return -1;
            } else if (arr2[pos] < arr1[pos])
                return 1;
        }
        return 0;
    }
}
