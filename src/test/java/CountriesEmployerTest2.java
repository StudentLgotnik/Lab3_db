import Mapper.ContinentDB;
import Mapper.CountriesemployerDB;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountriesEmployerTest2 {
    DozerBeanMapper mapper;

    @Test
    void Test() throws ClassNotFoundException, SQLException {
        mapper = new DozerBeanMapper();
        Countriesemployer.getContriesEmployerData();
        Countriesemployer countriesemployer = Countriesemployer.countriesemployers.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM COUNTRIESEMPLOYER WHERE COUNTRIES = 'Ukraine'");
        rset.next();
        CountriesemployerDB countriesemployerDB = new CountriesemployerDB(
                rset.getString(1),
                rset.getString(2)
        );
        Countriesemployer capital_db = mapper.map(countriesemployerDB, Countriesemployer.class);
        assertEquals(countriesemployer.getCountries(), capital_db.getCountries());
        assertEquals(countriesemployer.getUnemployed(), capital_db.getUnemployed());
    }
}
