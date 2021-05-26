
package biblioteca.dao;

import biblioteca.entity.Exemplar;
import biblioteca.entity.Exemplar;
import biblioteca.entity.Livro;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExemplarDAO {
    public boolean inserir (Exemplar exemplar)
    {
        String sql = "insert into exemplares (qtde, valoremprestimo, local, status, livro) values ('$1', '$2', '$3', '$4', '$5')";
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
        String sql="update exemplares set qtde = '$1', valoremprestimo = '$2', local = '$3', status = '$4', livro = '$5' where codigo ="+ exemplar.getCodigo();
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
        boolean flag = Singleton.getCon().manipular("delete from exemplares where codigo="+id);        
        return flag;                      
    }
    public static Exemplar getExemplar(int cod)
    {
        Exemplar exemplar = null;
        String sql="select * from exemplares where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            exemplar = new Exemplar(rs.getInt("codigo"), rs.getInt("qtde"), rs.getDouble("valoremprestimo"), rs.getString("local"), rs.getBoolean("status"), 
                    LivroDAO.getLivro(rs.getInt("livro")));
        }
        catch(Exception e){System.out.println(e.toString());}
        return exemplar;
    }
    public static ArrayList <Exemplar> getExemplar(String filtro)
    {   
        ArrayList <Exemplar> lista=new ArrayList();
        String sql="select * from exemplares exem INNER JOIN livros liv on liv.codigo = exem.livro";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by liv.titulo";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Exemplar(rs.getInt("codigo"), rs.getInt("qtde"), rs.getDouble("valoremprestimo"), rs.getString("local"), rs.getBoolean("status"),
                    new Livro(rs.getInt("livro"), rs.getString("titulo"), rs.getString("genero"), rs.getString("ano"), AutorDAO.getAutor(rs.getInt("autor")), EditoraDAO.getEditora(rs.getInt("editora")))
                     //LivroDAO.getLivro(rs.getInt("livro"))
             ));
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
