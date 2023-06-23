public class List {
    static Node head;

    private static class Node {
        int value;
        Node next;
    }

    public static void pushFront(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
    }

    public static void popFront() {
        if (head != null) {
            head = head.next;
        }
    }

    public static void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void pushBack(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if(head == null) {
            head = newNode;
        }else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            }
        }

    public static void popBack() {
        if(head != null){
            if(head.next == null){
                head = null;
            }else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
        }
    }

}
