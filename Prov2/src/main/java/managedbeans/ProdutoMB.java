package managedbeans;

import dao.ProdutoDAO;
import dao.SetorDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Produto;
import model.Setor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProdutoMB implements Serializable {

    @Inject
    private ProdutoDAO produtoDAO;

    @Inject
    private SetorDAO setorDAO;

    private Produto produto;

    public ProdutoMB() {
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void salvar() {
        produtoDAO.save(produto);
        produto = new Produto(); // reset após salvar
    }

    public List<SelectItem> getSetores() {
        List<SelectItem> items = new ArrayList<>();
        for (Setor setor : setorDAO.findAll()) {
            items.add(new SelectItem(setor, setor.getNome()));
        }
        return items;
    }

    public List<Produto> getProdutos() {
        return produtoDAO.findAll();
    }
}
