import java.sql.*;
import java.util.Stack;

class FetchedBalance{

    private static final String url = "jdbc:mysql://localhost:3306/BalanceReporting";
    private static final String username="root";
    private static final String password="12345";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "select * from accounts where accountNumber=2001086";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int account = resultSet.getInt("balance");
                System.out.println("Your Available balance = "+account);
            }
        }catch (SQLException e){

            System.out.println(e.getMessage());
        }
    }
}