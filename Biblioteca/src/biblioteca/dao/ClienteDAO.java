
package biblioteca.dao;

import biblioteca.entity.Cliente;
import biblioteca.entity.Usuario;

public class ClienteDAO {
    public boolean inserir (Cliente cliente)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.inserir(new Usuario(cliente.getNome(), cliente.getRg(), cliente.getCpf(), cliente.getDataNasc())))
        {
            Conexao con = new Conexao();
            int cod = con.getMaxPK("usuario","codigo");
            
            String sql="insert into cliente (cart, estudante, usuario) values ('$1', '$2', '$3')";
            sql = sql.replace("$1", cliente.getCart());
            sql = sql.replace("$2", cliente.isEstudante()+"");
            sql = sql.replace("$3", cod+"");
            flag = con.manipular(sql);  
            con.fecharConexao();
        }
        return flag;                         
    }
    
    public boolean alterar (Cliente cliente)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.alterar(new Usuario(cliente.getCodigo(), cliente.getNome(), cliente.getRg(), cliente.getCpf(), cliente.getDataNasc())))
        {
            String sql="update cliente set cart = '$1', estudante = '$2' where usuario="+ cliente.getCodigo();
            sql = sql.replace("$1", cliente.getCart());
            sql = sql.replace("$2", cliente.isEstudante()+"");
            Conexao con=new Conexao();
            flag=con.manipular(sql);
            con.fecharConexao();
        }
        return flag;                    
    }
    
    public boolean apagar(int id)
    {
        boolean flag = false;
        Conexao con=new Conexao();
        UsuarioDAO dao = new UsuarioDAO();
        if(con.manipular("delete from cliente where codigo="+id));
            flag = dao.apagar(id);
        con.fecharConexao();
        return flag;                     
    }
}
