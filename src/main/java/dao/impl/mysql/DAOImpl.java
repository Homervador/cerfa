package dao.impl.mysql;

import dao.intf.DAO;
import db.ConnectionFactory;
import exception.model.ModelException;

import java.sql.Connection;
import java.util.List;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public abstract class DAOImpl<T> implements DAO<T>{

    protected Connection con = ConnectionFactory.getConnection(
            ConnectionFactory.CERFA
    );

    public abstract T findById(int id) throws ModelException;
    public abstract List<T> findAll() throws ModelException;
    public abstract T insert(T formateur);
    public abstract T update(T formateur);
    public abstract int delete(T formateur);
}
