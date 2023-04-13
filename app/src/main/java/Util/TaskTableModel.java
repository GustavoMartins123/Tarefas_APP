/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class TaskTableModel extends AbstractTableModel{

    
    String[] colums = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList();
    
    
    
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription(); 
            case 2:
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                return date.format(tasks.get(rowIndex).getDeadLine());
            case 3:
                return tasks.get(rowIndex).isCompleted();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
                
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        if(tasks.isEmpty())
        {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public void setValueAt(Object value,int rowIndex ,int columnIndex)
    {
        tasks.get(rowIndex).setCompleted((boolean)value);
        
    }
    
    public boolean isCellEditable(int rowIndex, int columIndex)
    {
        return columIndex ==3;
    }

    public String[] getColums() {
        return colums;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colums[columnIndex];
    }
    
}
