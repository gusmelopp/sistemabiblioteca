
package biblioteca.dao;


public class Singleton {
    
    private static Conexao conexao;
    
    public static Conexao getCon(){
        if(conexao == null)
            conexao = new Conexao();       
        return conexao;
    }
    
}
