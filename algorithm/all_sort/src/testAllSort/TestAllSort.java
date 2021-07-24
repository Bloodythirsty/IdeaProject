package testAllSort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAllSort {

    @Test
    public void testSelectSort(){
        int[] arrays = {7,8,2,3,5,0,1,1,3};
        int[] ints = AllSort.selectionSort(arrays);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void testInsertSort(){
        int[] arrays = {7,8,2,3,5,0,1,1,3};
        int[] ints = AllSort.insertSort(arrays);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void testShellSort(){
        int[] arrays = {7,8,2,3,5,0,1,1,3};
        int[] ints = AllSort.shellSort(arrays);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void testMergeSort1(){
        int[] arrays = {7,8,2,3,5,0,1,1,3};
        int[] ints = AllSort.mergeSort1(arrays);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void testQuickSort(){
        int[] arrays = {7,8,2,3,5,0,1,1,3};
        AllSort.quickSort(arrays,0,arrays.length-1);
        for (int anInt : arrays) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void testheapify(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        AllSort.heapSort(list);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
    }

    @Test
    public void testTopK(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        List<Integer> integers = AllSort.TopK(list, 4);
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }


}
