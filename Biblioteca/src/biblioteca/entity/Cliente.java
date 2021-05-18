
package biblioteca.entity;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private String cart; //cart = carteira de identificação
    private boolean estudante; //qualquer coisa alterar para int
    
    public Cliente(int codigo, String nome, String sobrenome, String rg, String cpf, LocalDate dataNasc, String cart, boolean estudante) {
        super(codigo, nome, sobrenome, rg, cpf, dataNasc);
        this.cart = cart;
        this.estudante = estudante;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public boolean isEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }
}
