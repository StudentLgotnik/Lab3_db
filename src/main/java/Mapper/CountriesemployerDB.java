package Mapper;

public class CountriesemployerDB {

  private String countries;
  private String unemployed;

  public CountriesemployerDB() {
  }

  public CountriesemployerDB(String countries, String unemployed) {
    this.countries = countries;
    this.unemployed = unemployed;
  }

  public String getCountries() {
    return countries;
  }

  public void setCountries(String countries) {
    this.countries = countries;
  }


  public String getUnemployed() {
    return unemployed;
  }

  public void setUnemployed(String unemployed) {
    this.unemployed = unemployed;
  }

}
