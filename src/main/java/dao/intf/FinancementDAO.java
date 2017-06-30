package dao.intf;

import modele.impl.Financement;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface FinancementDAO extends DAO<Financement> {
    Financement findById(int id) throws ModelException;
    List<Financement> findAll() throws ModelException;
    Financement insert(Financement financement);
    Financement update(Financement financement);
    int delete(Financement financement);
}
