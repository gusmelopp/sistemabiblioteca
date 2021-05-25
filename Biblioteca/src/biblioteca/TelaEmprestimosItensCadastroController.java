
package biblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaEmprestimosItensCadastroController implements Initializable {

    @FXML
    private ComboBox<?> cbExemplar;
    @FXML
    private DatePicker dtLimite;
    @FXML
    private DatePicker dtDevolucao;
    @FXML
    private TextField txValor;
    @FXML
    private ComboBox<?> cbDanificado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        cbExemplar.getScene().getWindow().hide();
    }
    
}
