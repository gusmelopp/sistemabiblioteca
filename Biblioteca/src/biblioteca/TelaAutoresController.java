
package biblioteca;

import biblioteca.dao.AutorDAO;
import biblioteca.entity.Autor;
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

public class TelaAutoresController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Autor> tabela;
    @FXML
    private TableColumn<Autor, Integer> colId;
    @FXML
    private TableColumn<Autor, String> colNome;
    
    static public Autor autor = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        List <Autor> autores = AutorDAO.getAutor(filtro);
        tabela.setItems(FXCollections.observableArrayList(autores));
    }

    @FXML
    private void evtFiltrar(ActionEvent event) {
        String filtro=" upper(nome) like '%#%'";
        filtro=filtro.replace("#", txFiltro.getText().toUpperCase());
        carregarTabela(filtro);
    }

    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaAutoresCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Autor");
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
        autor = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaAutoresCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Autor");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        autor = null;
        carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new AutorDAO().apagar(id);
            carregarTabela("");
        }
    }
    
}
