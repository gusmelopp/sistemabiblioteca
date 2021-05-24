
package biblioteca.dao;

import biblioteca.entity.Funcionario;
import biblioteca.entity.Funcionario;
import biblioteca.entity.Usuario;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuncionarioDAO {
    public boolean inserir (Funcionario func)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.inserir(new Usuario(func.getNome(), func.getRg(), func.getCpf(), func.getDataNasc())))
        {
            int cod = Singleton.getCon().getMaxPK("usuario","codigo");
            
            String sql="insert into funcionarios (salario, ctps, pis, usuario) values ('$1', '$2', '$3', '$4')";
            sql = sql.replace("$1", func.getSalario()+"");
            sql = sql.replace("$2", func.getCtps());
            sql = sql.replace("$3", func.getPis());
            sql = sql.replace("$4", "" + cod);
            flag = Singleton.getCon().manipular(sql); 
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
            flag = Singleton.getCon().manipular(sql); 
            
        }
        return flag;
    }
    
    public boolean apagar(int id)
    {
        boolean flag = false;
        UsuarioDAO dao = new UsuarioDAO();
        if(Singleton.getCon().manipular("delete from funcionarios where usuario="+id));
            flag = dao.apagar(id);
        
        return flag;                      
    }
     public static Funcionario getFuncionario(int cod)
    {
        Funcionario funcionario = null;
        String sql="select * from usuario inner join funcionario on usuario.codigo = funcionario.codigo where usuario.codigo ="+cod;
       
        ResultSet rs =  Singleton.getCon().consultar(sql); 
        try
        {
          if (rs.next())
            funcionario = new Funcionario(rs.getInt("usu.codigo"), rs.getString("usu.nome"), rs.getString("usu.rg"), rs.getString("usu.cpf"), LocalDate.parse(rs.getString("usu.dataNasc")), rs.getString("func.ctps"), rs.getString("pis"), rs.getDouble("salario"));
        }
        catch(Exception e){System.out.println(e.toString());}
        return funcionario;
    }
    public static ArrayList <Funcionario> getFuncionario(String filtro)
    {   
        ArrayList <Funcionario> lista = new ArrayList(); 
        String sql="select * from usuario usu INNER JOIN funcionario func on usu.codigo = func.usuario";  
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by func.nome";
        ResultSet rs = Singleton.getCon().consultar(sql);         
        try
        {
          while(rs.next())
             lista.add(new Funcionario(rs.getInt("usu.codigo"), rs.getString("usu.nome"), rs.getString("usu.rg"), rs.getString("usu.cpf"), LocalDate.parse(rs.getString("usu.dataNasc")), rs.getString("func.ctps"), rs.getString("pis"), rs.getDouble("salario")) );
        }
        catch(Exception e){System.out.println(e);}
        
        
       
        return lista;
    }
}
