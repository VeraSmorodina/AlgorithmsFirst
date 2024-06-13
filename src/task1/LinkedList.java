public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        Node nodeLast = this.head;// ?
        while (node != null) {
            if (count() == 1 && this.head.value == _value) {
                head = null;
                tail = null;
                return true;
            }
            if (node == this.head && node.value == _value) {
                this.head = head.next;
                return true;
            }
            if (node == this.tail && node.value == _value) {
                this.tail = nodeLast;
                nodeLast.next = null;
            }
            if (node.value == _value) {
                nodeLast.next = node.next;
                return true;
            }
            nodeLast = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        Node nodeLast = this.head;// ?
        while (node != null) {
            if (count() == 1 && this.head.value == _value) {
                head = null;
                tail = null;
                return;
            }
            if (node == this.head && node.value == _value) {
                this.head = head.next;
            } else if (node == this.tail && node.value == _value) {
                this.tail = nodeLast;
                nodeLast.next = null;
            } else if (node.value == _value) {
                nodeLast.next = node.next;
                node = node.next;
                continue;
            }
            nodeLast = node;
            node = node.next;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int result = 0;
        Node node = this.head;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null && this.head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }
        if (_nodeAfter == null) {
            Node node = this.head;
            this.head = _nodeToInsert;
            _nodeToInsert.next = node;
            return;
        }
        if (_nodeAfter.next == null) {
            _nodeAfter.next = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }
        Node node1 = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next = node1;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}

