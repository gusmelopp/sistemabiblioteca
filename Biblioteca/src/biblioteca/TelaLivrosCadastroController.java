
package biblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaLivrosCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txRG;
    @FXML
    private TextField txCPF;
    @FXML
    private ComboBox<?> cbAutor;
    @FXML
    private ComboBox<?> cbEditora;

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
