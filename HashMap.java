public class HashMap {
    class Entity {
        int key;
        int value;
    }

    class Basket {

        Node head;

        class Node {
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (head == null) {
                head = node;
            } else {
                Node current = head;
                while (current != null) {
                    if (current.entity.key == entity.key) {
                        return false;
                    }
                    if (current.next == null) {
                        current.next = node;
                        return true;
                    }
                    current = current.next;
                }
            }
            return true;
        }

        private Integer find(int key) {
            Node current = head;
            while (current != null) {
                if (current.entity.key == key) {
                    return current.entity.value;
                }
                current = current.next;
            }
            return null;
        }

        private boolean remove(int key) {
            if (head != null) {
                if (head.entity.key == key) {
                    head = head.next;
                    return true;
                } else {
                    Node current = head;
                    while (current.next != null) {
                        if (current.next.entity.key == key) {
                            current.next = current.next.next;
                            return true;
                        }
                        current = current.next;
                    }
                }
            }
            return false;
        }
    }

    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public HashMap() {
        this(INIT_SIZE);
    }

    public HashMap(int size) {
        baskets = new Basket[size];
    }

    private int getIndex(int key) {
        return (key % baskets.length + baskets.length) % baskets.length; // [0, length - 1]
    }

    public boolean push(int key, int value) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public Integer find(int key) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.find(key);
        }
        return null;
    }

    public boolean remove(int key) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            return basket.remove(key);
        }
        return false;
    }


}
