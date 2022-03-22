public class MyService {
    int i = 1;
    public Integer compute(int x, int y) {
        System.out.println(i++);
        return x+y;
    }

    public int asyProc(int x) {
        System.out.println("...asyProc called - processing");
        try {
            Thread.sleep(x);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("... asyProc – finished");
        return (123);
    }
}
