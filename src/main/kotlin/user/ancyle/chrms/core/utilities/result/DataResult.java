package user.ancyle.chrms.core.utilities.result;

public class DataResult<T> extends Result {
    public DataResult(T data , String message, boolean success) {
        super(message, success); this.data=data;
    }

    public DataResult(T data,boolean success) {
        super(success); this.data=data;
    }

    private T data;

    public T getData() {
        return data;
    }
}
