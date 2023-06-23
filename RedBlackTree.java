public class RedBlackTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;
        Color color;
    }

    private enum Color {
        BLACK,
        RED
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node middle = right.left;
        right.left = node;
        node.right = middle;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node middle = left.right;
        left.right = node;
        node.left = middle;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node balance(Node node) {
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needBalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);

        return result;
    }


    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
        } else {
            insert(root, value);
            root = balance(root);
        }
        root.color = Color.BLACK;
    }

    private void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                } else {
                    insert(node.right, value);
                    node.right = balance(node.right);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                } else {
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }
}
