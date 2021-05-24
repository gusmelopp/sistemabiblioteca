
package biblioteca.entity;

public class Exemplar {
    private int codigo, qtde;
    private double valor;
    private String local;
    private boolean status;
    private Livro livro;

    public Exemplar(int codigo, int qtde, double valor, String local, boolean status, Livro livro) {
        this.codigo = codigo;
        this.qtde = qtde;
        this.valor = valor;
        this.local = local;
        this.status = status;
        this.livro = livro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
