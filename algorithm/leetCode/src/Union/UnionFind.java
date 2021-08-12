package Union;

public class UnionFind {
    //联通分量数
    private int count;
    // 每个节点的父节点
    private int[] parents;
    // 记录重量
    private int[] size;

    //初始化
    public UnionFind(int n){
        this.count = n;
        parents = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
            size[i] = 1;
        }
    }

    //得到分量
    public int getCount(){
        return count;
    }

    // 找到父节点
    public int find(int x){
        while (parents[x] != x){
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    // 判断是否是连接分量
    public boolean isConnected(int p, int q){
        int pParent = find(p);
        int qParemt = find(q);
        return pParent == qParemt;
    }

    // 连接一起
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (size[rootX] > size[rootY]){
            parents[rootY] = rootX;
            size[rootX] += size[rootY];
        }else{
            parents[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        count--;
    }


    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        System.out.println(uf.getCount());

        uf.union(0,1);
        System.out.println(uf.getCount());

        uf.union(0,2);
        uf.union(0,3);
        uf.union(0,4);
        uf.union(0,5);
        uf.union(0,6);
        uf.union(0,7);
        uf.union(0,8);
        uf.union(0,9);

        System.out.println(uf.getCount());


    }
}
