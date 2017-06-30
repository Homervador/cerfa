package dao.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface DAO <T> {

    T findById(int id) throws ModelException;
    List<T> findAll() throws ModelException;
    T insert(T formateur);
    T update(T formateur);
    int delete(T formateur);
}
