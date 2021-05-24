
package biblioteca;

import biblioteca.dao.Conexao;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Biblioteca {

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Conexao con = new Conexao();
        if(!con.getEstadoConexao())
        {
            JOptionPane.showMessageDialog(null,"Erro ao conectar o banco\n"+con.getMensagemErro());
            Platform.exit();
        }
        else
            launch(args);
    }
}