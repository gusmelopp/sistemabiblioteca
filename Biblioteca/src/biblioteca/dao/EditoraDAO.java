
package biblioteca.dao;

import biblioteca.entity.Editora;
import biblioteca.entity.Editora;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditoraDAO {
    public boolean inserir (Editora editora)
    {
        String sql = "insert into editora (descricao) values ('$1')";
        sql = sql.replace("$1", editora.getDescricao());
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                              
    }
    
    public boolean alterar (Editora editora)
    {
        String sql = "update editora set descricao = '$1' where codigo ="+ editora.getCodigo();
        sql=sql.replace("$1",editora.getDescricao());
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        boolean flag = Singleton.getCon().manipular("delete from editora where codigo ="+id);
        return flag;                      
    }
    public static Editora getEditora(int cod)
    {
        Editora editora = null;
        String sql="select * from editora where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            editora = new Editora(rs.getInt("codigo"), rs.getString("descricao"));
        }
        catch(Exception e){System.out.println(e.toString());}
        return editora;
    }
    public static ArrayList <Editora> getEditora(String filtro)
    {   
        ArrayList <Editora> lista=new ArrayList();
        String sql="select * from editora";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by descricao";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Editora(rs.getInt("codigo"), rs.getString("descricao")) );
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
