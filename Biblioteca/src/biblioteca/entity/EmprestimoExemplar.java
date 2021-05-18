
package biblioteca.entity;

import java.time.LocalTime;

public class EmprestimoExemplar {
    private Emprestimo emprestimo;
    private Exemplar exemplar;
    private LocalTime dataDev, dataLim;
    
    public EmprestimoExemplar(Emprestimo emprestimo, Exemplar exemplar, LocalTime dataDev, LocalTime dataLim) {
        this.emprestimo = emprestimo;
        this.exemplar = exemplar;
        this.dataDev = dataDev;
        this.dataLim = dataLim;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalTime getDataDev() {
        return dataDev;
    }

    public void setDataDev(LocalTime dataDev) {
        this.dataDev = dataDev;
    }

    public LocalTime getDataLim() {
        return dataLim;
    }

    public void setDataLim(LocalTime dataLim) {
        this.dataLim = dataLim;
    }
    
}
