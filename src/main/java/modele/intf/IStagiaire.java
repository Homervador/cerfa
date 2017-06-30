package modele.intf;

import java.util.List;

import exception.model.ModelException;

/**
 * Created by VTanchereau on 28/06/2017.
 */
public interface IStagiaire extends IPersonne{

    List<IFinancementStagiaire> getListFinancementsStagiaires() throws ModelException;
    void setListFinancementsStagiaires(List<IFinancementStagiaire> listFinancementsStagiaires) throws ModelException;
    List<ICreneau> getListCreneaux() throws ModelException;
    void setListCreneaux(List<ICreneau> listCreneaux) throws ModelException;
    boolean isInterne() throws ModelException;
    void setInterne(boolean interne) throws ModelException;
    String toString();
}
