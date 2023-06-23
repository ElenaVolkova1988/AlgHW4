public class DList {
    static Node head;
    static Node tail;

    private static class Node {
        int value;
        Node next;
        Node prev;
    }

    public static void pushFront(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;

    }

    public static void popFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
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

        if (tail == null) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    public static void popBack() {
        if (tail != null) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public static void sort() {
        boolean needSort = true;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.prev;
                    Node current = node;
                    Node next = node.next;
                    Node after = next.next;

                    current.next = after;
                    current.prev = next;
                    next.next = current;
                    next.prev = before;
                    if (before != null) {
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.prev = current;
                    } else {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }

    public static void reverse() {
        Node current = head;
        tail = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}