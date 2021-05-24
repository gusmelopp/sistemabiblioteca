
package biblioteca.entity;

import java.time.LocalDate;

public class Usuario {
    private int codigo;
    private String nome, rg, cpf;
    private LocalDate dataNasc;
    
    
    public Usuario(String nome, String rg, String cpf, LocalDate dataNasc) {
        this.codigo = 0;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    
    public Usuario(int codigo, String nome, String rg, String cpf, LocalDate dataNasc) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
