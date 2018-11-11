/**
 * Main class of app.
 */
public class Main {

    private int a = 10;

    /**
     * "Say A" method. Just prints "a" variable value.
     */
    private void sayA() {
        System.out.println(a);
    }

    /**
     * Main static method. Entry point of whole app.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.sayA();
    }

}