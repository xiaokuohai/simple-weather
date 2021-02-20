package cn.udday.simpleweather.retrofit;

public class MyThrowable extends RuntimeException{
    private String msg;
    private int code;
    public MyThrowable(int code,String msg) {
        super(msg);
    this.msg = msg;
    this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
