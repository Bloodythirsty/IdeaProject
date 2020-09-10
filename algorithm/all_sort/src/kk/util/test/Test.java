package kk.util.test;

import kk.util.ShapeFactory;
import kk.util.shapImp.Shape;

public class Test {

    public static void main(String[] args) {
        Shape shape = new Shape();
        ShapeFactory shap = shape.getShap(1);
        System.out.println("shap = " + shap);

        ShapeFactory shap1 = shape.getShap(2);
        System.out.println("shap1 = " + shap1);
    }
}
