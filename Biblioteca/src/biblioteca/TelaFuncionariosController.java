
package biblioteca;

import biblioteca.dao.FuncionarioDAO;
import biblioteca.entity.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaFuncionariosController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, Integer> colId;
    @FXML
    private TableColumn<Funcionario, String> colNome;
    @FXML
    private TableColumn<Funcionario, String> colRG;
    @FXML
    private TableColumn<Funcionario, String> colCPF;
    @FXML
    private TableColumn<Funcionario, LocalDate> colNascimento;
    @FXML
    private TableColumn<Funcionario, String> colCTPS;
    @FXML
    private TableColumn<Funcionario, String> colPIS;
    @FXML
    private TableColumn<Funcionario, Double> colSalario;
    
    static public Funcionario funcionario = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        colCTPS.setCellValueFactory(new PropertyValueFactory<>("ctps"));
        colPIS.setCellValueFactory(new PropertyValueFactory<>("pis"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        List <Funcionario> funcionarios = FuncionarioDAO.getFuncionario(filtro);
        tabela.setItems(FXCollections.observableArrayList(funcionarios));
    }
    
    @FXML
    private void evtFiltrar(ActionEvent event) {
        String filtro=" upper(nome) like '%#%'";
        filtro=filtro.replace("#", txFiltro.getText().toUpperCase());
        carregarTabela(filtro);
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
        carregarTabela("");
    }

    @FXML
    private void evtFechar(ActionEvent event) {
        txFiltro.getScene().getWindow().hide();
    }

    @FXML
    private void evtAlterar(ActionEvent event) throws IOException {
        funcionario = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaFuncionariosCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Funcionário");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        funcionario = null;
        carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new FuncionarioDAO().apagar(id);
            carregarTabela("");
        }
    }
    
}
