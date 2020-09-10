package bubbleSort;

import java.util.Arrays;

/**
 * Time Complexity O(n^2)
 * Space Complexity O(1)
 */

public class AllBubbleSort{
	public static void main(String[] args) {
		System.out.println("Sort");
		int frequency1 = 0;
		int frequency3 = 0;
		int frequency2 = 0;

		/*
		{5,8,6,3,9,2,1,7};   	用于比较1和2
		{3,4,2,1,5,6,7,8};		用于比较1和3
		 */
//		int[] arr1 = {5,8,6,3,9,2,1,7};
//		int[] arr2 = {5,8,6,3,9,2,1,7};
//		int[] arr3 = {5,8,6,3,9,2,1,7};

		int[] arr1 = {3,4,2,1,5,6,7,8};
		int[] arr2 = {3,4,2,1,5,6,7,8};
		int[] arr3 = {3,4,2,1,5,6,7,8};



		System.out.println("----1-------");
		frequency1 = bubbleSort1(arr1);
		System.out.println("finally"+ Arrays.toString(arr1)+", frequency"+frequency1);
		System.out.println("----2-------");
		frequency2 = bubbleSort2(arr2);
		System.out.println("finally"+ Arrays.toString(arr2)+", frequency"+frequency2);
		System.out.println("----3-------");
		frequency3 = bubbleSort3(arr3);
		System.out.println("finally"+ Arrays.toString(arr3)+", frequency"+frequency3);


	}


	/**
	 * [bubbleSort1 this is a bubbleSort1]
	 * @param  arr [int arr[]]
	 * @return     [int frequency]
	 */
	public static int bubbleSort1(int[] arr){
		int frequency = 0;
		for (int i = 0 ; i < arr.length-1 ; i++) {
			//boolean flag = true;
			for (int j = 0 ; j < arr.length-i-1 ; j++) {
				if ( arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
			//		flag = false;
					frequency++;
				}

				// if (flag) {
				// 	break;
				// }
			}
			System.out.println("******");
			System.out.println(Arrays.toString(arr));
		}
		return frequency;
	}

		
		//add flag , stop unnecessary comparation of rest tracks
	//第二版是为了减少趟数
	public static int bubbleSort2(int[] arr){
		int frequency = 0;
		for (int i = 0 ; i < arr.length-1 ; i++) {
			boolean flag = true;
			for (int j = 0 ; j < arr.length-i-1 ; j++) {
				if ( arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;

					frequency++;
				}
			}

			if (flag) {
					break;
				}
			System.out.println("******");
			System.out.println(Arrays.toString(arr));
		}
		return frequency;
	}

	//add sortBorder，stop unnecessary comparation of a track .eg :arr3
	/**
	 第三版是为了减少每趟比较次数
	 */
	public static int bubbleSort3(int[] arr){
		int frequency = 0;						// recode frequency
		int lastExchangeIndex = 0;				//recode the position of last exchange 
		int sortBorder = arr.length - 1;		//original border

		for (int i = 0; i < arr.length - 1 ; i++) {
			boolean flag = true;
			for (int j = 0;j < sortBorder ; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
					lastExchangeIndex = j;		//recode
					frequency++;
				}

			}

			if (flag) {
					break;
			}
			System.out.println("******");
			System.out.println(Arrays.toString(arr));

			sortBorder = lastExchangeIndex;
		}
		return frequency;
	}
}