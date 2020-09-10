package kk.util.shapImp;

import kk.util.ShapeFactory;

public class Shape {
    private Rectangle rectangle;
    private Triangle triangle;
    private int[] indexArr = new int[20];

    //getShap方法，记录后返回
    public ShapeFactory getShap(int i){
        switch (i){
            case 1 : return getRectangle();
            case 2 : return getTriangle();
            default:return null;
        }

    }

    //记录参数,队列实现
//    private void recodeIndex(){
//        for (int j = 0; j < )
//    }

    private Rectangle getRectangle() {
        if (rectangle == null){
            rectangle = new Rectangle();
        }
        return rectangle;
    }

    private Triangle getTriangle() {
        if (triangle == null){
            triangle = new Triangle();
        }
        return triangle;
    }
}
