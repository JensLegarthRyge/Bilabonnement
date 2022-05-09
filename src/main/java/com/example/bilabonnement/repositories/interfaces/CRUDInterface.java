package com.example.bilabonnement.repositories.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

//Jens Legarth Ryge

public interface CRUDInterface<T> {
    public boolean create(T entity);
    public ArrayList<T> getAll();
    public T getSingleById(int id);
    public boolean update(T entity);
    public void delete(int id);
}
