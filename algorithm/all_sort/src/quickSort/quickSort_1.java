package quickSort;


/**
 *
 bilateral Circulation：双边循环
 * Time Complexity O(n*Logn)   worst: O(n^2)
 *
 * quickSort_1思路:
 * 		1. 第一个元素定义pivot
 * 		2. 从数组左边找第一个大于pivot的, 包括与pivot自己比较（简化代码）, left
 * 		3. 从数组右边找第一个小于pivot的, right
 * 	    4. 交换left 和 right
 * 	    5. 最终left = right, 交换left和pivot
 *
 */

import java.util.Arrays;

public class quickSort_1 {

	static int frequency = 0;

	public static void quickSort(int[] arr, int startIndex,
								   int endIndex){

		if (startIndex >= endIndex) {
			return;
		}

		//得到基准元素
		int pivotIndex = partition(arr, startIndex, endIndex);

		//打印
		System.out.println("----------------");
		System.out.println(Arrays.toString(arr));

		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);
	}

	public static int partition(int[] arr, int startIndex,
								int endIndex){
		// 选取第一个元素为基准元素
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;

		while (left != right){
			//控制right指针, 大于pivot, 指针左移
			while (left < right && arr[right] > pivot){
				right--;
				frequency++;
			}

			//控制left指针, 小于pivot, 指针右移, 等号是与自己
			while (left < right && arr[left] <= pivot){
				left++;
				frequency++;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				frequency++;
			}
		}


		arr[startIndex] = arr[left];
		arr[left] = pivot;
		frequency++;

		return left;
	}

	public static void main(String[] args) {
		int[] arr1 = {8,7,6,2,4,5,1,3};
		System.out.println("source" + Arrays.toString(arr1));
		quickSort(arr1, 0, arr1.length-1);
		System.out.println("finally" + Arrays.toString(arr1));
		System.out.println(frequency);

	}
}