package programmer.zaman.now.application;

public class StackTraceApp {
    public static void main(String[] args) {
        try{
            sampleError();
        }catch (Throwable throwable){
            throwable.getStackTrace();
            StackTraceElement[] stackTraceElements = throwable.getStackTrace();
            throwable.printStackTrace();
        }
    }

    public static void sampleError(){
        try{
            String[] name = {
                    "Julia", "Eko", "Budi"
            };
            System.out.println(name[4]);
        }catch (Throwable throwable){
            throw new RuntimeException(throwable);
        }
    }
}
