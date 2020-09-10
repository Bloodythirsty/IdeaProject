package Y2020M4;


public class demo02 {
    public static void main(String[] args) {
        int[] arr = {2,4,3};
        ListNode list = ListNodeUtil.createList(arr);
        ListNodeUtil.printList(list);

        int[] arr1 = {5,6,4};
        ListNode list1 = ListNodeUtil.createList(arr1);
        ListNodeUtil.printList(list1);

        ListNode listNode = addTwoNumbers(list, list1);
        ListNodeUtil.printList(listNode);


//1.
//        1. String 的toCharArray,转成char类型，char类型直接与int操作，相当于ASC码在操作
//        2. 所以直接可以用String的getByte方法，获取ASC码，再做成整数 -48即可
//
//        String str = "123";
//        byte[] bytes = str.getBytes();
//        for (byte b: bytes
//             ) {
//            System.out.println("b = " + b);
//        }
//
//
//
//
//2.
//        char i = '5';
//        int p = i - 48;                            //p值为i的ASC码为53，所以与真实数据差了48
//        System.out.println("i = " + i);
//        System.out.println("p = " + p);
//
//



    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int parse_int1 = parseListToInt(l1);
        int parse_int2 = parseListToInt(l2);
        int sum = parse_int1 + parse_int2;
        String string = String.valueOf(sum);
        byte[] bytes = string.getBytes();
        int[] arr = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            arr[i] = bytes[i] - 48 ;
        }
        return ListNodeUtil.createList(arr);
    }

    public static int parseListToInt(ListNode ln){
        ListNode p = ln;
        int par = 0;
        int i = 0;
        while(p != null){
            par += (int) (p.val * Math.pow(10,i++));
            p = p.next;
        }
        return par;
    }


}

 //* Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;

     public ListNode(int[] arr) {
     }

     public ListNode(int x) {
        val = x;
    }
 }

 class ListNodeUtil{
    static ListNode ln;

    public static ListNode createList(int ... nums){
            //正序排列
//        ln = new ListNode(nums[nums.length-1]);
//        ln.next = null;
//        for ( int i = nums.length - 2; i >=0 ;i-- ){
//            ListNode newNode = new ListNode(nums[i]);
//            newNode.next = ln;
//            ln = newNode;
//        }

        //逆序排列
        ln = new ListNode(nums[0]);
        ln.next = null;
        for ( int i = 1 ; i < nums.length  ;i++ ){
            ListNode newNode = new ListNode(nums[i]);
            newNode.next = ln;
            ln = newNode;
        }
        return ln;
    }

    public static void printList(ListNode ln){
        ListNode t = ln;
        while(t.next != null){
            System.out.print(t.val + " ->");
            t=t.next;
        }
        System.out.println(t.val);
    }
 }


 /*

 //最优解法：进位法

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {            //其中一个不为空，就计算
        int x = (p != null) ? p.val : 0;        //为空选择零
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;                //加上之前的进位
        carry = sum / 10;                       //本次进位
        curr.next = new ListNode(sum % 10);     //新建节点值为余数
        curr = curr.next;                       //后插法，根据题目要求来

        //因为链表长度不一致，while条件是||，有可能p已经是null，
        //当直接p = p.next；时候，出现空指针异常，所以要判断
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {                           //最后的进位别忘记
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

  */
