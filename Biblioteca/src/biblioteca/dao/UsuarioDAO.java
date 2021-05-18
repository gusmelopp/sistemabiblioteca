
package biblioteca.dao;

import biblioteca.entity.Usuario;

public class UsuarioDAO {
    public boolean inserir (Usuario usuario)
    {
        String sql="insert into usuario (nome, sobrenome, rg, cpf, dataNasc) values ('$1', '$2', '$3', '$4', '$5')";
        sql = sql.replace("$1", usuario.getNome());
        sql = sql.replace("$2", usuario.getSobrenome());
        sql = sql.replace("$3", usuario.getRg());
        sql = sql.replace("$4", usuario.getCpf());
        sql = sql.replace("$5", usuario.getDataNasc().toString());        
        Conexao con =new Conexao();
        boolean flag=con.manipular(sql);
        con.desconectar();
        return flag;                              
    }
    
    public boolean alterar (Usuario usuario)
    {
        String sql="update usuario set nome = '$1', sobrenome = '$2', rg = '$3', cpf = '$4', dataNasc = '$5' where codigo = " + usuario.getCodigo();
        sql = sql.replace("$1", usuario.getNome());
        sql = sql.replace("$2", usuario.getSobrenome());
        sql = sql.replace("$3", usuario.getRg());
        sql = sql.replace("$4", usuario.getCpf());
        sql = sql.replace("$5", usuario.getDataNasc().toString());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.desconectar();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from usuario where codigo="+id);
        con.desconectar();
        return flag;                      
    }
}
