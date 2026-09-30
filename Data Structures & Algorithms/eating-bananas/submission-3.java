class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = max(piles);

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canEat(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }
    public boolean canEat(int[] piles, long mid, int h) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            // if(hours>h) return false;
            if (piles[i] < mid)
                hours++;
            else {
                long hr = (piles[i] + mid - 1) / mid;
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
