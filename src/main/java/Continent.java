import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Continent {
    private String continent;
    private String climate;
    static ArrayList<Continent> Continents = new ArrayList<Continent>();

    public Continent() {
    }

    public Continent(String continent, String climate){
        this.continent = continent;
        this.climate = climate;
    }

    public static void getContinentData() throws ClassNotFoundException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("select * from SYSTEM.CONTINENT");
            while (rset.next()){
                Continent continent = new Continent(rset.getString(1),
                        rset.getString(2));
                Continents.add(continent);
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

        Continent continent1 = (Continent) o;

        if (!continent.equals(continent1.continent)) return false;
        return climate.equals(continent1.climate);
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

    public String getContinent() {
        return continent;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setContinent(String continent) {

        this.continent = continent;
    }

    public String getClimate() {

        return climate;
    }

}
