
package biblioteca.dao;

import biblioteca.entity.Usuario;

public class UsuarioDAO {
    public boolean inserir (Usuario usuario)
    {
        String sql="insert into usuario (nome, rg, cpf, dataNasc) values ('$1', '$2', '$3', '$4')";
        sql = sql.replace("$1", usuario.getNome());
        sql = sql.replace("$2", usuario.getRg());
        sql = sql.replace("$3", usuario.getCpf());
        sql = sql.replace("$4", usuario.getDataNasc().toString());        
        Conexao con =new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Usuario usuario)
    {
        String sql="update usuario set nome = '$1', rg = '$2', cpf = '$3', dataNasc = '$4' where codigo = " + usuario.getCodigo();
        sql = sql.replace("$1", usuario.getNome());
        sql = sql.replace("$2", usuario.getRg());
        sql = sql.replace("$3", usuario.getCpf());
        sql = sql.replace("$4", usuario.getDataNasc().toString());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from usuario where codigo="+id);
        con.fecharConexao();
        return flag;                      
    }
}
