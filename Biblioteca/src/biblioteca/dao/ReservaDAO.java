
package biblioteca.dao;

import biblioteca.entity.Reserva;

public class ReservaDAO {
    public boolean inserir (Reserva reserva)
    {
        String sql="insert into reserva (data, cliente, exemplar) values ('$1', '$2', '$3')";
        sql = sql.replace("$1", reserva.getData().toString());
        sql = sql.replace("$2", reserva.getCliente().getCodigo() + "");
        sql = sql.replace("$3", reserva.getExemplar().getCodigo() + "");       
        Conexao con =new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Reserva reserva)
    {
        String sql="update reserva set data = '$1', cliente = '$2', exemplar = '$3' where codigo = "+ reserva.getCodigo();
        sql = sql.replace("$1", reserva.getData().toString());
        sql = sql.replace("$2", reserva.getCliente().getCodigo() + "");
        sql = sql.replace("$3", reserva.getExemplar().getCodigo() + ""); 
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from reserva where codigo="+id);
        con.fecharConexao();
        return flag;                      
    }
}
