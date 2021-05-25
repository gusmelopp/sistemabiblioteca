
package biblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class TelaFuncionariosCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txRG;
    @FXML
    private TextField txCPF;
    @FXML
    private TextField txNascimento;
    @FXML
    private TextField txCTPS;
    @FXML
    private TextField txPIS;
    @FXML
    private TextField txSalario;

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
