package edu.eci.cvds.servlet.model;

/**
 * @author Angie Medina
 * @author Jose Perez
 * @version 03/03/21 1.0
 */
public class Todo{
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    
    public int getUserId(){
        return userId;
    }

    public void setUSerId(int userId){
        this.userId = userId;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(Boolean completed){
        this.completed = completed;
    }
}