package DB_Testing.MariaDBTesting.utils;

import java.sql.*;
import java.util.Properties;

public class ObjectUtil
{

    //null global objeler
    public static Properties properties;        //.properties file'inin okunmasi icin gerekli olacak
    public static String path;                 //properties file'inin pathini tutacak

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static DatabaseMetaData databaseMetaData;


}
