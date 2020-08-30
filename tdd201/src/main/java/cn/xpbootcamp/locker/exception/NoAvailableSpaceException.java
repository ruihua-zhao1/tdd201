package cn.xpbootcamp.locker.exception;

public class NoAvailableSpaceException extends RuntimeException{
    public NoAvailableSpaceException(String message){
        super(message);
    }
}
