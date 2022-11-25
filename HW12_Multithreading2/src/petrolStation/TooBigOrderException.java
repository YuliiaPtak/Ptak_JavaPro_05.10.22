package petrolStation;

public class TooBigOrderException extends RuntimeException{
    public TooBigOrderException(String message) {
        super(message);
    }
}
