import graph.matrix.Matrix;

public class App {
    public static void main(String[] args) throws Exception {
        Matrix m = new Matrix();
        m.set(0, 0, 1);
        System.out.println(m);
        m.set(1, 1, 2);
        System.out.println(m);
        m.set(2, 2, 3);
        System.out.println(m);
        m.set(3, 3, 4);
        System.out.println(m);
        m.set(4, 4, 5);
        System.out.println(m);
        m.set(5, 5, 6);
        System.out.println(m);
        m.removeLine(1);
        System.out.println(m);
        m.removeColumn(5);
        System.out.println(m);
    }
}
