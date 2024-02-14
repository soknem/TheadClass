import threadp1.ThreadRun;
import threadp1.ThreadTwo;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ThreadTwo obj=new ThreadTwo();
        obj.run();
        Thread thread=new Thread(new ThreadRun());
        Thread thread1=new Thread(()-> System.out.println("This is lambda thread"));
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is thread from anonymous class");
            }
        });
        thread1.start();
        thread.start();
        thread2.start();
    }
}