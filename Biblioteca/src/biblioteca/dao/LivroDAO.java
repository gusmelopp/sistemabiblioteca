
package biblioteca.dao;

import biblioteca.entity.Livro;
import biblioteca.entity.Livro;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroDAO {
    public boolean inserir (Livro livro)
    {
        String sql = "insert into livros (titulo, genero, ano, autor, editora) values ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", livro.getTitulo());
        sql = sql.replace("$2", livro.getGenero());
        sql = sql.replace("$3", livro.getAno());
        sql = sql.replace("$4", livro.getAutor().getCodigo()+"");
        sql = sql.replace("$5", livro.getEditora().getCodigo()+"");
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                              
    }
    
    public boolean alterar (Livro livro)
    {
        String sql="update livros set titulo = '$1', genero = '$2', ano = '$3', autor = $4, editora = $5 where codigo = "+ livro.getCodigo();
        sql = sql.replace("$1", livro.getTitulo());
        sql = sql.replace("$2", livro.getGenero());
        sql = sql.replace("$3", livro.getAno());
        sql = sql.replace("$4", livro.getAutor().getCodigo()+"");
        sql = sql.replace("$5", livro.getEditora().getCodigo()+"");
        boolean flag = Singleton.getCon().manipular(sql); 
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        boolean flag = Singleton.getCon().manipular("delete from livros where codigo = "+id);;
        return flag;                      
    }
    public static Livro getLivro(int cod)
    {
        Livro livro = null;
        String sql="select * from livros where codigo ="+cod;
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            livro = new Livro(rs.getInt("codigo"), rs.getString("titulo"), rs.getString("genero"), rs.getString("ano"), AutorDAO.getAutor(rs.getInt("autor")), EditoraDAO.getEditora(rs.getInt("editora")));
        }
        catch(Exception e){System.out.println(e.toString());}
        return livro;
    }
    public static ArrayList <Livro> getLivro(String filtro)
    {   
        ArrayList <Livro> lista=new ArrayList();
        String sql="select * from livros";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by titulo";
        ResultSet rs = Singleton.getCon().consultar(sql); 
        try
        {
          while(rs.next())
             lista.add(new Livro(rs.getInt("codigo"), rs.getString("titulo"), rs.getString("genero"), rs.getString("ano"), AutorDAO.getAutor(rs.getInt("autor")), EditoraDAO.getEditora(rs.getInt("editora"))));
        }
        catch(Exception e){System.out.println(e);}
        return lista;
    }
}
