package proxy;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("公司money = " + money);
        return "Lenovo";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
