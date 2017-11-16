package Mapper;

public class CountriesDB {

  private String country;
  private String mainland;
  private int population;
  private String capital;
  private String timezone;

  public CountriesDB(String country, String mainland, int population, String capital, String timezone){
    this.country = country;
    this.mainland = mainland;
    this.population = population;
    this.capital = capital;
    this.timezone = timezone;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public String getMainland() {
    return mainland;
  }

  public void setMainland(String mainland) {
    this.mainland = mainland;
  }


  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }


  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }


  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

}
