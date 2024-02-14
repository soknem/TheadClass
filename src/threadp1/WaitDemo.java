package threadp1;
// async/await vs thread ... !
// Consumer - Producer Pattern
class Data {
    int msg;
    boolean valueSet = false;
    public synchronized void set(int msg) {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }

        }
        this.msg = msg;
        System.out.println("Produce : "+msg);
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }

        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Consume:  " + msg);
        valueSet = false;
        notify();
    }
}


public class WaitDemo {
    public static void main(String[] args) {
        Data data = new Data();

        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    data.set(i);
                }
            }
        };
        Thread consumer = new Thread(){
            @Override
            public void run() {
                for(int i =0; i <5; i++){
                    data.get();
                }

            }
        };

        producer.start();
        consumer.start();

        // wait for the thread to complete the execution
        try{
            producer.join();
            consumer.join();

            System.out.println("Operation completed..........");

        }catch (Exception ex){}


    }
}
