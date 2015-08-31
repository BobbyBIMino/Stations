package cn.edu.seu.exception;

public class RegisterException extends SeuException {

    public static final int USERNAME_EXIST = 2001;
    public static final int CONFIRM_ERROR = 2002;
    
    public RegisterException(int errorCode) {
        super(errorCode);
    }

}
