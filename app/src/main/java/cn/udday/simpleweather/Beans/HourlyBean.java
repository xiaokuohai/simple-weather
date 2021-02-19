package cn.udday.simpleweather.Beans;

import java.io.Serializable;
import java.util.List;

public class HourlyBean implements Serializable {

    /**
     * code : 200
     * msg : success
     * data : {"basic":{"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"},"update":{"loc":"2021-02-15 12:56","utc":"2021-02-15 04:56"},"status":"ok","hourly":[{"cloud":"98","cond_code":"101","cond_txt":"多云","dew":"6","hum":"74","pop":"20","pres":"984","time":"2021-02-15 16:00","tmp":"11","wind_deg":"13","wind_dir":"东北风","wind_sc":"3-4","wind_spd":"13"},{"cloud":"62","cond_code":"101","cond_txt":"多云","dew":"6","hum":"74","pop":"7","pres":"984","time":"2021-02-15 19:00","tmp":"10","wind_deg":"31","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"72","cond_code":"101","cond_txt":"多云","dew":"6","hum":"79","pop":"7","pres":"985","time":"2021-02-15 22:00","tmp":"9","wind_deg":"11","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"93","cond_code":"101","cond_txt":"多云","dew":"4","hum":"71","pop":"7","pres":"988","time":"2021-02-16 01:00","tmp":"9","wind_deg":"329","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"98","cond_code":"101","cond_txt":"多云","dew":"5","hum":"76","pop":"7","pres":"988","time":"2021-02-16 04:00","tmp":"9","wind_deg":"339","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"97","cond_code":"101","cond_txt":"多云","dew":"6","hum":"85","pop":"7","pres":"985","time":"2021-02-16 07:00","tmp":"9","wind_deg":"51","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"71","cond_code":"101","cond_txt":"多云","dew":"7","hum":"76","pop":"7","pres":"985","time":"2021-02-16 10:00","tmp":"11","wind_deg":"48","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"36","cond_code":"100","cond_txt":"晴","dew":"7","hum":"58","pop":"0","pres":"987","time":"2021-02-16 13:00","tmp":"15","wind_deg":"99","wind_dir":"东风","wind_sc":"1-2","wind_spd":"5"}]}
     * time : 1613631252
     * log_id : 220919243569598464
     */

    private int code;
    private String msg;
    private DataBean data;
    private int time;
    private long log_id;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append(",\"time\":")
                .append(time);
        sb.append(",\"log_id\":")
                .append(log_id);
        sb.append('}');
        return sb.toString();
    }

    public static class DataBean implements Serializable {
        /**
         * basic : {"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"}
         * update : {"loc":"2021-02-15 12:56","utc":"2021-02-15 04:56"}
         * status : ok
         * hourly : [{"cloud":"98","cond_code":"101","cond_txt":"多云","dew":"6","hum":"74","pop":"20","pres":"984","time":"2021-02-15 16:00","tmp":"11","wind_deg":"13","wind_dir":"东北风","wind_sc":"3-4","wind_spd":"13"},{"cloud":"62","cond_code":"101","cond_txt":"多云","dew":"6","hum":"74","pop":"7","pres":"984","time":"2021-02-15 19:00","tmp":"10","wind_deg":"31","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"72","cond_code":"101","cond_txt":"多云","dew":"6","hum":"79","pop":"7","pres":"985","time":"2021-02-15 22:00","tmp":"9","wind_deg":"11","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"93","cond_code":"101","cond_txt":"多云","dew":"4","hum":"71","pop":"7","pres":"988","time":"2021-02-16 01:00","tmp":"9","wind_deg":"329","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"98","cond_code":"101","cond_txt":"多云","dew":"5","hum":"76","pop":"7","pres":"988","time":"2021-02-16 04:00","tmp":"9","wind_deg":"339","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"97","cond_code":"101","cond_txt":"多云","dew":"6","hum":"85","pop":"7","pres":"985","time":"2021-02-16 07:00","tmp":"9","wind_deg":"51","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"71","cond_code":"101","cond_txt":"多云","dew":"7","hum":"76","pop":"7","pres":"985","time":"2021-02-16 10:00","tmp":"11","wind_deg":"48","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"36","cond_code":"100","cond_txt":"晴","dew":"7","hum":"58","pop":"0","pres":"987","time":"2021-02-16 13:00","tmp":"15","wind_deg":"99","wind_dir":"东风","wind_sc":"1-2","wind_spd":"5"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<HourlyBean1> hourly;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"basic\":")
                    .append(basic);
            sb.append(",\"update\":")
                    .append(update);
            sb.append(",\"status\":\"")
                    .append(status).append('\"');
            sb.append(",\"hourly\":")
                    .append(hourly);
            sb.append('}');
            return sb.toString();
        }

        public BasicBean getBasic() {
            return basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public String getStatus() {
            return status;
        }

        public List<HourlyBean1> getHourly() {
            return hourly;
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

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"cid\":\"")
                        .append(cid).append('\"');
                sb.append(",\"location\":\"")
                        .append(location).append('\"');
                sb.append(",\"parent_city\":\"")
                        .append(parent_city).append('\"');
                sb.append(",\"admin_area\":\"")
                        .append(admin_area).append('\"');
                sb.append(",\"cnty\":\"")
                        .append(cnty).append('\"');
                sb.append(",\"lat\":\"")
                        .append(lat).append('\"');
                sb.append(",\"lon\":\"")
                        .append(lon).append('\"');
                sb.append(",\"tz\":\"")
                        .append(tz).append('\"');
                sb.append('}');
                return sb.toString();
            }

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
             * loc : 2021-02-15 12:56
             * utc : 2021-02-15 04:56
             */

            private String loc;
            private String utc;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"loc\":\"")
                        .append(loc).append('\"');
                sb.append(",\"utc\":\"")
                        .append(utc).append('\"');
                sb.append('}');
                return sb.toString();
            }
        }

        public static class HourlyBean1 implements Serializable {
            /**
             * cloud : 98
             * cond_code : 101
             * cond_txt : 多云
             * dew : 6
             * hum : 74
             * pop : 20
             * pres : 984
             * time : 2021-02-15 16:00
             * tmp : 11
             * wind_deg : 13
             * wind_dir : 东北风
             * wind_sc : 3-4
             * wind_spd : 13
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
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

            public String getDew() {
                return dew;
            }

            public String getHum() {
                return hum;
            }

            public String getPop() {
                return pop;
            }

            public String getPres() {
                return pres;
            }

            public String getTime() {
                return time;
            }

            public String getTmp() {
                return tmp;
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

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"cloud\":\"")
                        .append(cloud).append('\"');
                sb.append(",\"cond_code\":\"")
                        .append(cond_code).append('\"');
                sb.append(",\"cond_txt\":\"")
                        .append(cond_txt).append('\"');
                sb.append(",\"dew\":\"")
                        .append(dew).append('\"');
                sb.append(",\"hum\":\"")
                        .append(hum).append('\"');
                sb.append(",\"pop\":\"")
                        .append(pop).append('\"');
                sb.append(",\"pres\":\"")
                        .append(pres).append('\"');
                sb.append(",\"time\":\"")
                        .append(time).append('\"');
                sb.append(",\"tmp\":\"")
                        .append(tmp).append('\"');
                sb.append(",\"wind_deg\":\"")
                        .append(wind_deg).append('\"');
                sb.append(",\"wind_dir\":\"")
                        .append(wind_dir).append('\"');
                sb.append(",\"wind_sc\":\"")
                        .append(wind_sc).append('\"');
                sb.append(",\"wind_spd\":\"")
                        .append(wind_spd).append('\"');
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
