import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Countries {
    private String country;
    private String mainland;
    private int population;
    private String capital;
    private String timezone;

    static ArrayList<Countries> Countries = new ArrayList<Countries>();

    public Countries() {
    }

    public Countries(String country, String mainland, int population, String capital, String timezone){
        this.country = country;
        this.mainland = mainland;
        this.population = population;
        this.capital = capital;
        this.timezone = timezone;
    }

    public static void getCountriesData() throws ClassNotFoundException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("select * from SYSTEM.COUNTRIES");
            while (rset.next()){
                Countries countries = new Countries(rset.getString(1),
                        rset.getString(2),
                        rset.getInt(3),
                        rset.getString(4),
                        rset.getString(5));
                Countries.add(countries);
            }
            rset.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connections.closeCon(connection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (population != countries.population) return false;
        if (!country.equals(countries.country)) return false;
        if (!mainland.equals(countries.mainland)) return false;
        if (!capital.equals(countries.capital)) return false;
        return timezone.equals(countries.timezone);
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + mainland.hashCode();
        result = 31 * result + population;
        result = 31 * result + capital.hashCode();
        result = 31 * result + timezone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CountriesDB{" +
                "country='" + country + '\'' +
                ", mainland='" + mainland + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setCapital(String capital) {

        this.capital = capital;
    }

    public void setPopulation(int population) {

        this.population = population;
    }

    public void setMainland(String mainland) {

        this.mainland = mainland;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getTimezone() {

        return timezone;
    }

    public String getCapital() {

        return capital;
    }

    public int getPopulation() {

        return population;
    }

    public String getMainland() {

        return mainland;
    }

    public String getCountry() {

        return country;
    }
}
