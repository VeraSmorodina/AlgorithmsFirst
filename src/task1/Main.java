package task1;


public class Main {
    public static LinkedList sumv(LinkedList list1, LinkedList list2) {
        LinkedList res = new LinkedList();
        if (list1.count() != list2.count()) return res;
        Node node = list1.head;
        int sum = 0;
        while (node != null) {
            sum += node.value;
            node = node.next;
        }
        res.addInTail(new Node(sum));
        sum = 0;
        node = list2.head;
        while (node != null) {
            sum += node.value;
            node = node.next;
        }
        res.addInTail(new Node(sum));
        return res;
    }
}

