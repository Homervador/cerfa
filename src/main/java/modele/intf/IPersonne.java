package modele.intf;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IPersonne {

    int getId() throws ModelException;
    void setId(int id) throws ModelException;
    String getNom() throws ModelException;
    void setNom(String nom) throws ModelException;
    String getPrenom() throws ModelException;
    void setPrenom(String prenom) throws ModelException;
}
