package quickSort;

import java.util.Arrays;


/**
 * unilateral Circulation
 *
 * 思路：
 * 		1. mark标记第一个index
 * 		2. 从右边找一个比pivot小的
 * 		3. mark向前移动一个，调换mark与小的，pivot不动
 * 		4. 重复完后，pivot与mark交换
* 		5. 二分法继续。
 */
public class quickSort_2{


	public static void quickSort(int[] arr, int startIndex, int endIndex){

		if (startIndex >= endIndex) {
			return ;
		}

		int pivotIndex = partition(arr, startIndex, endIndex);
		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);

	}

	public static int partition(int[] arr, int startIndex, int endIndex){
		int pivot = arr[startIndex];
		int mark = startIndex;

		for (int i = startIndex + 1; i < endIndex + 1 ; i++) {
			if (pivot > arr[i]) {
				mark++;
				int temp = arr[i];
				arr[i] = arr[mark];
				arr[mark] = temp;
			}
		}

		//exchange pivote with mark
		arr[startIndex] = arr[mark];
		arr[mark] = pivot;
		return mark;
	}


	 public static void main(String[] args) {
	 	int[] arr1 = {8,7,6,2,4,5,1,3};
	 	System.out.println("source" + Arrays.toString(arr1));
	 	quickSort(arr1, 0, arr1.length-1);
	 	System.out.println("finally" + Arrays.toString(arr1));
	 	//System.out.println(frequency);
	 }
}