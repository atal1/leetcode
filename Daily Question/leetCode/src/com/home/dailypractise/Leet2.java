package com.home.dailypractise;

public class Leet2 {
    public static void main(String[] args) {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
    ListNode l2 =  new ListNode(5, new ListNode(6, new ListNode(4, null)));

        System.out.println(addTwoNumbers(l1,l2));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode listNode = new ListNode();
        ListNode headNode = listNode;
        int carryForward =0 ;
        while((l1 !=null) || (l2 !=null) || carryForward != 0){
            int sum =0 ;
            if(l1==null && l2 == null)
                sum =0 ;
            else if(l1 == null){
                sum = l2.val;
                l2=l2.next;
            } else if (l2 == null){
               sum = l1.val;
                l1=l1.next;
            }else {
                sum = l1.val+ l2.val;
                l2=l2.next;
                l1=l1.next;
            }

            int total = carryForward+sum;
            carryForward = 0;
            if(total > 9 ){
                carryForward =1;
            }

            ListNode newNode = new ListNode(total%10);
            listNode.next = newNode;
            listNode =  newNode;

        }

        return headNode.next;
    }

    //Method to handle carryforward
    public static int calculateCarryForward(int carryForward, int sum, ListNode listNode){

        int total = carryForward+sum;
        carryForward = 0;
        if(total > 9 ){
            carryForward =1;
        }

        createNewListNode(listNode, total%10);

        return carryForward;

    }

    //Method to create a new listNode and return that node
    private static void createNewListNode(ListNode listNode, int i) {

        ListNode newNode = new ListNode(i, null);
        listNode.next = newNode;
        listNode = newNode;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
