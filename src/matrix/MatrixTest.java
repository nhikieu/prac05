package matrix;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix<Integer> m = new Matrix<Integer>(2, 2);

        m.insert(0, 0, 0);
        m.insert(0, 1, 1);
        m.insert(1, 0, 2);
        m.insert(1, 1, 3);

        System.out.println(m + "\n");

        for (Integer element : m) {
            System.out.println(element);
        }

        Matrix<String> n = new Matrix<String>(2, 2);

        n.insert(0, 0, "a");
        n.insert(0, 1, "b");
        n.insert(1, 0, "c");
        n.insert(1, 1, "d");

        System.out.println(n + "\n");

        for (String element : n) {
            System.out.println(element);
        }
    }
}
