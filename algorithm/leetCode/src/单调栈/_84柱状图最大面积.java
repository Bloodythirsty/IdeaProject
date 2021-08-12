package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangkangkang
 * @date 2021/08/12 12:57
 */
public class _84柱状图最大面积 {
    public static void main(String[] args) {
//        int[] arr = {2,1,5,6,2,3};
//        largestRectangleArea(arr);
        int[] arr1 = {2,1,3,3,3,3,3,4,1,2};
        largestRectangleArea2(arr1);
    }

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        if(heights.length == 0) return res;
        if(heights.length == 1) return heights[0];

        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int currHigh = heights[stack.pop()];
                while(!stack.isEmpty() && heights[stack.peek()] == currHigh){
                    stack.pop();
                }
                int currWide = 0;
                if(stack.isEmpty()){
                    currWide = i;
                }else{
                    currWide = i - stack.peek() -1;
                }

                res = Math.max(res,currHigh*currWide);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int currHigh = heights[stack.pop()];
            while(!stack.isEmpty() && heights[stack.peek()] == currHigh){
                stack.pop();
            }
            int currWide = 0;
            if(stack.isEmpty()){
                currWide = heights.length;
            }else{
                currWide = heights.length - stack.peek() - 1;
            }
            res = Math.max(res,currHigh*currWide);
        }
        return res;
    }

    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

}
