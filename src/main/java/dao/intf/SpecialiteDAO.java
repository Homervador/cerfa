package dao.intf;

import modele.impl.Specialite;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 27/06/2017.
 */
public interface SpecialiteDAO extends DAO<Specialite> {
    Specialite findById(int id) throws ModelException;
    List<Specialite> findAll() throws ModelException;
    Specialite insert(Specialite specialite);
    Specialite update(Specialite specialite);
    int delete(Specialite specialite);
}
