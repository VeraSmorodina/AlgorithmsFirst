package task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> sumv(LinkedList list1, LinkedList list2) {
        if (list1.count() != list2.count()) return List.of();
        List<Integer> res = new ArrayList<>();
        Node node = list1.head;
        int sum = 0;
        while (node != null) {
            sum += node.value;
            node = node.next;
        }
        res.add(sum);
        sum = 0;
        node = list2.head;
        while (node != null) {
            sum += node.value;
            node = node.next;
        }
        res.add(sum);
        return res;
    }
}