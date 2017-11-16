import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Countriesemployer {
    private String countries;
    private String unemployed;
    static ArrayList<Countriesemployer> countriesemployers = new ArrayList<Countriesemployer>();

    public Countriesemployer() {
    }

    public Countriesemployer(String countries, String unemployed) {
        this.countries = countries;
        this.unemployed = unemployed;
    }

    public static void getContriesEmployerData() throws ClassNotFoundException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("SELECT * FROM SYSTEM.COUNTRIESEMPLOYER");
            while (rset.next()) {
                Countriesemployer countriesemployer = new Countriesemployer(rset.getString(1),
                        rset.getString(2));
                countriesemployers.add(countriesemployer);
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

        Countriesemployer that = (Countriesemployer) o;

        if (!countries.equals(that.countries)) return false;
        return unemployed.equals(that.unemployed);
    }

    @Override
    public int hashCode() {
        int result = countries.hashCode();
        result = 31 * result + unemployed.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Countriesemployer{" +
                "countries='" + countries + '\'' +
                ", unemployed='" + unemployed + '\'' +
                '}';
    }

    public void setUnemployed(String unemployed) {
        this.unemployed = unemployed;
    }

    public void setCountries(String countries) {

        this.countries = countries;
    }

    public String getUnemployed() {

        return unemployed;
    }

    public String getCountries() {

        return countries;
    }
}
