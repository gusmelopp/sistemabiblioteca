
package biblioteca.dao;

import biblioteca.entity.Emprestimo;
import biblioteca.entity.EmprestimoExemplar;

public class EmprestimoDAO {
     public boolean inserir (Emprestimo emprestimo)
    {
        String sql = "insert into emprestimo (dtEmprestimo, totalValor, totalMulta, status, funcionario, cliente) values ('$1','$2','$3','$4','$5','$6')";
        sql = sql.replace("$1", emprestimo.getDtEmprestimo().toString());
        sql = sql.replace("$2", emprestimo.getTotalValor()+"");
        sql = sql.replace("$3", emprestimo.getTotalMulta()+"");
        sql = sql.replace("$4", String.valueOf(emprestimo.getStatus()));
        sql = sql.replace("$5", emprestimo.getFuncionario().getCodigo()+"");
        sql = sql.replace("$6", emprestimo.getCliente().getCodigo()+"");
        
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        if(flag){
            int cod = con.getMaxPK("emprestimo","codigo");
            for(EmprestimoExemplar ep : emprestimo.getExemplares()){
                sql = "insert into emprestimoExemplares (emprestimo, exemplar, dataDev, dataLim) values ('$1','$2','$3','$4')";
                sql = sql.replace("$1", cod+"");
                sql = sql.replace("$2", ep.getExemplar().getCodigo()+"");
                sql = sql.replace("$3", ep.getDataDev().toString());
                sql = sql.replace("$4", ep.getDataLim().toString());
                flag = con.manipular(sql);
            }
        }
        con.fecharConexao();
        return flag;                              
    }
    
    public boolean alterar (Emprestimo emprestimo)
    {
        String sql = "update emprestimo set dtEmprestimo = '$1', totalValor = '$2', totalMulta = '$3', status = '$4', funcionario = '$5', cliente='$6' where codigo ="+ emprestimo.getCodigo();
        sql = sql.replace("$1", emprestimo.getDtEmprestimo().toString());
        sql = sql.replace("$2", emprestimo.getTotalValor()+"");
        sql = sql.replace("$3", emprestimo.getTotalMulta()+"");
        sql = sql.replace("$4", String.valueOf(emprestimo.getStatus()));
        sql = sql.replace("$5", emprestimo.getFuncionario().getCodigo()+"");
        sql = sql.replace("$6", emprestimo.getCliente().getCodigo()+"");
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from emprestimo where codigo ="+id);
        con.fecharConexao();
        return flag;                      
    }
}
