package Mapper;

public class TimezoneDB {

  private String timezone;
  private String goverment;

  public TimezoneDB() {
  }

  public TimezoneDB(String timeZone, String goverment){
    this.timezone = timeZone;
    this.goverment = goverment;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  public String getGoverment() {
    return goverment;
  }

  public void setGoverment(String goverment) {
    this.goverment = goverment;
  }

}
