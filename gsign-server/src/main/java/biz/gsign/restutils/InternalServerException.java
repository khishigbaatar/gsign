package biz.gsign.restutils;

public class InternalServerException extends RuntimeException {
    private String message;

    public InternalServerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
