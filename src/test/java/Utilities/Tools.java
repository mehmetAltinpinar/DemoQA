package Utilities;

public class Tools extends BaseDriver {
    public static void quitDriver(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void Wait(double seconds){
        try {
            Thread.sleep((int)(seconds * 1000));
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
