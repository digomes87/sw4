package converters;

import dao.SetorDAO;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import managedbeans.SetorMB;
import model.Setor;

@FacesConverter(forClass = Setor.class)
public class SetorConverter implements Converter {

    private SetorDAO setorDAO;

    public SetorConverter() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            this.setorDAO = context.getApplication().evaluateExpressionGet(context, "#{setorMB.setorDAO}", SetorDAO.class);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return setorDAO != null ? setorDAO.find(Long.valueOf(value)) : null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Setor) {
            Setor setor = (Setor) value;
            return setor.getCodigo() != null ? setor.getCodigo().toString() : "";
        } else {
            throw new IllegalArgumentException("Object is not of type Setor.");
        }
    }
}

