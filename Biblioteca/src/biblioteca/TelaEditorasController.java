
package biblioteca;

import biblioteca.dao.EditoraDAO;
import biblioteca.entity.Editora;
import java.io.IOException;
import java.net.URL;
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

public class TelaEditorasController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Editora> tabela;
    @FXML
    private TableColumn<Editora, Integer> colId;
    @FXML
    private TableColumn<Editora, String> colNome;
    
    static public Editora editora = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        
        List <Editora> editoras = EditoraDAO.getEditora(filtro);
        tabela.setItems(FXCollections.observableArrayList(editoras));
    }
    
    @FXML
    private void evtFiltrar(ActionEvent event) {
        String filtro=" upper(nome) like '%#%'";
        filtro=filtro.replace("#", txFiltro.getText().toUpperCase());
        carregarTabela(filtro);
    }

    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaEditorasCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Editora");
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
        editora = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaEditorasCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Editora");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        editora = null;
        carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new EditoraDAO().apagar(id);
            carregarTabela("");
        }
    }
    
}
