
package biblioteca.dao;

import biblioteca.entity.Exemplar;
import biblioteca.entity.Exemplar;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExemplarDAO {
    public boolean inserir (Exemplar exemplar)
    {
        String sql = "insert into exemplar (qtde, valor, local, status, livro) values ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", exemplar.getQtde()+"");
        sql = sql.replace("$2", String.valueOf(exemplar.getValor()));
        sql = sql.replace("$3", exemplar.getLocal());
        sql = sql.replace("$4", String.valueOf(exemplar.getStatus()));
        sql = sql.replace("$5", exemplar.getLivro().getCodigo()+"");
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                              
    }
    
    public boolean alterar (Exemplar exemplar)
    {
        String sql="update exemplar set qtde = '$1', valor = '$2', local = '$3', status = '$4', livro = '$5' where codigo ="+ exemplar.getCodigo();
        sql = sql.replace("$1", exemplar.getQtde()+"");
        sql = sql.replace("$2", String.valueOf(exemplar.getValor()));
        sql = sql.replace("$3", exemplar.getLocal());
        sql = sql.replace("$4", String.valueOf(exemplar.getStatus()));
        sql = sql.replace("$5", exemplar.getLivro().getCodigo()+"");
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        boolean flag = Singleton.getCon().manipular("delete from exemplar where codigo="+id);        
        return flag;                      
    }
    public Exemplar getExemplar(int cod)
    {
        Exemplar exemplar = null;
        String sql="select * from exemplar where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            exemplar = new Exemplar(rs.getInt("codigo"), rs.getInt("qtde"), rs.getDouble("valor"), rs.getString("local"), rs.getBoolean("status"), LivroDAO.getLivro(rs.getInt("livro")));
        }
        catch(Exception e){System.out.println(e.toString());}
        return exemplar;
    }
    public ArrayList <Exemplar> getExemplar(String filtro)
    {   
        ArrayList <Exemplar> lista=new ArrayList();
        String sql="select * from exemplar INNER JOIN livro on livro.codigo = exemplar.livro";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by livro.titulo";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Exemplar(rs.getInt("codigo"), rs.getInt("qtde"), rs.getDouble("valor"), rs.getString("local"), rs.getBoolean("status"), LivroDAO.getLivro(rs.getInt("livro"))));
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
