
package biblioteca.dao;

import biblioteca.entity.Exemplar;

public class ExemplarDAO {
    public boolean inserir (Exemplar exemplar)
    {
        String sql = "insert into exemplar (qtde, valor, local, status, livro) values ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", exemplar.getQtde()+"");
        sql = sql.replace("$2", String.valueOf(exemplar.getValor()));
        sql = sql.replace("$3", exemplar.getLocal());
        sql = sql.replace("$4", String.valueOf(exemplar.getStatus()));
        sql = sql.replace("$5", exemplar.getLivro().getCodigo()+"");
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
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
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from exemplar where codigo="+id);
        con.fecharConexao();
        return flag;                      
    }
}
