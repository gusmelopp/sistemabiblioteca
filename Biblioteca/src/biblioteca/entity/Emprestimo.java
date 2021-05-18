
package biblioteca.entity;

import java.time.LocalTime;
import java.util.ArrayList;


public class Emprestimo {
    private int codigo;
    private LocalTime dtEmprestimo;
    private double totalValor;
    private double totalMulta;
    private boolean status;
    private Funcionario funcionario;
    private Cliente cliente;
    private ArrayList<EmprestimoExemplar> exemplares;
    public Emprestimo(int codigo, LocalTime dtEmprestimo, double totalValor, double totalMulta, boolean status, Funcionario funcionario, Cliente cliente, ArrayList<EmprestimoExemplar> exemplares ) {
        this.codigo = codigo;
        this.dtEmprestimo = dtEmprestimo;
        this.totalValor = totalValor;
        this.totalMulta = totalMulta;
        this.status = status;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.exemplares = exemplares;
    }

    public ArrayList<EmprestimoExemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(ArrayList<EmprestimoExemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalTime getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(LocalTime dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(double totalValor) {
        this.totalValor = totalValor;
    }

    public double getTotalMulta() {
        return totalMulta;
    }

    public void setTotalMulta(double totalMulta) {
        this.totalMulta = totalMulta;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
