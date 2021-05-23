package user.ancyle.chrms.core.utilities.result;

public class Result {

    public Result(String message,boolean success){this(success); this.message=message;}
    public Result(boolean success){this.success=success;}

    protected String message;
    protected boolean success;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
