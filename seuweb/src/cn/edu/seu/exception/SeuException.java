package cn.edu.seu.exception;

public class SeuException extends Exception {
    
    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public SeuException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }
    
    
    
}
