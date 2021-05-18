
package biblioteca.dao;

import biblioteca.entity.Cliente;

public class ClienteDAO {
    public boolean inserir (Cliente cliente)
    {
        String sql = "insert into cliente (nome, sobrenome, rg, cpf, dataNasc, cart, estudante) values ('$1','$2','$3','$4','$5','$6','$7')";
        sql = sql.replace("$1", cliente.getNome());
        sql = sql.replace("$2", cliente.getSobrenome());
        sql = sql.replace("$3", cliente.getRg());
        sql = sql.replace("$4", cliente.getCpf());
        sql = sql.replace("$5", cliente.getDataNasc().toString());
        sql = sql.replace("$6", cliente.getCart());
        sql = sql.replace("$7", String.valueOf(cliente.isEstudante()));
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                              
    }
    
    public boolean alterar (Cliente cliente)
    {
        String sql="update cliente set nome = '$1', sobrenome = '$2', rg = '$3', cpf = '$4', dataNasc = '$5', cart = '$6', estudante = '$7' where codigo ="+ cliente.getCodigo();
        sql = sql.replace("$1", cliente.getNome());
        sql = sql.replace("$2", cliente.getSobrenome());
        sql = sql.replace("$3", cliente.getRg());
        sql = sql.replace("$4", cliente.getCpf());
        sql = sql.replace("$5", cliente.getDataNasc().toString());
        sql = sql.replace("$6", cliente.getCart());
        sql = sql.replace("$7", String.valueOf(cliente.isEstudante()));
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from cliente where codigo="+id);
        con.desconectar();
        return flag;                      
    }
}
