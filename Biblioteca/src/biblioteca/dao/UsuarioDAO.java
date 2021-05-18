
package biblioteca.dao;

public class UsuarioDAO {
    public boolean inserir (Cidade c)
    {
        String sql="insert into cidades (cid_nome, est_cod) values ('$1','$2')";
        sql = sql.replace("$1", c.getNome());
        sql = sql.replace("$2", ""+c.getEstado().getCodigo());
        Conexao con =new Conexao();
        boolean flag=con.manipular(sql);
        con.desconectar();
        return flag;                              
    }
    
    public boolean alterar (Cidade c)
    {
        String sql="update cidades set cid_nome='$1', est_cod='$2' where cid_cod="+ c.getCodigo();
        sql=sql.replace("$1",c.getNome());
        sql=sql.replace("$2",c.getEstado().getCodigo()+"");
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.desconectar();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from cidades where cid_cod="+id);
        con.desconectar();
        return flag;                      
    }
}
