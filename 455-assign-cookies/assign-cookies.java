public class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        if (cookieSize.length == 0) return 0;

        Arrays.sort(greed);
        Arrays.sort(cookieSize);

        int i = 0, j = 0;
        while (i < greed.length && j < cookieSize.length) {
            if (greed[i] <= cookieSize[j]) {
                i++; // Child is content
            }
            j++; // Move to next cookie
        }
        return i;
    }
}
