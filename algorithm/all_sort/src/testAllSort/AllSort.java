package testAllSort;

import java.util.*;

public class AllSort {
    /*
     选择排序
     时间：n^2
     空间 1
     */
    public static int[] selectionSort(int[] array){
        if (Objects.isNull(array) || array.length == 0) return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            boolean hasMin = false;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                    hasMin = true;
                }
            }
            if (hasMin){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return  array;
    }

    /*
    插入排序
    时间：n^2
    空间：1
     */

    public static int[] insertSort(int[] array){
        if (Objects.isNull(array) || array.length == 0) return array;
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }

    /*
    希尔排序
    最佳情况：T(n) = O(nlog2 n)
    最坏情况：T(n) = O(nlog2 n)
    平均情况：T(n) =O(nlog2n)
     */
    public static int[] shellSort(int[] array){
        if (Objects.isNull(array) || array.length == 0) return array;
        int temp,gap = array.length/2;
        while (gap > 0){
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int preIndex = i-gap;
                while (preIndex >= 0 && temp < array[preIndex]){
                    array[preIndex+gap]=array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /*
    归并排序（Merge Sort）
    最佳情况：T(n) = O(n)
    最差情况：T(n) = O(nlogn)
    平均情况：T(n) = O(nlogn)

    此版本是需要额外空间的
    两个函数：一个分治，一个合并


    https://zhuanlan.zhihu.com/p/101324119
    不需要额外空间的版本
     */
    public static int[] mergeSort1(int[] arrays){
        if(arrays.length < 2) return arrays;
        int mid = arrays.length/2;
        int[] left = Arrays.copyOfRange(arrays,0,mid);
        int[] right = Arrays.copyOfRange(arrays,mid,arrays.length);
        return merge(mergeSort1(left),mergeSort1(right));
    }
    // 合并两个有序数组
    private static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length){
                result[index] = right[j++];
            } else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i] <= right[j]){
                result[index] = left[i++];
            }else {
                result[index] = right[j++];
            }
        }
        return result;
    }


    /*
    快速排序 ：分治法，每个基准元素最终在最终位置上
    两个函数：一个递归结束，一个得到基准元素（在这个里面排序）
     */
    public static void quickSort(int[] array, int start, int end){
        if (start >= end) return;

        int pivotIndex = partitionA(array, start, end);

        quickSort(array,start,pivotIndex-1);
        quickSort(array,pivotIndex+1,end);


    }
    // left和right相等的时候就是所属位置
    private static int partitionA(int[] array, int start, int end) {
        int pivot = array[start];
        int leftIndex = start;
        int rightIndex = end;

        while (leftIndex != rightIndex){
            while (leftIndex < rightIndex && array[rightIndex] >= pivot){
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];
            while (leftIndex < rightIndex && array[leftIndex] <= pivot){
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }
        array[leftIndex] = pivot;
        return leftIndex;
    }

    /*
    堆排序
    parent = (i-1)/2;
    leftChild = i*2+1;
    rightChild = i*2+2;

    1. heapify 调整每个小三形状的最大值
    2. buildHeap从最后一个叶节点的父节点开始慢慢调整
    3. 排序: 把堆顶元素和最后一个元素交换，删除最后一个元素，再次对堆顶做heapify（控制n即可，不用真删除）
        取出k大数（取出堆顶元素，把堆顶元素和最后一个元素交换，删除最后一个元素，再次对堆顶做heapify）
     */

    private static void swap(List<Integer> array, int i, int max) {
        int temp = array.get(max);
        array.set(max,array.get(i));
        array.set(i,temp);
//        Collections.swap(array,i,max);
    }

    public static void heapify(List<Integer> array,int length, int i){
        if (i > array.size()) return;

        int leftChildIndex = 2*i+1;
        int rightChildIndex = 2*i+2;
        int max = i;

        if (leftChildIndex < length && array.get(leftChildIndex) > array.get(max)){
            max = leftChildIndex;
        }
        if (rightChildIndex < length && array.get(rightChildIndex) > array.get(max)){
            max = rightChildIndex;
        }
        if (max != i){
            swap(array, i, max);
            heapify(array, length, max);
        }
    }

    public static void buildHeap(List<Integer> list){
        int size = list.size();
        int parent = (size-1)/2;
        for (int i = parent; i >=0 ; i--) {
            heapify(list,size,i);
        }
    }

    public static void heapSort(List<Integer> list){
        buildHeap(list);
        for (int i = list.size()-1; i >=0 ; i--) {
            swap(list,0,i);
            heapify(list,i,0);
        }
    }

    /*
        堆的应用：寻找k个大数
     */


    public static List<Integer> TopK(List<Integer> list,int k){
        buildHeap(list);
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(list.get(0));
            swap(list,0,list.size()-1-i);
            heapify(list,list.size()-1-i,0);
        }
        return result;
    }
}
