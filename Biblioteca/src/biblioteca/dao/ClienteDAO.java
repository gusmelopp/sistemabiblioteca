
package biblioteca.dao;

import biblioteca.entity.Cliente;
import biblioteca.entity.Cliente;
import biblioteca.entity.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO {
    public boolean inserir (Cliente cliente)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.inserir(new Usuario(cliente.getNome(), cliente.getRg(), cliente.getCpf(), cliente.getDataNasc())))
        {
            
            int cod = Singleton.getCon().getMaxPK("usuario","codigo");
            
            String sql="insert into cliente (cart, estudante, usuario) values ('$1', '$2', '$3')";
            sql = sql.replace("$1", cliente.getCart());
            sql = sql.replace("$2", cliente.isEstudante()+"");
            sql = sql.replace("$3", cod+"");
            flag = Singleton.getCon().manipular(sql); 
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
            flag = Singleton.getCon().manipular(sql);             
        }
        return flag;                    
    }
    
    public boolean apagar(int id)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        if(Singleton.getCon().manipular("delete from cliente where codigo="+id));
            flag = dao.apagar(id);
        return flag;                     
    }
    public static Cliente getCliente(int cod)
    {
        Cliente cliente = null;
        String sql="select * from usuario inner join cliente on usuario.codigo = cliente.codigo where usuario.codigo ="+cod;
       
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            cliente = new Cliente(rs.getInt("usu.codigo"), rs.getString("usu.nome"), rs.getString("usu.rg"), rs.getString("usu.cpf"), LocalDate.parse(rs.getString("usu.dataNasc")), rs.getString("cli.cart"), rs.getBoolean("estudante"));
        }
        catch(Exception e){System.out.println(e.toString());}
        return cliente;
    }
    public static ArrayList <Cliente> getCliente(String filtro)
    {   
        ArrayList <Cliente> lista = new ArrayList(); 
        String sql="select * from usuario usu INNER JOIN cliente cli on usu.codigo = cli.usuario";  
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by usu.nome";
        ResultSet rs = Singleton.getCon().consultar(sql);         
        try
        {
          while(rs.next())
             lista.add(new Cliente(rs.getInt("usu.codigo"), rs.getString("usu.nome"), rs.getString("usu.rg"), rs.getString("usu.cpf"), LocalDate.parse(rs.getString("usu.dataNasc")), rs.getString("cli.cart"), rs.getBoolean("estudante")) );
        }
        catch(Exception e){System.out.println(e);}     
        
       
        return lista;
    }
}
