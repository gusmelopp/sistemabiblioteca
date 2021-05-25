
package biblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaExemplaresCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txQuantidade;
    @FXML
    private TextField txLocal;
    @FXML
    private TextField txValor;
    @FXML
    private ComboBox<?> cbLivro;
    @FXML
    private TextField txStatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        txId.getScene().getWindow().hide();
    }
    
}
