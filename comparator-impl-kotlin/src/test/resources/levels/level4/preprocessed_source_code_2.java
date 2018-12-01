/**
 * main class of app.
 */
public class main {
    private int a = 10;
    /**
     * "say a" method. just prints "a" variable value.
     */
    private void saya() {
        system.out.println(a);
    }
    /**
     * main static method. entry point of whole app.
     */
    public static void main(string[] args) {
        main main = new main();
        main.saya();
    }
}