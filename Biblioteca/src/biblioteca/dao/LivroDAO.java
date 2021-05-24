
package biblioteca.dao;

import biblioteca.entity.Livro;

public class LivroDAO {
    public boolean inserir (Livro livro)
    {
        String sql = "insert into livro (titulo, genero, ano, autor, editora) values ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", livro.getTitulo());
        sql = sql.replace("$2", livro.getGenero());
        sql = sql.replace("$3", livro.getAno());
        sql = sql.replace("$4", livro.getAutor().getCodigo()+"");
        sql = sql.replace("$5", livro.getEditora().getCodigo()+"");
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Livro livro)
    {
        String sql="update autor set titulo = '$1', genero = '$2', ano = '$3', autor = '$4', editora = '$5' where codigo = "+ livro.getCodigo();
        sql = sql.replace("$1", livro.getTitulo());
        sql = sql.replace("$2", livro.getGenero());
        sql = sql.replace("$3", livro.getAno());
        sql = sql.replace("$4", livro.getAutor().getCodigo()+"");
        sql = sql.replace("$5", livro.getEditora().getCodigo()+"");
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from livro where codigo = "+id);
        con.fecharConexao();
        return flag;                      
    }
}
