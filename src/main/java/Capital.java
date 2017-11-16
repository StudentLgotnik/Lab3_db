import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Capital {
    private String capital;
    private String governor;
    private int capitalpopulation;
    static ArrayList<Capital> Capitals = new ArrayList<Capital>();

    public Capital() {
    }

    public Capital(String capital, String governor, int capitalpopulation){
        this.capital = capital;
        this.governor = governor;
        this.capitalpopulation = capitalpopulation;
    }

    public static void getCapitalData() throws ClassNotFoundException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("select * from SYSTEM.CAPITAL");
            while (rset.next()){
                Capital capital = new Capital(rset.getString(1),
                        rset.getString(2),
                        rset.getInt(3));
                Capitals.add(capital);
            }
            rset.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connections.closeCon(connection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Capital capital1 = (Capital) o;

        if (capitalpopulation != capital1.capitalpopulation) return false;
        if (!capital.equals(capital1.capital)) return false;
        return governor.equals(capital1.governor);
    }

    @Override
    public int hashCode() {
        int result = capital.hashCode();
        result = 31 * result + governor.hashCode();
        result = 31 * result + capitalpopulation;
        return result;
    }

    @Override
    public String toString() {
        return "CapitalDB{" +
                "capital='" + capital + '\'' +
                ", governor='" + governor + '\'' +
                ", capitalpopulation=" + capitalpopulation +
                '}';
    }

    public String getCapital() {
        return capital;
    }

    public String getGovernor() {
        return governor;
    }

    public int getCaitalpopulation() {
        return capitalpopulation;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setGovernor(String governor) {
        this.governor = governor;
    }

    public void setCaitalpopulation(int caitalpopulation) {
        this.capitalpopulation = capitalpopulation;
    }
}
