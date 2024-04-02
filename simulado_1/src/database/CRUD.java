package database;

import entity.Patient;

import java.util.List;
public interface CRUD {
    public Object insert(Object obj);
    public List<Patient> findAll();
    public boolean upDate(Object obj);
    public boolean delete(Object obj);
}
