
package biblioteca.dao;

import biblioteca.entity.Emprestimo;
import biblioteca.entity.Emprestimo;
import biblioteca.entity.EmprestimoExemplar;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;

public class EmprestimoDAO {
     public boolean inserir (Emprestimo emprestimo)
    {
        String sql = "insert into emprestimo (dtEmprestimo, totalValor, totalMulta, status, funcionario, cliente) values ('$1','$2','$3','$4','$5','$6')";
        sql = sql.replace("$1", emprestimo.getDtEmprestimo().toString());
        sql = sql.replace("$2", emprestimo.getTotalValor()+"");
        sql = sql.replace("$3", emprestimo.getTotalMulta()+"");
        sql = sql.replace("$4", String.valueOf(emprestimo.getStatus()));
        sql = sql.replace("$5", emprestimo.getFuncionario().getCodigo()+"");
        sql = sql.replace("$6", emprestimo.getCliente().getCodigo()+"");
        
        boolean flag = Singleton.getCon().manipular(sql); 
        if(flag){
            int cod = Singleton.getCon().getMaxPK("emprestimo","codigo");
            for(EmprestimoExemplar ep : emprestimo.getExemplares()){
                sql = "insert into emprestimoExemplares (emprestimo, exemplar, dataDev, dataLim) values ('$1','$2','$3','$4')";
                sql = sql.replace("$1", cod+"");
                sql = sql.replace("$2", ep.getExemplar().getCodigo()+"");
                sql = sql.replace("$3", ep.getDataDev().toString());
                sql = sql.replace("$4", ep.getDataLim().toString());
                flag = Singleton.getCon().manipular(sql); 
            }
        }
        return flag;                              
    }
    
    public boolean alterar (Emprestimo emprestimo)
    {
        String sql = "update emprestimo set dtEmprestimo = '$1', totalValor = '$2', totalMulta = '$3', status = '$4', funcionario = '$5', cliente='$6' where codigo ="+ emprestimo.getCodigo();
        sql = sql.replace("$1", emprestimo.getDtEmprestimo().toString());
        sql = sql.replace("$2", emprestimo.getTotalValor()+"");
        sql = sql.replace("$3", emprestimo.getTotalMulta()+"");
        sql = sql.replace("$4", String.valueOf(emprestimo.getStatus()));
        sql = sql.replace("$5", emprestimo.getFuncionario().getCodigo()+"");
        sql = sql.replace("$6", emprestimo.getCliente().getCodigo()+"");
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    public ArrayList<EmprestimoExemplar> getItens(int emprestimo){
        ArrayList <EmprestimoExemplar> lista = new ArrayList();
        String sql = "select * from EmprestimoExemplar where emprestimo = "+emprestimo;
        ResultSet rs = Singleton.getCon().consultar(sql);
        try{
            while(rs.next())
                lista.add(new EmprestimoExemplar(ExemplarDAO.getExemplar(rs.getInt("exemplar")), rs.getDate("dataDev"),  rs.getDate("dataLim")));
        }
        catch(Exception e){
        }
        return lista;
    }
    public boolean apagar(int id){       
        boolean flag = Singleton.getCon().manipular("delete from emprestimo where codigo ="+id);
        return flag;                      
    }
    public Emprestimo getEmprestimo(int cod)
    {
        Emprestimo emprestimo = null;
        String sql="select * from emprestimo where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            emprestimo = new Emprestimo(rs.getInt("codigo"), 
                    rs.getString("dtEmprestimo"), 
                    rs.getDouble("totalValor"),
                    rs.getDouble("totalMulta"), 
                    rs.getBoolean("status"), 
                    FuncionarioDAO.getFuncionario(rs.getInt("funcionario")),
                    ClienteDAO.getCliente(rs.getInt("cliente")),
                    getItens(rs.getInt("codigo")));
        }
        catch(Exception e){System.out.println(e.toString());}
        return emprestimo;
    }
    public ArrayList <Emprestimo> getEmprestimo(String filtro)
    {   
        ArrayList <Emprestimo> lista=new ArrayList();
        String sql="select * from emprestimo";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by nome";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Emprestimo(rs.getInt("codigo"), rs.getString("nome")) );
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
