class Solution {
    public int solution(int[][] sizes) {int[] minL = new int[sizes.length];
		int[] maxL = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++) {
        	// 가로
        	minL[i] = Math.min(sizes[i][0], sizes[i][1]);
        	// 세로
        	maxL[i] = Math.max(sizes[i][0], sizes[i][1]);
		}
        
        // 최대값
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for (int i = 0; i < minL.length; i++) {
			if(minL[i] > max1) {
				max1 = minL[i];
			}
			// 동시 진행
			if(maxL[i] > max2) {
				max2 = maxL[i];
			}
		}
        
        return max1 * max2;
    }
}