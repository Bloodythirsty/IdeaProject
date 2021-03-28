package niuKe;

import org.junit.Test;

public class Squrt {

    public int sqrt (int x) {
        // write code here
        int low = 0;
        int high  = x/2;
        int middle = high/2;
        while(low <= high){
            /*


            这儿 middle*middle 可能算数溢出！！！
            利用 x/middle == middle
            大于小于的时候注意顺序,还要注意middle不能为0，如 sqrt_1

             */
            if(middle*middle == x) return middle;
            else if(middle*middle > x) high = middle -1;
            else low = middle +1;
            middle = low+(high-low)/2;

        }
        if (low*low==x) return low;
        return high;
    }


    //正确结果
    public int sqrt_1 (int x) {
        // write code here
        if(x<2) return x;
        int low = 1;
        int heigh  = x/2;
        int middle;
        while(low <= heigh){
            middle = low+(heigh-low)/2;
            if(x/middle == middle) return middle;
            else if(x/middle < middle) heigh = middle -1;
            else low = middle +1;
        }
        //low和high都有可能是最终值
        if(low*low==x) return low;
        return heigh;
    }

    //转为long计算
    public int sqrt_3 (int x) {
        long x1 = (long)x;
        long low = 0;
        long high  = x1/2;
        long middle = high/2;
        while(low <= high){
            if(middle*middle == x1) return (int)middle;
            else if(middle*middle > x1) high = middle -1;
            else low = middle +1;
            middle = low+(high-low)/2;
        }
        if (low*low==x1) return (int)low;
        return (int)high;
    }

    @Test
    public void test(){
        System.out.println(sqrt_1(1518972676));
        System.out.println(38974*38974);
    }
}
