
package biblioteca.entity;

public class Exemplar {
    private int codigo;
    private String genero, titulo, local;
    private boolean status;
    private Autor autor;
    private Editora editora;

    public Exemplar(int codigo, String genero, String titulo, String local, boolean status, Autor autor, Editora editora) {
        this.codigo = codigo;
        this.genero = genero;
        this.titulo = titulo;
        this.local = local;
        this.status = status;
        this.autor = autor;
        this.editora = editora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }    
}
