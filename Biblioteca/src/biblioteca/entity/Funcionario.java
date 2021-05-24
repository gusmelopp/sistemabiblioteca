
package biblioteca.entity;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    private String ctps, pis;
    private double salario;

    public Funcionario(int codigo, String nome, String rg, String cpf, LocalDate dataNasc, String ctps, String pis, double salario) {
        super(codigo, nome, rg, cpf, dataNasc);
        this.ctps = ctps;
        this.pis = pis;
        this.salario = salario;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
