//https://www.geeksforgeeks.org/problems/jump-game/1?page=2&company%5B%5D=Amazon&category%5B%5D=Dynamic%2520Programming&sortBy=


class Solution {
    static int canReach(int[] A, int N) {
        // code here
        //Tc: O(n) Sc: O(1)
        int lastGoodIndex = N - 1;

        for (int i = N - 2; i >= 0; i--) {
            if (i + A[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0 ? 1 : 0;
    }
}
