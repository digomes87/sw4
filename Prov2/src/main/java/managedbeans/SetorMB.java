package managedbeans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import model.Setor;
import dao.SetorDAO;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class SetorMB implements Serializable {

    @Inject
    private SetorDAO setorDAO;
    private Setor setor;
    private List<Setor> setores;

    public List<Setor> getSetores() {
        if (setores == null) {
            setores = setorDAO.findAll();
        }
        return setores;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public void save() {
        if (setor.getCodigo() == null) {
            setorDAO.create(setor);
        } else {
            setorDAO.update(setor);
        }
        setores = null;
    }
    
      public SetorDAO getSetorDAO() {
        return setorDAO;
    }
}
