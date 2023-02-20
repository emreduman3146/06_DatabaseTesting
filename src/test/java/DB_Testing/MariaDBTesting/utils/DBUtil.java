package DB_Testing.MariaDBTesting.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static DB_Testing.MariaDBTesting.utils.ObjectUtil.*;

public class DBUtil
{


    public static void connectToMariaDB(String url,String username,String password)
    {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            System.out.println("Connected to MariaDB database->"+url);


        } catch (SQLException e) {
            System.out.println("Failed to connect to MariaDB database");
            e.printStackTrace();
        }

    }


    public static List<String> getAllTableNames()
    {
        List<String> tableNames = new ArrayList<>();

        String catalog = null;//anlik islem yaptigimiz db'yi temsil eder-> nation
        try {
            catalog = connection.getCatalog();
            databaseMetaData = connection.getMetaData();
            String[] types = {"TABLE"};
            resultSet = databaseMetaData.getTables(catalog,null,  null, types);

            while (resultSet.next()) {
                tableNames.add(resultSet.getString("TABLE_NAME"));
            }

            return tableNames;

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return null;
        }

    }


















}
