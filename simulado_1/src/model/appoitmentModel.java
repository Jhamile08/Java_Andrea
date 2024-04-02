package model;

import database.CRUD;
import entity.Patient;

import java.util.List;

public class appoitmentModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public boolean upDate(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
