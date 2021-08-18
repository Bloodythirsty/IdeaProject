import java.util.*;

public class Test2 {
    public static void main(String[] args) {

        Map<String, List<Integer>> container = new HashMap<>();
        List<String> types = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int operator = sc.nextInt();
            if (operator == 1){
                int carOrder = sc.nextInt();
                String carType = sc.next();
                doAdd(container,types,carOrder,carType);
            }else {
                String firstType = sc.next();
                String secondType = sc.next();
                doOrder(container,types,firstType,secondType);
            }
        }

        for (String type : types) {
            List<Integer> integers = container.get(type);
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }

    }

    private static void doOrder(Map<String, List<Integer>> container, List<String> types, String firstType, String secondType) {
        int firstIndex = types.indexOf(firstType);
        int secondIndex = types.indexOf(secondType);
        types.remove(firstIndex);
        types.add(firstIndex,secondType);
        types.remove(secondIndex);
        types.add(secondIndex,firstType);
    }

    private static void doAdd(Map<String, List<Integer>> container, List<String> types, int carOrder, String carType) {
        if (!types.contains(carType)){
            types.add(carType);
            List<Integer> list = new ArrayList<>();
            list.add(carOrder);
            container.put(carType,list);
        }else {
            container.get(carType).add(carOrder);
        }
    }
}
