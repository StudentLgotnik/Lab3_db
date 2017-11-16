import Mapper.CapitalDB;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalTest2 {
    DozerBeanMapper mapper;
    //Mapper mapper;

    @Test
    void Test() throws ClassNotFoundException, SQLException {
        mapper = new DozerBeanMapper();
        Capital.getCapitalData();
        Capital capital = Capital.Capitals.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("select * from SYSTEM.CAPITAL WHERE CAPITAL = 'Kiev'");
        rset.next();
        CapitalDB capitalDB = new CapitalDB(
                rset.getString(1),
                rset.getString(2),
                rset.getInt(3)
        );
        Capital capital_db = mapper.map(capitalDB, Capital.class);
        //capital.equals(capitalDB);
        assertEquals(capital.getCapital(), capital_db.getCapital());
        assertEquals(capital.getGovernor(), capital_db.getGovernor());
        //assertEquals(capital.getCapital(),capitalDB.getCapital());
        //assertEquals(capital.getGovernor(),capitalDB.getGovernor());
        //assertEquals(capital.getCaitalpopulation(),capitalDB.getCapitalpopulation());
        /*Capital capital = new Capital("Kiev","Clichko", 2928000);
        CapitalDB capitalDB = new CapitalDB("Kiev","Clichko", 2928000);
        //Capital capital = mapper.map(capitalDB, Capital.class);
        assertEquals(capital.getCapital(), "Kiev");
        assertEquals(capital.getGovernor(), "Clichko");
        assertEquals(capital.getCaitalpopulation(), 2928000);*/
        /*Capital.getCapitalData();
        Connection connection = Connections.connect();
        Capital capital;

        assertEquals(2, 1 + 1);*/
    }
}
