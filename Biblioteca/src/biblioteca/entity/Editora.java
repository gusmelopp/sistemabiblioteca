
package biblioteca.entity;

public class Editora {
    private int codigo;
    private String nome;
    
    
    public Editora(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public Editora(String nome) {
        this(0, nome);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }
    
    public String toString()
    {
        return nome;
    }
}
