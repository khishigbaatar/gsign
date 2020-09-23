package biz.gsign.restutils;

public class ResourceError {

    private String errorMessage;

    public ResourceError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @SuppressWarnings("unused")
    public String getErrorMessage() {
        return errorMessage;
    }

}
