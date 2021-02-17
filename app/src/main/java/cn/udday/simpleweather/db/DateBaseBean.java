package cn.udday.simpleweather.db;

public class DateBaseBean {
    private int _id;
    private String city;
    private String nowContent;
    private String hourlyContent;
    private String forecastContent;
    private String lifeContent;

    public DateBaseBean() {
    }

    public DateBaseBean(int _id, String city, String nowContent, String hourlyContent, String forecastContent, String lifeContent) {
        this._id = _id;
        this.city = city;
        this.nowContent = nowContent;
        this.hourlyContent = hourlyContent;
        this.forecastContent = forecastContent;
        this.lifeContent = lifeContent;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNowContent() {
        return nowContent;
    }

    public void setNowContent(String nowContent) {
        this.nowContent = nowContent;
    }

    public String getHourlyContent() {
        return hourlyContent;
    }

    public void setHourlyContent(String hourlyContent) {
        this.hourlyContent = hourlyContent;
    }

    public String getForecastContent() {
        return forecastContent;
    }

    public void setForecastContent(String forecastContent) {
        this.forecastContent = forecastContent;
    }

    public String getLifeContent() {
        return lifeContent;
    }

    public void setLifeContent(String lifeContent) {
        this.lifeContent = lifeContent;
    }
}
