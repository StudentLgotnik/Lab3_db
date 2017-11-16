import Mapper.CapitalDB;
import Mapper.ContinentDB;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContinentTest2 {
    DozerBeanMapper mapper;

    @Test
    void Test() throws ClassNotFoundException, SQLException {
        mapper = new DozerBeanMapper();
        Continent.getContinentData();
        Continent continent = Continent.Continents.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM CONTINENT WHERE CONTINENT = 'Eurasia'");
        rset.next();
        ContinentDB continentlDB = new ContinentDB(
                rset.getString(1),
                rset.getString(2)
        );
        Continent capital_db = mapper.map(continentlDB, Continent.class);
        assertEquals(continent.getClimate(), continentlDB.getClimate());
        assertEquals(continent.getContinent(), continentlDB.getContinent());
    }
}
