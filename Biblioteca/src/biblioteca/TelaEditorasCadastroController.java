
package biblioteca;

import biblioteca.dao.EditoraDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Editora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TelaEditorasCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txNome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(TelaEditorasController.editora != null)
        {
            Editora e = TelaEditorasController.editora;
            txId.setText("" + e.getCodigo());
            txNome.setText(e.getNome());
        }
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Editora editora = new Editora(txNome.getText());
        if(txId.getText().isEmpty())
        {
            if(!new EditoraDAO().inserir(editora))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            editora.setCodigo(Integer.parseInt(txId.getText()));
            if(!new EditoraDAO().alterar(editora))
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
