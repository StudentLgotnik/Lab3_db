import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connections {
    static final String userName = "System";
    static final String password = "19Kozachok99";
    static final String connectionURL = "jdbc:oracle:thin:@//localhost:1521/orcl1";
    static Connection connection = null;

    public static Connection connect() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try{
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeCon(Connection connection){
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        try(java.sql.Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement()) {
            //System.out.println("We are connected!");
            ResultSet resultSet = statement.executeQuery("select * from SYSTEM.CAPITAL");
            resultSet.next();
            String capital = resultSet.getString(1);
            String governor = resultSet.getString(2);
            int population = resultSet.getInt(3);
            while(resultSet.next()){
                System.out.print(resultSet.getString(1) + " | ");
                System.out.print(resultSet.getString(2) + " | ");
                System.out.println(resultSet.getInt(3));
                System.out.println("--------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
}
