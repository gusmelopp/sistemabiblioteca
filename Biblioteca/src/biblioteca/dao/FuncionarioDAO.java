
package biblioteca.dao;

import biblioteca.entity.Funcionario;
import biblioteca.entity.Usuario;

public class FuncionarioDAO {
    public boolean inserir (Funcionario func)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.inserir(new Usuario(func.getNome(), func.getRg(), func.getCpf(), func.getDataNasc())))
        {
            Conexao con = new Conexao();
            int cod = con.getMaxPK("usuario","codigo");
            
            String sql="insert into funcionarios (salario, ctps, pis, usuario) values ('$1', '$2', '$3', '$4')";
            sql = sql.replace("$1", func.getSalario()+"");
            sql = sql.replace("$2", func.getCtps());
            sql = sql.replace("$3", func.getPis());
            sql = sql.replace("$4", "" + cod);
            flag = con.manipular(sql);  
            con.fecharConexao();
        }
        return flag;                       
    }
    
    public boolean alterar (Funcionario func)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.alterar(new Usuario(func.getCodigo(), func.getNome(), func.getRg(), func.getCpf(), func.getDataNasc())))
        {
            String sql="update funcionarios set ctps = '$1', pis = '$2', salario = '$3' where usuario="+ func.getCodigo();
            sql = sql.replace("$1", func.getCtps());
            sql = sql.replace("$2", func.getPis());
            sql = sql.replace("$3", func.getSalario()+"");
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
        if(con.manipular("delete from funcionarios where usuario="+id));
            flag = dao.apagar(id);
        con.fecharConexao();
        return flag;                      
    }
}
