
package biblioteca.dao;

import biblioteca.entity.Autor;

public class AutorDAO {

    public boolean inserir (Autor autor)
    {
        String sql = "insert into autor (nome) values ('$1')";
        sql = sql.replace("$1", autor.getNome());
        Conexao con =new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                              
    }
    
    public boolean alterar (Autor autor)
    {
        String sql="update autor set nome = '$1' where codigo = "+ autor.getCodigo();
        sql = sql.replace("$1",autor.getNome());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.desconectar();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from autor where codigo = "+id);
        con.desconectar();
        return flag;                      
    }
    
    /*public Cidade getCidade(int cod)
    {
        Cidade c = null;
        String sql="select * from cidades where cid_cod ="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            c = new Cidade(rs.getInt("cid_cod"),rs.getString("cid_nome"), new DALEstado().getEstado(rs.getInt("est_cod")));
        }
        catch(Exception e){System.out.println(e);}
        con.desconectar();
        return c;
    }
    public ArrayList <Cidade> getCidade(String filtro)
    {   
        ArrayList <Cidade> lista=new ArrayList();
        String sql="select * from cidades";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by cid_nome";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
          new Cidade(rs.getInt("cid_cod"),rs.getString("cid_nome"), new DALEstado().getEstado(rs.getInt("est_cod"))));
        }
        catch(Exception e){System.out.println(e);}
        con.desconectar();
        return lista;
    }*/
}
