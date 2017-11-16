package Mapper;

public class CapitalDB {

  private String capital;
  private String governor;
  private int capitalpopulation;

  public CapitalDB() {
  }
  public CapitalDB(String capital, String governor, int capitalpopulation){
    this.capital = capital;
    this.governor = governor;
    this.capitalpopulation = capitalpopulation;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }


  public String getGovernor() {
    return governor;
  }

  public void setGovernor(String governor) {
    this.governor = governor;
  }


  public int getCapitalpopulation() {
    return capitalpopulation;
  }

  public void setCapitalpopulation(int capitalpopulation) {
    this.capitalpopulation = capitalpopulation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CapitalDB capitalDB = (CapitalDB) o;

    if (capitalpopulation != capitalDB.capitalpopulation) return false;
    if (!capital.equals(capitalDB.capital)) return false;
    return governor.equals(capitalDB.governor);
  }

  @Override
  public int hashCode() {
    int result = capital.hashCode();
    result = 31 * result + governor.hashCode();
    result = 31 * result + capitalpopulation;
    return result;
  }

  @Override
  public String toString() {
    return "CapitalDB{" +
            "capital='" + capital + '\'' +
            ", governor='" + governor + '\'' +
            ", capitalpopulation=" + capitalpopulation +
            '}';
  }
}
