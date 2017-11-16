import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountriesTest1 {
    @Test
    void Test() throws ClassNotFoundException, SQLException {
        Countries.getCountriesData();
        Countries countries = Countries.Countries.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM COUNTRIES WHERE COUNTRY = 'Ukraine'");
        rset.next();
        Countries countriesDB = new Countries(
                rset.getString(1),
                rset.getString(2),
                rset.getInt(3),
                rset.getString(4),
                rset.getString(5)
        );
        assertEquals(countries, countriesDB);
    }
}
