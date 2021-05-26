
package biblioteca;

import biblioteca.dao.ClienteDAO;
import biblioteca.dao.FuncionarioDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Cliente;
import biblioteca.entity.Funcionario;
import biblioteca.util.MaskFieldUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
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
    private TextField txCTPS;
    @FXML
    private TextField txPIS;
    @FXML
    private TextField txSalario;
    @FXML
    private DatePicker dtNascimento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MaskFieldUtil.cpfField(txCPF);
        
        if(TelaFuncionariosController.funcionario != null)
        {
            Funcionario f = TelaFuncionariosController.funcionario;
            txId.setText("" + f.getCodigo());
            txNome.setText(f.getNome());
            txRG.setText(f.getRg());
            txCPF.setText(f.getCpf());
            txCTPS.setText(f.getCtps());
            txPIS.setText(f.getPis());
            txSalario.setText(""+f.getSalario());
            dtNascimento.setValue(f.getDataNasc());
        }
        Platform.runLater(()->{txNome.requestFocus();});
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Funcionario funcionario = new Funcionario(txNome.getText(), txRG.getText(), txCPF.getText(), dtNascimento.getValue(), txCTPS.getText(), txPIS.getText(), Double.parseDouble(txSalario.getText()));
        if(txId.getText().isEmpty())
        {
            if(!new FuncionarioDAO().inserir(funcionario))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            funcionario.setCodigo(Integer.parseInt(txId.getText()));
            if(!new FuncionarioDAO().alterar(funcionario))
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
