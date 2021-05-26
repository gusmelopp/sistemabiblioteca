
package biblioteca;

import biblioteca.dao.ExemplarDAO;
import biblioteca.entity.Exemplar;
import biblioteca.entity.Livro;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaExemplaresController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Exemplar> tabela;
    @FXML
    private TableColumn<Exemplar, Integer> colId;
    @FXML
    private TableColumn<Exemplar, Livro> colTituloLivro;
    @FXML
    private TableColumn<Exemplar, Integer> colQuantidade;
    @FXML
    private TableColumn<Exemplar, String> colLocal;
    @FXML
    private TableColumn<Exemplar, Double> colValor;
    @FXML
    private TableColumn<Exemplar, Boolean> colSatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTituloLivro.setCellValueFactory(new PropertyValueFactory<>("livro"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colSatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colSatus.setCellFactory(
                tc -> new TableCell<Exemplar, Boolean>() {
                    @Override
                    protected void updateItem(Boolean item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null :
                            item.booleanValue() ? "Disponível" : "Indisponível");
                    }
                }
        );
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        
        List <Exemplar> exemplar = ExemplarDAO.getExemplar(filtro);
        tabela.setItems(FXCollections.observableArrayList(exemplar));
    }
    
    @FXML
    private void evtFiltrar(ActionEvent event) {
    }

    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaExemplaresCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Exemplar");
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
        //exemplares = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaExemplaresCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Exemplar");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //exemplares = null;
        //carregarTabela("");
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        /*int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja realmente excluir?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new ExemplarDAO().apagar(id);
            carregarTabela("");
        }*/
    }
    
}
