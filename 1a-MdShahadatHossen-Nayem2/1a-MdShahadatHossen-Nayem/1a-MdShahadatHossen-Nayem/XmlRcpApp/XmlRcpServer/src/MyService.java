public class MyService {

    public static Integer compute(int x, int y) {
        int i = 1;
        System.out.println(i++);
        return x+y;
    }
    public static int asyProc(int x) {
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

