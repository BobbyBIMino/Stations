package cn.edu.seu.exception;

public class LoginException extends SeuException {
    
    public static final int USER_NOT_EXIST = 10001;
    public static final int PASSWORD_ERROR = 10002;

    public LoginException(int errorCode) {
        super(errorCode);
    }

}
