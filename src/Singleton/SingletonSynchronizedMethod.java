package Singleton;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){}

    private static synchronized SingletonSynchronizedMethod getInstance(){
        if(instance==null){
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}
