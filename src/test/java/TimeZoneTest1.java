import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeZoneTest1 {
    @Test
    void Test() throws ClassNotFoundException, SQLException {
        TimeZone.getTimeZoneData();
        TimeZone timeZone = TimeZone.TimeZones.get(0);
        Connection connection = Connections.connect();
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM TIMEZONE WHERE TIMEZONE = '+2'");
        rset.next();
        TimeZone timeZoneDB = new TimeZone(
                rset.getString(1),
                rset.getString(2)
        );
        assertEquals(timeZone, timeZoneDB);
    }
}
