package Mapper;

public class ContinentDB {

  private String continent;
  private String climate;

  public ContinentDB() {
  }

  public ContinentDB(String continent, String climate){
    this.continent = continent;
    this.climate = climate;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }


  public String getClimate() {
    return climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContinentDB that = (ContinentDB) o;

    if (!continent.equals(that.continent)) return false;
    return climate.equals(that.climate);
  }

  @Override
  public int hashCode() {
    int result = continent.hashCode();
    result = 31 * result + climate.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "ContinentDB{" +
            "continent='" + continent + '\'' +
            ", climate='" + climate + '\'' +
            '}';
  }
}
