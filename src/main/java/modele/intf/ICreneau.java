package modele.intf;

import java.time.LocalDateTime;
import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface ICreneau {
    int getId();
    void setId(int id) throws ModelException;
    LocalDateTime getDateDebut() throws ModelException;
    void setDateDebut(LocalDateTime dateDebut) throws ModelException;
    LocalDateTime getDateFin() throws ModelException;
    void setDateFin(LocalDateTime dateFin) throws ModelException;
    boolean isInterne() throws ModelException;
    void setInterne(boolean interne)  throws ModelException;
    IFormation getFormation()  throws ModelException;
    void setFormation(IFormation formation)  throws ModelException;
    List<IStagiaire> getListStagiaires()  throws ModelException;
    void setListStagiaires(List<IStagiaire> listStagiaires)  throws ModelException;
    List<IFormateur> getListFormateurs() throws ModelException;
    void setListFormateurs(List<IFormateur> listFormateurs) throws ModelException;
}
