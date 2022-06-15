package Algorithms;

public class SumLists {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(7);
        list1.addToTail(1);
        list1.addToTail(6);

        LinkedList list2 = new LinkedList(5);
        list2.addToTail(9);
        list2.addToTail(2);

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(sumLists(list1,list2));
    }

    public static String sumLists(LinkedList ls1, LinkedList ls2){
        Node nodeList1 = ls1.head;
        Node nodeList2 = ls2.head;

        //StringBuilder res = new StringBuilder();
        LinkedList res = new LinkedList();
        int tmpSumValue=0;
        int tmpSavedDigit=0;
        while (nodeList1 != null && nodeList2 != null) {
            tmpSumValue = nodeList1.value+nodeList2.value;
//            System.out.println("tmpSumValue="+tmpSumValue);

            // ToDo: do it as linked list (according to task)
            //res.addToTail()
            //res.append(Integer.toString((tmpSumValue % 10) + tmpSavedDigit));
//            System.out.println("Integer.toString((tmpSumValue % 10) + tmpSavedDigit)="+Integer.toString((tmpSumValue % 10) + tmpSavedDigit));

            tmpSavedDigit = tmpSumValue / 10;
//            System.out.println("tmpSavedDigit="+tmpSavedDigit);


            nodeList1 = nodeList1.next;
            nodeList2 = nodeList2.next;
        }

        return null;
        // ToDo: do it as linked list (according to task)
//        return res.reverse().toString();
    }

}
