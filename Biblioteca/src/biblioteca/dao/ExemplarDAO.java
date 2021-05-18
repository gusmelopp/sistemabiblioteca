
package biblioteca.dao;

import biblioteca.entity.Exemplar;

public class ExemplarDAO {
    public boolean inserir (Exemplar exemplar)
    {
        String sql="insert into exemplar (genero,titulo, local, status, autor, editora) values ('$1','$2','$3','$4','$5','$6')";
        sql = sql.replace("$1", exemplar.getGenero());
        sql = sql.replace("$2", exemplar.getTitulo());
        sql = sql.replace("$3", exemplar.getLocal());
        sql = sql.replace("$4", String.valueOf(exemplar.getStatus()));
        sql = sql.replace("$5", exemplar.getAutor().getCodigo()+"");
        sql = sql.replace("$6", exemplar.getEditora().getCodigo()+"");    
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                              
    }
    
    public boolean alterar (Exemplar exemplar)
    {
        String sql="update exemplar set genero='$1', titulo='$2', local='$3', status='$4', autor='$5', editora='$6' where codigo="+ exemplar.getCodigo();
        sql = sql.replace("$1", exemplar.getGenero());
        sql = sql.replace("$2", exemplar.getTitulo());
        sql = sql.replace("$3", exemplar.getLocal());
        sql = sql.replace("$4", String.valueOf(exemplar.getStatus()));
        sql = sql.replace("$5", exemplar.getAutor().getCodigo()+"");
        sql = sql.replace("$6", exemplar.getEditora().getCodigo()+"");   
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from exemplar where codigo="+id);
        con.desconectar();
        return flag;                      
    }
}
