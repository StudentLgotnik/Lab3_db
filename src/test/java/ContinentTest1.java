import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContinentTest1 {
    @Test
    void Test() throws ClassNotFoundException, SQLException {
        Continent.getContinentData();
        Continent continent = Continent.Continents.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM CONTINENT WHERE CONTINENT = 'Eurasia'");
        rset.next();
        Continent continentDB = new Continent(
                rset.getString(1),
                rset.getString(2)
        );
        assertEquals(continent, continentDB);
    }
}
