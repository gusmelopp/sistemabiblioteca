
package biblioteca;

import biblioteca.dao.LivroDAO;
import biblioteca.entity.Autor;
import biblioteca.entity.Editora;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaLivrosController implements Initializable {

    @FXML
    private TextField txFiltro;
    @FXML
    private TableView<Livro> tabela;
    
    @FXML
    private TableColumn<Livro, Integer> colId;
    
    @FXML
    private TableColumn<Livro, String> colTitulo;
    
    @FXML
    private TableColumn<Livro, String> colGenero;
    @FXML
    private TableColumn<Livro, String> colAno;
    @FXML
    private TableColumn<Livro, Autor> colAutor;
    @FXML
    private TableColumn<Livro, Editora> colEditora;
    
    static public Livro livro = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        carregarTabela("");
    }
    
    private void carregarTabela(String filtro) {
        
        List <Livro> livros = LivroDAO.getLivro(filtro);
        tabela.setItems(FXCollections.observableArrayList(livros));
    }


    @FXML
    private void evtNovo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaLivrosCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Livro");
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
        livro = tabela.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("TelaLivrosCadastro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Livro");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        livro = null;
        carregarTabela("");
    }

    @FXML
    private void evtFiltrar(ActionEvent event) {
        String filtro=" upper(titulo) like '%#%'";
        filtro=filtro.replace("#", txFiltro.getText().toUpperCase());
        carregarTabela(filtro);
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        int id = tabela.getSelectionModel().getSelectedItem().getCodigo();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja excluir o produto?");
        if(alert.showAndWait().get() == ButtonType.OK)
        {
            new LivroDAO().apagar(id);
            carregarTabela("");
        }
    }

    
}
