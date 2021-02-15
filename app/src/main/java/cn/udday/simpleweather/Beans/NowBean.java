package cn.udday.simpleweather.Beans;

import java.io.Serializable;


public class NowBean implements Serializable {

    /**
     * code : 200
     * msg : success
     * data : {"basic":{"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"},"update":{"loc":"2021-02-15 13:36","utc":"2021-02-15 05:36"},"status":"ok","now":{"cloud":"99","cond_code":"104","cond_txt":"阴","fl":"7","hum":"83","pcpn":"0.1","pres":"983","tmp":"12","vis":"24","wind_deg":"0","wind_dir":"北风","wind_sc":"4","wind_spd":"27"}}
     * time : 1613371448
     * log_id : 219829547091263488
     */

    private int code;
    private String msg;
    private DataBean data;
    private int time;
    private long log_id;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataBean getData() {
        return data;
    }

    public int getTime() {
        return time;
    }

    public long getLog_id() {
        return log_id;
    }

    public static class DataBean implements Serializable {
        /**
         * basic : {"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"}
         * update : {"loc":"2021-02-15 13:36","utc":"2021-02-15 05:36"}
         * status : ok
         * now : {"cloud":"99","cond_code":"104","cond_txt":"阴","fl":"7","hum":"83","pcpn":"0.1","pres":"983","tmp":"12","vis":"24","wind_deg":"0","wind_dir":"北风","wind_sc":"4","wind_spd":"27"}
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;

        public BasicBean getBasic() {
            return basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public String getStatus() {
            return status;
        }

        public NowBean getNow() {
            return now;
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

            public String getCid() {
                return cid;
            }

            public String getLocation() {
                return location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public String getLat() {
                return lat;
            }

            public String getLon() {
                return lon;
            }

            public String getTz() {
                return tz;
            }
        }

        public static class UpdateBean implements Serializable {
            /**
             * loc : 2021-02-15 13:36
             * utc : 2021-02-15 05:36
             */

            private String loc;
            private String utc;
        }

        public static class NowBean1 implements Serializable {
            /**
             * cloud : 99
             * cond_code : 104
             * cond_txt : 阴
             * fl : 7
             * hum : 83
             * pcpn : 0.1
             * pres : 983
             * tmp : 12
             * vis : 24
             * wind_deg : 0
             * wind_dir : 北风
             * wind_sc : 4
             * wind_spd : 27
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public String getHum() {
                return hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPres() {
                return pres;
            }

            public String getTmp() {
                return tmp;
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
