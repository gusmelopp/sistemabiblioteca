
package biblioteca;

import biblioteca.dao.AutorDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Autor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TelaAutoresCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txNome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(TelaAutoresController.autor != null)
        {
            Autor a = TelaAutoresController.autor;
            txId.setText("" + a.getCodigo());
            txNome.setText(a.getNome());
        }
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Autor autor = new Autor(txNome.getText());
        if(txId.getText().isEmpty())
        {
            if(!new AutorDAO().inserir(autor))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            autor.setCodigo(Integer.parseInt(txId.getText()));
            if(!new AutorDAO().alterar(autor))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao alterar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
            txId.getScene().getWindow().hide();
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        txId.getScene().getWindow().hide();
    }
    
}
