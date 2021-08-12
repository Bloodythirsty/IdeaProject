/**
 * @author zhangkangkang
 * @date 2021/08/08 20:44
 */
public class SingleTon {
    private static volatile SingleTon singleTon;
    private SingleTon(){}
    public static SingleTon getInstance(){
        if (singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
