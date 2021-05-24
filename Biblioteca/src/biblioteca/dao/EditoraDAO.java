
package biblioteca.dao;

import biblioteca.entity.Editora;

public class EditoraDAO {
    public boolean inserir (Editora editora)
    {
        String sql = "insert into editora (descricao) values ('$1')";
        sql = sql.replace("$1", editora.getDescricao());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Editora editora)
    {
        String sql = "update editora set descricao = '$1' where codigo ="+ editora.getCodigo();
        sql=sql.replace("$1",editora.getDescricao());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from editora where codigo ="+id);
        con.fecharConexao();
        return flag;                      
    }
}
