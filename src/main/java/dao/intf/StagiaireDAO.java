package dao.intf;

import modele.impl.Stagiaire;

import java.util.List;

import exception.model.ModelException;


public interface StagiaireDAO extends DAO<Stagiaire> {

    Stagiaire findById(int id) throws ModelException;
    List<Stagiaire> findAll() throws ModelException;
    Stagiaire insert(Stagiaire objectif);
    Stagiaire update(Stagiaire objectif);
    int delete(Stagiaire objectif);
}
