package cn.udday.simpleweather.Beans;

import java.io.Serializable;

public class BaseBean implements Serializable {

    /**
     * code : 200
     * msg : success
     * data : {"basic":{"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"},"update":{"loc":"2021-02-18 13:36","utc":"2021-02-18 05:36"},"status":"ok","now":{"cloud":"91","cond_code":"104","cond_txt":"阴","fl":"14","hum":"76","pcpn":"0.0","pres":"983","tmp":"14","vis":"21","wind_deg":"180","wind_dir":"南风","wind_sc":"1","wind_spd":"3"}}
     * time : 1613712348
     * log_id : 221259387501780992
     */
    private int code;
    private String msg;
    private Object data;
    private int time;
    private long log_id;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getTime() {
        return time;
    }

    public long getLog_id() {
        return log_id;
    }
}
