/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Task;
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
public class Task_Controller {
    
    public void Save(Task task)
    {
        String sqlCom = "INSERT INTO tasks (Id_Project,Name,Description,Completed,"
                + "Notes,DeadLine,CreatedAt,UpdatedAt) VALUES(?,?,?,?,?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sqlCom);
            statement.setInt(1, task.getId_Project());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao salvar a Tarefa" + e.getMessage(), e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection,statement);

        }
        
    }
    
    public void Update(Task task)
    {
        String sql = "UPDATE tasks SET Id_Project = ?,Name = ? ,Description = ?,"
                + "Completed = ?,Notes = ?, DeadLine = ?, CreatedAt = ?, UpdatedAt = ?"
                + " WHERE Id = ?" ;
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getId_Project());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao atualizar a Tarefa: " + e.getMessage(), e);
        }
    }
    
    public void RemoveById(int taskId)
    {
        String sql= "DELETE FROM tasks WHERE Id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,taskId);
            statement.execute();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao deletar a tarefa: ", e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection, statement);
        }
    }
    
    public List<Task> GetAll(int idProject)
    {
        String sql = "SELECT * FROM tasks WHERE Id_Project = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> task = new ArrayList<>();
        try
        {
            connection = ConnectionFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            
            resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                Task taskResult = new Task();
                taskResult.setId(resultSet.getInt("Id"));
                taskResult.setId_Project(resultSet.getInt("Id_Project"));
                taskResult.setName(resultSet.getString("Name"));
                taskResult.setDescription(resultSet.getString("Description"));
                taskResult.setCompleted(resultSet.getBoolean("Completed"));
                taskResult.setNotes(resultSet.getString("Notes"));
                taskResult.setDeadLine(resultSet.getDate("DeadLine"));
                taskResult.setCreatedAt(resultSet.getDate("CreatedAt"));
                taskResult.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                task.add(taskResult);
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao inserir a tarefa" + e.getMessage(), e);
        }
        finally
        {
            ConnectionFactory.CloseConnection(connection, statement,resultSet);
        }
        return task;
        
    }
}
