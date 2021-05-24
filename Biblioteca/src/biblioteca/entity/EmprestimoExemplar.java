
package biblioteca.entity;

import java.time.LocalTime;

public class EmprestimoExemplar {
    private Exemplar exemplar;
    private LocalTime dataDev, dataLim;
    
    public EmprestimoExemplar(Exemplar exemplar, LocalTime dataDev, LocalTime dataLim) {
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
