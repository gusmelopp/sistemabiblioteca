
package biblioteca;

import biblioteca.dao.ClienteDAO;
import biblioteca.entity.Cliente;
import biblioteca.entity.Exemplar;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaClientesController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn<Cliente, Integer> colId;
    @FXML
    private TableColumn<Cliente, String> colNome;
    @FXML
    private TableColumn<Cliente, String> colRG;
    @FXML
    private TableColumn<Cliente, String> colCPF;
    @FXML
    private TableColumn<Cliente, LocalDate> colNascimento;
    @FXML
    private TableColumn<Cliente, String> colCartao;
    @FXML
    private TableColumn<Cliente, Boolean> colEstudante;
    
    static public Cliente cliente = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        colCartao.setCellValueFactory(new PropertyValueFactory<>("cart"));
        colEstudante.setCellValueFactory(new PropertyValueFactory<>("estudante"));
        
        colEstudante.setCellFactory(
                tc -> new TableCell<Cliente, Boolean>() {
                    @Override
                    protected void updateItem(Boolean item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null :
                            item.booleanValue() ? "Sim" : "Não");
                    }
                }
        );
        
        
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        
        List <Cliente> clientes = ClienteDAO.getCliente(filtro);
        tabela.setItems(FXCollections.observableArrayList(clientes));
    }
    
    @FXML
    private void evtFiltrar(ActionEvent event) {
        String filtro=" upper(nome) like '%#%'";
        filtro=filtro.replace("#", txFiltro.getText().toUpperCase());
        carregarTabela(filtro);
    }

    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaClientesCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Cliente");
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
        cliente = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaClientesCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Cliente");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        cliente = null;
        carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new ClienteDAO().apagar(id);
            carregarTabela("");
        }
    }
    
}
