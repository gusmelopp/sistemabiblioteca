
package biblioteca.entity;

import java.time.LocalDate;

public class Reserva {
    private int codigo;
    private LocalDate data;
    private Cliente cliente;
    private Exemplar exemplar;

    public Reserva(int codigo, LocalDate data, Cliente cliente, Exemplar exemplar) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.exemplar = exemplar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
}
