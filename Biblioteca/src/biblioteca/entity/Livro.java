
package biblioteca.entity;

public class Livro {
    private int codigo;
    private String titulo, genero, ano;
    private Autor autor;
    private Editora editora;
    
    
    public Livro(int codigo, String titulo, String genero, String ano, Autor autor, Editora editora)
    {
        this.codigo = codigo;
        this.genero = genero;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
    }
    
    public Livro(String titulo, String genero, String ano, Autor autor, Editora editora)
    {
        this(0, titulo, genero, ano, autor, editora);
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
    
    @Override
    public String toString()
    {
        return titulo;
    }
}
