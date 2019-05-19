package org.code.challenge;

public class SpriralMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] {
			{1, 2, 4, 5, 6, 9},
			{9, 5, 2, 1, 8, 9},
			{4, 5, 6, 7, 8, 9},
			{2, 4, 5, 6, 2, 4}
		};
		
        int i = 0, k = 0, l = 0, m, n;
        //k is starting row index
        //m is ending row index
        //l is starting column index
        //n is ending column index
        
        m = matrix.length;
		n = matrix[0].length;
		
		while(k < m && l < n) {
			
			for(i = l; i < n; i++) {
				System.out.print(matrix[k][i] + " ");
			}
			k++;
			
			for(i = k; i < m; i++) {
				System.out.print(matrix[i][n-1] + " ");
			}
			n--;
			
			//if(k < m) {
				for(i = n - 1; i >= l; i-- ) {
					System.out.print(matrix[m-1][i] + " ");
				}
				m--;
			//}
			
			for(i = m - 1; i >= k; i-- ) {
				System.out.print(matrix[i][l] + " ");
			}
			l++;
		}
	}
}
