package threadp1;

public class RaceDemo {
    private static int counter=0;
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
                for(int i=1;i<=100000;i++){
                    counter++;
                }
            }
        };
        Thread thread1=new Thread(){
            @Override
            public void run() {
                for(int i=1;i<=100000;i++){
                    counter++;
                }
            }
        };
        thread.start();
        thread1.start();
        System.out.println("Expected value = 100000");
        System.out.println("Actual value ="+counter);
    }
}
