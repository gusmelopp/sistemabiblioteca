
package biblioteca.dao;

import biblioteca.entity.Funcionario;

public class FuncionarioDAO {
    public boolean inserir (Funcionario func)
    {
        String sql="insert into funcionarios (nome, sobrenome, rg, cpf, dataNasc, ctps, pis, salario) values ('$1', '$2', '$3', '$4', '$5', '$6', '$7', '$8')";
        sql = sql.replace("$1", func.getNome());
        sql = sql.replace("$2", func.getSobrenome());
        sql = sql.replace("$3", func.getRg());
        sql = sql.replace("$4", func.getCpf());
        sql = sql.replace("$5", func.getDataNasc().toString()); 
        sql = sql.replace("$6", func.getCtps()); 
        sql = sql.replace("$7", func.getPis()); 
        sql = sql.replace("$8", String.valueOf(func.getSalario()));
        
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);  
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Funcionario func)
    {
        String sql="update funcionarios set nome = '$1', sobrenome = '$2', rg = '$3', cpf = '$4', dataNasc = '$5', ctps = '$6', pis = '$7', salario = '$8' where cid_cod="+ func.getCodigo();
        sql = sql.replace("$1", func.getNome());
        sql = sql.replace("$2", func.getSobrenome());
        sql = sql.replace("$3", func.getRg());
        sql = sql.replace("$4", func.getCpf());
        sql = sql.replace("$5", func.getDataNasc().toString()); 
        sql = sql.replace("$6", func.getCtps()); 
        sql = sql.replace("$7", func.getPis()); 
        sql = sql.replace("$8", String.valueOf(func.getSalario()));
        
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from funcionarios where codigo="+id);
        con.fecharConexao();
        return flag;                      
    }
}
