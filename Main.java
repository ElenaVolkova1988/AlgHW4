public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{5, 7, 10, 3, 6, 20, 25, 35, 45, 55, 1, 2, 4, 30, 31};
        RedBlackTree tree = new RedBlackTree();
        for (int item : array) {
            tree.insert(item);
            System.out.println("insert");
        }
    }
}
