package cn.udday.simpleweather.Beans;

import java.io.Serializable;
import java.util.List;

public class ForecastBean implements Serializable {

    /**
     * code : 200
     * msg : success
     * data : {"basic":{"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"},"update":{"loc":"2021-02-15 12:54","utc":"2021-02-15 04:54"},"status":"ok","daily_forecast":[{"cond_code_d":"305","cond_code_n":"104","cond_txt_d":"小雨","cond_txt_n":"阴","date":"2021-02-15","hum":"82","mr":"09:48","ms":"22:02","pcpn":"1.0","pop":"55","pres":"985","sr":"07:35","ss":"18:46","tmp_max":"12","tmp_min":"9","uv_index":"1","vis":"24","wind_deg":"0","wind_dir":"北风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-16","hum":"76","mr":"10:16","ms":"22:56","pcpn":"0.0","pop":"25","pres":"988","sr":"07:34","ss":"18:46","tmp_max":"17","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"90","wind_dir":"东风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"104","cond_code_n":"305","cond_txt_d":"阴","cond_txt_n":"小雨","date":"2021-02-17","hum":"86","mr":"10:45","ms":"23:49","pcpn":"0.0","pop":"25","pres":"990","sr":"07:33","ss":"18:47","tmp_max":"18","tmp_min":"7","uv_index":"2","vis":"23","wind_deg":"135","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2021-02-18","hum":"80","mr":"11:15","ms":"00:00","pcpn":"0.0","pop":"20","pres":"989","sr":"07:32","ss":"18:48","tmp_max":"16","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"315","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-19","hum":"67","mr":"11:47","ms":"00:43","pcpn":"0.0","pop":"10","pres":"986","sr":"07:31","ss":"18:49","tmp_max":"18","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"180","wind_dir":"南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2021-02-20","hum":"59","mr":"12:23","ms":"01:38","pcpn":"0.0","pop":"0","pres":"979","sr":"07:30","ss":"18:50","tmp_max":"19","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"135","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-21","hum":"58","mr":"13:04","ms":"02:33","pcpn":"0.0","pop":"0","pres":"973","sr":"07:29","ss":"18:50","tmp_max":"21","tmp_min":"8","uv_index":"5","vis":"25","wind_deg":"90","wind_dir":"东风","wind_sc":"1-2","wind_spd":"3"}]}
     * time : 1613382357
     * log_id : 219875303139495936
     */

    private int code;
    private String msg;
    private DataBean data;
    private int time;
    private long log_id;

    public DataBean getData() {
        return data;
    }

    public static class DataBean implements Serializable {
        /**
         * basic : {"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"}
         * update : {"loc":"2021-02-15 12:54","utc":"2021-02-15 04:54"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"305","cond_code_n":"104","cond_txt_d":"小雨","cond_txt_n":"阴","date":"2021-02-15","hum":"82","mr":"09:48","ms":"22:02","pcpn":"1.0","pop":"55","pres":"985","sr":"07:35","ss":"18:46","tmp_max":"12","tmp_min":"9","uv_index":"1","vis":"24","wind_deg":"0","wind_dir":"北风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-16","hum":"76","mr":"10:16","ms":"22:56","pcpn":"0.0","pop":"25","pres":"988","sr":"07:34","ss":"18:46","tmp_max":"17","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"90","wind_dir":"东风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"104","cond_code_n":"305","cond_txt_d":"阴","cond_txt_n":"小雨","date":"2021-02-17","hum":"86","mr":"10:45","ms":"23:49","pcpn":"0.0","pop":"25","pres":"990","sr":"07:33","ss":"18:47","tmp_max":"18","tmp_min":"7","uv_index":"2","vis":"23","wind_deg":"135","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2021-02-18","hum":"80","mr":"11:15","ms":"00:00","pcpn":"0.0","pop":"20","pres":"989","sr":"07:32","ss":"18:48","tmp_max":"16","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"315","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-19","hum":"67","mr":"11:47","ms":"00:43","pcpn":"0.0","pop":"10","pres":"986","sr":"07:31","ss":"18:49","tmp_max":"18","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"180","wind_dir":"南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2021-02-20","hum":"59","mr":"12:23","ms":"01:38","pcpn":"0.0","pop":"0","pres":"979","sr":"07:30","ss":"18:50","tmp_max":"19","tmp_min":"7","uv_index":"5","vis":"25","wind_deg":"135","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2021-02-21","hum":"58","mr":"13:04","ms":"02:33","pcpn":"0.0","pop":"0","pres":"973","sr":"07:29","ss":"18:50","tmp_max":"21","tmp_min":"8","uv_index":"5","vis":"25","wind_deg":"90","wind_dir":"东风","wind_sc":"1-2","wind_spd":"3"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<DailyForecastBean> daily_forecast;

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public static class BasicBean implements Serializable {
            /**
             * cid : CN101042100
             * location : 潼南
             * parent_city : 重庆
             * admin_area : 重庆市
             * cnty : 中国
             * lat : 30.18955421
             * lon : 105.84181976
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;
        }

        public static class UpdateBean implements Serializable {
            /**
             * loc : 2021-02-15 12:54
             * utc : 2021-02-15 04:54
             */

            private String loc;
            private String utc;
        }

        public static class DailyForecastBean implements Serializable {
            /**
             * cond_code_d : 305
             * cond_code_n : 104
             * cond_txt_d : 小雨
             * cond_txt_n : 阴
             * date : 2021-02-15
             * hum : 82
             * mr : 09:48
             * ms : 22:02
             * pcpn : 1.0
             * pop : 55
             * pres : 985
             * sr : 07:35
             * ss : 18:46
             * tmp_max : 12
             * tmp_min : 9
             * uv_index : 1
             * vis : 24
             * wind_deg : 0
             * wind_dir : 北风
             * wind_sc : 1-2
             * wind_spd : 3
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public String getHum() {
                return hum;
            }

            public String getMr() {
                return mr;
            }

            public String getMs() {
                return ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPop() {
                return pop;
            }

            public String getPres() {
                return pres;
            }

            public String getSr() {
                return sr;
            }

            public String getSs() {
                return ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public String getVis() {
                return vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }
        }
    }
}
