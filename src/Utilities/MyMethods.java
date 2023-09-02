package Utilities;

public class MyMethods {
    public static  void waiting_Time(int seconds){
        try {
            Thread.sleep(seconds* 1000L);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

    }
}
