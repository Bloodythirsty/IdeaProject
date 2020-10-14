import org.junit.Test;

import java.util.Random;

import static com.sun.javafx.animation.TickCalculation.sub;

public class TestRandom {

    @Test
    public void testRandom(){
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println((int)Math.ceil(Math.random()*100));
            //System.out.println(random.nextInt(100));
        }


        /*
                lambda
         */

        TestRandom testRandom = new TestRandom();
        MathOperation add = Integer::sum;

        MathOperation sub = (a,b) -> a- b;
        System.out.println("sub(5,1) = " + testRandom.operate(10,5,sub));

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
