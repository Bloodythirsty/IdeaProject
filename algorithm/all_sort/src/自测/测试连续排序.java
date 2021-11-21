package 自测;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang
 * @date 2021/10/27 16:33
 */
public class 测试连续排序 {

    private class Nodes{
        int col;
        int row;

        public Nodes(int col, int row){
            this.col = col;
            this.row = row;
        }

        public int getCol(){
            return col;
        }

        public int getRow(){
            return row;
        }

        @Override
        public String toString() {
            return "Nodes{" +
                    "col=" + col +
                    ", row=" + row +
                    '}';
        }
    }


    @Test
    public void test(){
        ArrayList<Nodes> nodes = new ArrayList<>();
        nodes.add(new Nodes(1, 2));
        nodes.add(new Nodes(2, 1));
        nodes.add(new Nodes(1, 1));
        nodes.add(new Nodes(2, 2));

        List<Nodes> collect = nodes.stream().sorted(Comparator.comparing(Nodes::getCol).thenComparing(Nodes::getRow)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
