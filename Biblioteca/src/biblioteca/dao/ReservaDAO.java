
package biblioteca.dao;

import biblioteca.entity.Reserva;
import biblioteca.entity.Reserva;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservaDAO {
    public boolean inserir (Reserva reserva)
    {
        String sql="insert into reserva (data, cliente, exemplar) values ('$1', '$2', '$3')";
        sql = sql.replace("$1", reserva.getData().toString());
        sql = sql.replace("$2", reserva.getCliente().getCodigo() + "");
        sql = sql.replace("$3", reserva.getExemplar().getCodigo() + "");       
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                              
    }
    
    public boolean alterar (Reserva reserva)
    {
        String sql="update reserva set data = '$1', cliente = '$2', exemplar = '$3' where codigo = "+ reserva.getCodigo();
        sql = sql.replace("$1", reserva.getData().toString());
        sql = sql.replace("$2", reserva.getCliente().getCodigo() + "");
        sql = sql.replace("$3", reserva.getExemplar().getCodigo() + ""); 
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    
    public boolean apagar(int id)
    {        
        boolean flag = Singleton.getCon().manipular("delete from reserva where codigo="+id);        
        return flag;                      
    }
    public static Reserva getReserva(int cod)
    {
        Reserva reserva = null;
        String sql="select * from reserva where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            reserva = new Reserva(rs.getInt("codigo"), LocalDate.parse(rs.getString("data")),ClienteDAO.getCliente(rs.getInt("codigo")),ExemplarDAO.getExemplar(rs.getInt("exemplar")));
        }
        catch(Exception e){System.out.println(e.toString());}
        return reserva;
    }
    public static ArrayList <Reserva> getReserva(String filtro)
    {   
        ArrayList <Reserva> lista=new ArrayList();
        String sql="select * from reserva";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by data";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Reserva(rs.getInt("codigo"), LocalDate.parse(rs.getString("data")),ClienteDAO.getCliente(rs.getInt("codigo")),ExemplarDAO.getExemplar(rs.getInt("exemplar"))));
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
