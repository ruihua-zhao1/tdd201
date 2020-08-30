package cn.xpbootcamp.locker.exception;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException(String message){
        super(message);
    }
}
