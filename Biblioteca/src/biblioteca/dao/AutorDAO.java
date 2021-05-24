
package biblioteca.dao;

import biblioteca.entity.Autor;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AutorDAO {

    public boolean inserir (Autor autor)
    {
        String sql = "insert into autor (nome) values ('$1')";
        sql = sql.replace("$1", autor.getNome());        
        boolean flag = Singleton.getCon().manipular(sql);        
        return flag;                              
    }
    
    public boolean alterar (Autor autor)
    {
        String sql="update autor set nome = '$1' where codigo = "+ autor.getCodigo();
        sql = sql.replace("$1",autor.getNome());
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        boolean flag = Singleton.getCon().manipular("delete from autor where codigo = "+id);
        return flag;                      
    }
    
    public static Autor getAutor(int cod)
    {
        Autor autor = null;
        String sql="select * from autor where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            autor = new Autor(rs.getInt("codigo"), rs.getString("nome"));
        }
        catch(Exception e){System.out.println(e.toString());}
        return autor;
    }
    public static ArrayList <Autor> getAutor(String filtro)
    {   
        ArrayList <Autor> lista=new ArrayList();
        String sql="select * from autor";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by nome";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Autor(rs.getInt("codigo"), rs.getString("nome")) );
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
