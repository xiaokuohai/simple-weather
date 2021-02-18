package cn.udday.simpleweather.utils;

public class MyThrowable extends RuntimeException{
    private String msg;
    public MyThrowable(String msg) {
        super(msg);
    this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
