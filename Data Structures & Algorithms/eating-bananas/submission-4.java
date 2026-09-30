class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    public boolean canEat(int[] piles, int mid, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            // if(hours>h) return false;
            if (piles[i] < mid)
                hours++;
            else {
                int hr = (piles[i] + mid - 1) / mid;
                hours += hr;
            }
        }

        return (hours <= h);
    }
    public int max(int[] arr) {
        int max = 0;

        for (int el : arr) {
            max = Math.max(max, el);
        }

        return max;
    }
}
