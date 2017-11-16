import Mapper.TimezoneDB;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeZoneTest2 {
    DozerBeanMapper mapper;

    @Test
    void Test() throws ClassNotFoundException, SQLException {
        mapper = new DozerBeanMapper();
        TimeZone.getTimeZoneData();
        TimeZone timeZone = TimeZone.TimeZones.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM TIMEZONE WHERE TIMEZONE = '+2'");
        rset.next();
        TimezoneDB timeZoneDB = new TimezoneDB(
                rset.getString(1),
                rset.getString(2)
        );
        TimeZone capital_db = mapper.map(timeZoneDB, TimeZone.class);
        assertEquals(timeZone.getTimezone(), timeZoneDB.getTimezone());
        assertEquals(timeZone.getGoverment(), timeZoneDB.getGoverment());
    }
}
