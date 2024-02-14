package threadp1;

import javax.swing.plaf.TableHeaderUI;

public class RaceDemo {
    private static int counter=0;

    public static void main(String[] args) throws InterruptedException {
//        Thread thread=new Thread(){
//            @Override
//            public void run() {
//                for(int i=1;i<=100000;i++){
//                    synchronized (this){
//                    counter++;
//                    }
//                }
//            }
//        };
//        Thread thread1=new Thread(){
//            @Override
//            public void run() {
//                for(int i=1;i<=100000;i++){
//                    synchronized (this){
//                        counter++;
//                    }
//                }
//            }
//        };
        Runnable task=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100000;i++){
                    synchronized (this){
                        counter++;
                    }
                }
            }
        };
//        thread.start();
//        thread1.start();
//        thread.join();
//        thread1.join();
        Thread objthread1=new Thread(task);

        Thread objthread2=new Thread(task);
        objthread1.start();
        objthread2.start();
        objthread1.join();
        objthread2.join();
        System.out.println("Expected value = 100000");
        System.out.println("Actual value ="+counter);
    }
}
