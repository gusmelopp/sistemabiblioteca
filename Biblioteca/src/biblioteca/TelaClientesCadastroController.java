
package biblioteca;

import biblioteca.dao.ClienteDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Cliente;
import biblioteca.util.MaskFieldUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaClientesCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txRG;
    @FXML
    private TextField txCPF;
    @FXML
    private TextField txCarteirinha;
    @FXML
    private DatePicker dtNacismento;
    @FXML
    private ComboBox<String> cbEstudante;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        MaskFieldUtil.cpfField(txCPF);
        cbEstudante.getItems().addAll("Sim", "Não");
        
        if(TelaClientesController.cliente != null)
        {
            Cliente c = TelaClientesController.cliente;
            txId.setText("" + c.getCodigo());
            txNome.setText(c.getNome());
            txRG.setText(c.getRg());
            txCPF.setText(c.getCpf());
            txCarteirinha.setText(c.getCart());
            dtNacismento.setValue(c.getDataNasc());
            if(c.isEstudante())
                cbEstudante.getSelectionModel().select("Sim");
            else
                cbEstudante.getSelectionModel().select("Não"); 
        }
        Platform.runLater(()->{txNome.requestFocus();});
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Cliente cliente = new Cliente(txNome.getText(), txRG.getText(), txCPF.getText(), dtNacismento.getValue(), txCarteirinha.getText(), false);
        if(cbEstudante.getSelectionModel().getSelectedItem().equals("Sim"))
            cliente.setEstudante(true);
        if(txId.getText().isEmpty())
        {
            if(!new ClienteDAO().inserir(cliente))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            cliente.setCodigo(Integer.parseInt(txId.getText()));
            if(!new ClienteDAO().alterar(cliente))
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
