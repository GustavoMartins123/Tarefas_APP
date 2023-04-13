/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Task {
    int id;
    int id_Project;
    String name;
    String description;
    String notes;
    boolean completed;
    Date deadLine;
    Date createdAt;
    Date updatedAt;

    public Task(int id, int id_Project, String name, String description, String notes, boolean completed, Date deadLine, Date createdAt, Date updatedAt) {
        this.id = id;
        this.id_Project = id_Project;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.completed = completed;
        this.deadLine = deadLine;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Task()
            {
                this.completed = false;
                this.createdAt = new Date();
                this.updatedAt = new Date();
            }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Project() {
        return id_Project;
    }

    public void setId_Project(int id_Project) {
        this.id_Project = id_Project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "Id=" + id + ", Id_Project=" + id_Project + ", Name=" + name + ", Description=" + description + ", Notes=" + notes + ", Completed=" + completed + ", DeadLine=" + deadLine + ", CreatedAt=" + createdAt + ", UpdatedAt=" + updatedAt + '}';
    }
    
    
}
