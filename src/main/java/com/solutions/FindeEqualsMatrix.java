package com.solutions;

public class FindeEqualsMatrix {
	static int mat[][] = new int[5][7];
	int row = 5;
	int col = 7;

	public void initMat() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mat[i][j] = randomNum();
			}
		}
	}

	public int processMat() {

		int moverow = 0;
		int movecol = 0;
		int result = 0;

		for (int i = row; i > 0; i--) {
			for (int j = col; j > 0; j--) {
				if ((i * j) % 2 == 0) {
					moverow = row - i;
					movecol = col - j;
					for (int m = 0; m <= moverow; m++) {
						for (int n = 0; n <= movecol; n++) {
							int girls = 0;
							int boys = 0;
							for (int s = m; s<i+m; s++) {
								for (int g = n; g<j+n; g++) {
									if (mat[s][g] == 0) {
										girls++;
									} else {
										boys++;
									}

									}
								}
							if (girls == boys) {
								if((i*j)>result){
									result = i*j;
								}

								}
							}
						}
					}
				}
			}
		
		return result;
	}

	public int randomNum() {
		return Math.random() > 0.5 ? 1 : 0;
	}

	public static void printMat() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}
	
	public int processMat2(){
		int result = 0;
		for(int i=row-1;i>=0;i--){
			for(int j = col-1;j>=0;j--){
				int [] b = new int[] {i,j};
				for(int k = i;k>=0;k--){
					for(int l=j;l>=0;l--){
						int [] a = new int [] {k,l};
						if(FindeEqualsMatrix.boyEqualGirl(a, b, mat)){
							int scope=(b[0]-a[0]+1)*(b[1]-a[1]+1);
							result = result<scope? scope:result;
						}
					}
				}
			}
		}
	    return result;
	}
	
	public static boolean boyEqualGirl(int [] a,int[] b,int[][] mat){
		int boy = 0;
		int girl = 0;
		if(a[0]==b[0]&&a[1]==b[1]){
			return true;
		}
		for(int i = a[0];i<=b[0];i++){
			for(int j = a[1];j<=b[1];j++){
				if(mat[i][j]==0){
					boy++;
				}else{
					girl++;
				}
			}
		}
		return boy==girl;
	}

	public static void main(String[] args) {
		FindeEqualsMatrix HelloPiggy = new FindeEqualsMatrix();
		HelloPiggy.initMat();
		HelloPiggy.printMat();
		//System.out.println(HelloPiggy.boyEqualGirl(new int[] {1,1},new int[] {1,1}, HelloPiggy.getMat()));
//		System.out.println(HelloPiggy.processMat2());
		
		System.out.println(HelloPiggy.processMat());

	}

	public static int[][] getMat() {
		return mat;
	}

	public static void setMat(int[][] mat) {
		FindeEqualsMatrix.mat = mat;
	}
	
	

}