
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaFuncionariosController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colNome;
    @FXML
    private TableColumn<?, ?> colRG;
    @FXML
    private TableColumn<?, ?> colCPF;
    @FXML
    private TableColumn<?, ?> colNascimento;
    @FXML
    private TableColumn<?, ?> colCTPS;
    @FXML
    private TableColumn<?, ?> colPIS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private void carregarTabela(String filtro) {
        /*FuncionarioDAO dao = new FuncionarioDAO();
        List <Funcionario> funcionarios = dao.get(filtro);
        tabela.setItems(FXCollections.observableArrayList(funcionarios));*/
    }
    
    @FXML
    private void evtFiltrar(ActionEvent event) {
    }

    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaFuncionariosCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Funcionário");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //carregarTabela("");
    }

    @FXML
    private void evtFechar(ActionEvent event) {
        txFiltro.getScene().getWindow().hide();
    }

    @FXML
    private void evtAlterar(ActionEvent event) throws IOException {
        //funcionarios = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaFuncionariosCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Funcionário");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //funcionarios = null;
        //carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        /*int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new FuncionarioDAO().apagar(id);
            carregarTabela("");
        }*/
    }
    
}
