package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    //public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection GetConnection()
    {
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }
        catch(Exception e)
                {
                    throw new RuntimeException("Erro na conexão com o banco de dados: ", e);
                }
    }
    
    public static void CloseConnection(Connection connection)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
        }
        catch(Exception e)
                {
                    throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ",e);
                }
    }
    
    public static void CloseConnection(Connection connection, PreparedStatement statement)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
            if(statement != null)
            {
                statement.close();
            }
        }
        catch(Exception e)
                {
                    throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ",e);
                }
    }
    
    public static void CloseConnection(Connection connection, PreparedStatement statement, ResultSet resultSet)
    {
        try
        {
            if(connection != null)
            {
                connection.close();
            }
            if(statement != null)
            {
                statement.close();
            }
            if(resultSet != null)
            {
                resultSet.close();
            }
        }
        catch(Exception e)
                {
                    throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: ",e);
                }
    }
}
