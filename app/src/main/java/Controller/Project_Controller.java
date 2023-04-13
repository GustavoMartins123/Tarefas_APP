/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Project;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Project_Controller {
    public void Save(Project project)
    {
        String sqlCom = "INSERT INTO proects (Name,Description,"
                + "CreatedAt,UpdatedAt) VALUES(?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sqlCom);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao salvar o projeto: " + e.getMessage(), e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection,statement);

        }
        
    }
    
    public void Update(Project project)
    {
        String sql = "UPDATE proects SET Name = ? ,Description = ?,"
                + "CreatedAt = ?, UpdatedAt = ?"
                + " WHERE Id = ?" ;
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao atualizar o projeto: " + e.getMessage(), e);
        }
    }
    
    public void RemoveById(int Id)
    {
        String sqlCom = "DELETE FROM proects WHERE Id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sqlCom);
            statement.setInt(1,Id);
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao deletar o projeto: ", e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection, statement);
        }
    }
    
    public List<Project> GetAll()
    {
        String sql = "SELECT * FROM proects";
        
        List<Project> project = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                Project projectResult = new Project();
                projectResult.setId(resultSet.getInt("Id"));
                projectResult.setName(resultSet.getString("Name"));
                projectResult.setDescription(resultSet.getString("Description"));
                projectResult.setCreatedAt(resultSet.getDate("CreatedAt"));
                projectResult.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                project.add(projectResult);
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao buscar os projetos" + e.getMessage(), e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection, statement,resultSet);
        }
        return project;
        
    }
}
