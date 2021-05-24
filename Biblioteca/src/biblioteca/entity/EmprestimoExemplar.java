
package biblioteca.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmprestimoExemplar {
    private Exemplar exemplar;
    private LocalDate dataDev, dataLim;
    
    public EmprestimoExemplar(Exemplar exemplar, LocalDate dataDev, LocalDate dataLim) {
        this.exemplar = exemplar;
        this.dataDev = dataDev;
        this.dataLim = dataLim;
    }

 

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDate getDataDev() {
        return dataDev;
    }

    public void setDataDev(LocalDate dataDev) {
        this.dataDev = dataDev;
    }

    public LocalDate getDataLim() {
        return dataLim;
    }

    public void setDataLim(LocalDate dataLim) {
        this.dataLim = dataLim;
    }
    
}
