import Mapper.ContinentDB;
import Mapper.CountriesDB;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountriesTest2 {
    DozerBeanMapper mapper;

    @Test
    void Test() throws ClassNotFoundException, SQLException {
        mapper = new DozerBeanMapper();
        Countries.getCountriesData();
        Countries countries = Countries.Countries.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM COUNTRIES WHERE COUNTRY = 'Ukraine'");
        rset.next();
        CountriesDB countriesDB = new CountriesDB(
                rset.getString(1),
                rset.getString(2),
                rset.getInt(3),
                rset.getString(4),
                rset.getString(5)
        );
        Continent capital_db = mapper.map(countriesDB, Continent.class);
        assertEquals(countries.getCountry(), countriesDB.getCountry());
        assertEquals(countries.getCapital(), countriesDB.getCapital());
        assertEquals(countries.getPopulation(), countriesDB.getPopulation());
        assertEquals(countries.getMainland(), countriesDB.getMainland());
        assertEquals(countries.getTimezone(), countriesDB.getTimezone());
    }
}
