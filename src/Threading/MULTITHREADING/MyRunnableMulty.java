package Threading.MULTITHREADING;

public class MyRunnableMulty implements Runnable {
    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(1000);
                System.out.printf("io sono il thread: %s \ne il mio timer è al punto: %d\n",Thread.currentThread().getName(),i);
                System.out.println();
            }
            catch (InterruptedException e) {
                System.out.println("Il Thread si è interrotto");
            }
        }
    }

}
