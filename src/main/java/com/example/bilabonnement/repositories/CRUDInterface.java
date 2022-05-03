package com.example.bilabonnement.repositories;

import java.util.HashMap;
import java.util.List;

//Jens Legarth Ryge

public interface CRUDInterface<T> {
    public boolean create();
    public List<T> getAll();
    public T getSingleById();
    public boolean update();
    public T delete();
}
