package cn.udday.simpleweather.Beans;

import java.io.Serializable;
import java.util.List;

public class LifeBean implements Serializable {

    /**
     * code : 200
     * msg : success
     * data : {"basic":{"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"},"update":{"loc":"2021-02-15 12:59","utc":"2021-02-15 04:59"},"status":"ok","lifestyle":[{"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},{"type":"drsg","brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},{"type":"flu","brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},{"type":"sport","brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意保暖并携带雨具。"},{"type":"trav","brf":"适宜","txt":"温度适宜，又有较弱降水和微风作伴，会给您的旅行带来意想不到的景象，适宜旅游，可不要错过机会呦！"},{"type":"uv","brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"},{"type":"cw","brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"type":"air","brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}]}
     * time : 1613382139
     * log_id : 219874390169518080
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

    public DataBean getData() {
        return data;
    }

    public static class DataBean implements Serializable {
        /**
         * basic : {"cid":"CN101042100","location":"潼南","parent_city":"重庆","admin_area":"重庆市","cnty":"中国","lat":"30.18955421","lon":"105.84181976","tz":"+8.00"}
         * update : {"loc":"2021-02-15 12:59","utc":"2021-02-15 04:59"}
         * status : ok
         * lifestyle : [{"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},{"type":"drsg","brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},{"type":"flu","brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},{"type":"sport","brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意保暖并携带雨具。"},{"type":"trav","brf":"适宜","txt":"温度适宜，又有较弱降水和微风作伴，会给您的旅行带来意想不到的景象，适宜旅游，可不要错过机会呦！"},{"type":"uv","brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"},{"type":"cw","brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"type":"air","brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<LifestyleBean> lifestyle;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"basic\":")
                    .append(basic);
            sb.append(",\"update\":")
                    .append(update);
            sb.append(",\"status\":\"")
                    .append(status).append('\"');
            sb.append(",\"lifestyle\":")
                    .append(lifestyle);
            sb.append('}');
            return sb.toString();
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
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
        }

        public static class UpdateBean implements Serializable {
            /**
             * loc : 2021-02-15 12:59
             * utc : 2021-02-15 04:59
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

        public static class LifestyleBean implements Serializable {
            /**
             * type : comf
             * brf : 舒适
             * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            private String type;
            private String brf;
            private String txt;

            public String getType() {
                return type;
            }

            public String getBrf() {
                return brf;
            }

            public String getTxt() {
                return txt;
            }

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("{");
                sb.append("\"type\":\"")
                        .append(type).append('\"');
                sb.append(",\"brf\":\"")
                        .append(brf).append('\"');
                sb.append(",\"txt\":\"")
                        .append(txt).append('\"');
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
