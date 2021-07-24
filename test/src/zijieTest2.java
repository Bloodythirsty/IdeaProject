import java.util.*;

public class zijieTest2 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeCross horse = new NodeCross(sc.nextInt(), sc.nextInt());
        NodeCross gener = new NodeCross(sc.nextInt(), sc.nextInt());
        Set<NodeCross> conflit = new HashSet<>();
        conflit.add(horse);
        conflit.add(new NodeCross(horse.x+2,horse.y+1));
        conflit.add(new NodeCross(horse.x+1,horse.y+2));

        NodeCross start = new NodeCross(0, 0);
        trace(horse,gener,conflit,start);
        System.out.println(count);
    }

    private static void trace(NodeCross horse, NodeCross gener, Set<NodeCross> conflit,NodeCross start) {
        if(start.x > gener.x || start.y > gener.y) return;
        for (NodeCross nodeCross : conflit) {
            if(nodeCross.equals(start)) return;
        }
        if(gener.equals(start)) {
            count++;
            return;
        }
        if(start.x+1 != horse.x && start.y != horse.y){
            trace(horse,gener,conflit,new NodeCross(start.x+1,start.y+2));
        }
        if(start.y+1 != horse.y && start.x != horse.x){
            trace(horse,gener,conflit,new NodeCross(start.x+2,start.y+1));
        }
    }


    private static class NodeCross{
        int x;
        int y;

        public NodeCross(int x, int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object o) {
            NodeCross nodeCross = (NodeCross) o;
            return x == nodeCross.x &&
                    y == nodeCross.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

