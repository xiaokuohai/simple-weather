package cn.udday.simpleweather.Beans;

public class AllBean {
    private int _id;
    private String city;
    private NowBean nowBean;
    private ForecastBean forecastBean;
    private LifeBean lifeBean;
    private HourlyBean hourlyBean;

    public AllBean(int _id, String city, NowBean nowBean, ForecastBean forecastBean, LifeBean lifeBean, HourlyBean hourlyBean) {
        this._id = _id;
        this.city = city;
        this.nowBean = nowBean;
        this.forecastBean = forecastBean;
        this.lifeBean = lifeBean;
        this.hourlyBean = hourlyBean;
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

    public ForecastBean getForecastBean() {
        return forecastBean;
    }

    public void setForecastBean(ForecastBean forecastBean) {
        this.forecastBean = forecastBean;
    }

    public NowBean getNowBean() {
        return nowBean;
    }

    public void setNowBean(NowBean nowBean) {
        this.nowBean = nowBean;
    }

    public HourlyBean getHourlyBean() {
        return hourlyBean;
    }

    public void setHourlyBean(HourlyBean hourlyBean) {
        this.hourlyBean = hourlyBean;
    }

    public LifeBean getLifeBean() {
        return lifeBean;
    }

    public void setLifeBean(LifeBean lifeBean) {
        this.lifeBean = lifeBean;
    }
}
