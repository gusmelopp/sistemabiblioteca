
package biblioteca;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaEmprestimosCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txCartao;
    @FXML
    private TextField txMulta;
    @FXML
    private TextField txResponsavel;
    @FXML
    private DatePicker dtEmprestimo;
    @FXML
    private TextField txTotal;
    @FXML
    private TableColumn<?, ?> colTitulo;
    @FXML
    private TableColumn<?, ?> colDtLimite;
    @FXML
    private TableColumn<?, ?> colDtDevolucao;
    @FXML
    private TableColumn<?, ?> colValor;
    @FXML
    private TextField txStatus;
    @FXML
    private TableColumn<?, ?> colSituacao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void evtAlterar(ActionEvent event) throws IOException {
        //itens = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaEmprestimosItensCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Item Emprestimo");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //itens = null;
        //carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
    }

    @FXML
    private void evtDanificado(ActionEvent event) {
    }

    @FXML
    private void evtAdicionar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaEmprestimosItensCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Item Emprestimo");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //carregarTabela("");
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        txId.getScene().getWindow().hide();
    }
    
}
