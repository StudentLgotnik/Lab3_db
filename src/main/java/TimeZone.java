import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimeZone {
    private String timezone;
    private String goverment;
    static ArrayList<TimeZone> TimeZones = new ArrayList<TimeZone>();

    public TimeZone() {
    }

    public TimeZone(String timeZone, String goverment){
        this.timezone = timeZone;
        this.goverment = goverment;
    }

    public static void getTimeZoneData() throws ClassNotFoundException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("select * from SYSTEM.TIMEZONE");
            while (rset.next()){
                TimeZone timeZone = new TimeZone(rset.getString(1),
                        rset.getString(2));
                TimeZones.add(timeZone);
            }
            rset.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connections.closeCon(connection);
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "timeZone='" + timezone + '\'' +
                ", goverment='" + goverment + '\'' +
                '}';
    }

    public void setGoverment(String goverment) {
        this.goverment = goverment;
    }

    public void setTimezone(String timezone) {

        this.timezone = timezone;
    }

    public String getGoverment() {

        return goverment;
    }

    public String getTimezone() {

        return timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeZone timeZone = (TimeZone) o;

        if (!timezone.equals(timeZone.timezone)) return false;
        return goverment.equals(timeZone.goverment);
    }

    @Override
    public int hashCode() {
        int result = timezone.hashCode();
        result = 31 * result + goverment.hashCode();
        return result;
    }
}
