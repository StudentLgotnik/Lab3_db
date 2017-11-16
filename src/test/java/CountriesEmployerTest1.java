import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountriesEmployerTest1 {
    @Test
    void Test() throws ClassNotFoundException, SQLException {
        Countriesemployer.getContriesEmployerData();
        Countriesemployer countriesemployer = Countriesemployer.countriesemployers.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM COUNTRIESEMPLOYER WHERE COUNTRIES = 'Ukraine'");
        rset.next();
        Countriesemployer countriesemployerDB = new Countriesemployer(
                rset.getString(1),
                rset.getString(2)
        );
        assertEquals(countriesemployer, countriesemployerDB);
    }
}
