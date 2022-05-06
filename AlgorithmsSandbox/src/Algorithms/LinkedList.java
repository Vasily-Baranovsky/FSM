package Algorithms;

public class LinkedList {
    Node head;

    LinkedList(int firstValue) {
        head = new Node (firstValue);
    }

    LinkedList (int[] array) {
        this(array[0]);
        for (int i=1; i<array.length; i++) {
            addToTail(array[i]);
        }
    }

    public Node addToTail (Node node) {
        if (head == null) {
            head = node;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        return node;
    }

    public Node addToTail (int value) {
        return addToTail(new Node (value));
    }

    public Node getKthFromTail (int k) {
        Node scout = head;
        Node main = head;

        for (int i=0; i<k; i++) {
            if (scout == null) {
                return null;
            } else {
                scout = scout.next;
            }
        }

        while (scout != null) {
            scout = scout.next;
            main = main.next;
        }
        return main;
    }


    private static int sumTwoElements(Node firstElement, Node secondElement) {
        int sum=0;
        if (firstElement!=null) {
            sum = firstElement.value;
        }
        if (secondElement!=null) {
            sum = sum + secondElement.value;
        }
        return sum;
    }

    public static LinkedList addLists (LinkedList firstList, LinkedList secondList) {
        int valueInMind;
        LinkedList resultList;

        //if one of the lists is null or empty algorythm does not handle it
        if (firstList==null || secondList == null) {
            return null;
        }

        int headSum = sumTwoElements(firstList.head, secondList.head);

        if (headSum>=10) {
            valueInMind = 1;
         } else {
            valueInMind = 0;
        }

        resultList = new LinkedList(headSum%10);

        Node firstListIterator = firstList.head.next;
        Node secondListIterator	= secondList.head.next;

        while (firstListIterator != null || secondListIterator != null) {
            int sum = sumTwoElements(firstListIterator, secondListIterator) + valueInMind;
            if (sum >= 10) {
                valueInMind = 1;
            } else {
                valueInMind = 0;
            }
            resultList.addToTail(sum%10);
            if (firstListIterator != null) {
                firstListIterator = firstListIterator.next;
            }
            if (secondListIterator != null) {
                secondListIterator = secondListIterator.next;
            }
        }

        if (valueInMind>0) {
            resultList.addToTail(1);
        }
        return resultList;
    }


    public void partition (int value) {
        Node leftPartition = null;
        Node leftPartitionTail = null;
        Node rightPartition = null;
        Node currentNode = head;

        while (currentNode!=null) {
            Node nextNode = currentNode.next;
            if (currentNode.value < value) {
                currentNode.next = leftPartition;
                leftPartition = currentNode;
                if (leftPartitionTail==null) {
                    leftPartitionTail = leftPartition;
                }
            } else {
                currentNode.next = rightPartition;
                rightPartition = currentNode;
            }
            currentNode = nextNode;
        }
        if (leftPartition != null) {
            head = leftPartition;
            leftPartitionTail.next = rightPartition;
        } else {
            head = rightPartition;
        }
    }

    @Override
    public String toString() {
        return printFromNode(head);
    }

    public static String printFromNode (Node node) {
        StringBuilder buffer = new StringBuilder();
        Node currentNode = node;

        while (currentNode != null) {
            buffer.append(currentNode.value);
            buffer.append("->");
            currentNode = currentNode.next;
        }
        return buffer.toString();
    }

    public boolean isPalindrome () {
        if (head == null || head.next == null) {
            return true;
        }

        Node measuringPointer = head.next;
        Node middlePointer = head;
        Node rearPointer = null;
        Node nextMiddlePointer = middlePointer.next;

        boolean lengthIsEven = true;
        while (measuringPointer.next != null) {
            measuringPointer = measuringPointer.next;

            nextMiddlePointer = middlePointer.next;
            middlePointer.next = rearPointer;
            rearPointer = middlePointer;

            if (measuringPointer.next != null) {
                measuringPointer = measuringPointer.next;
                middlePointer = nextMiddlePointer;
            } else {
                lengthIsEven = false;
            }
        }
        Node secondBranchPointer = lengthIsEven ? nextMiddlePointer : nextMiddlePointer.next;

        boolean isItAPalindrome = true;

        Node firstBranchPointer = middlePointer;
        Node nextElementPointer = nextMiddlePointer;

        System.out.println(printFromNode(firstBranchPointer));
        System.out.println(printFromNode(secondBranchPointer));
        while (secondBranchPointer != null) {
            isItAPalindrome = isItAPalindrome && secondBranchPointer.value == firstBranchPointer.value;

            Node tmp = firstBranchPointer.next;
            firstBranchPointer.next = nextElementPointer;
            nextElementPointer = firstBranchPointer;
            firstBranchPointer = tmp;
            secondBranchPointer = secondBranchPointer.next;
        }

        return 	isItAPalindrome;
    }
}