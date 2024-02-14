package threadp1;

class Data{
    int msg;
    boolean valueSet=false;
    public synchronized void get(){
        try {
            Thread.sleep(500);
        }catch (Exception e){}
        while (!valueSet){

        }
        System.out.println("Consume: "+msg);
        valueSet=false;
    }
    public synchronized void set(int msg){
        try{
            Thread.sleep(500);
        }catch (Exception e){}
        while (!valueSet){
            try{

            }catch (Exception e){}
        }

    }
}
public class WaitDemo {
}
