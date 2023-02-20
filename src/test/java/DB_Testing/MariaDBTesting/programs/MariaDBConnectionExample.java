package DB_Testing.MariaDBTesting.programs;

import java.sql.*;


public class MariaDBConnectionExample
{
    public static void main(String[] args){

        //intellij'den mariaDB'ye baglanti kurup, veri getiricez


        try(Connection connection = DriverManager.getConnection("jdbc:mariadb://104.197.128.158:3306/nation", "root", "123456"))
        {
            System.out.println("Connected to MariaDB database");

            Statement statement= connection.createStatement();

            ResultSet resultSet=statement.executeQuery("SELECT * FROM countries;");


           while (resultSet.next()) {
               int country_id = resultSet.getInt("country_id");
               String name = resultSet.getString("name");
               int region_id = resultSet.getInt("region_id");

               System.out.printf("country_id: %d - name: %s - region_id: %d %n",country_id,name,region_id);
           }

        } catch (SQLException e) {
            System.out.println("Failed to connect to MariaDB database");
            e.printStackTrace();
        }




    }
}
