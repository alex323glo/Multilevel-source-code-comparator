public class Main {

    private int a = 10;

    private void sayA() {
        System.out.println(a);
    }

    /**
     * Java app entry point.
     *
     * @param args String args array, passed before app execution.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.sayA();
    }

}