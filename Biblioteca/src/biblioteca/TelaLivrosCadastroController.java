
package biblioteca;

import biblioteca.entity.Autor;
import biblioteca.entity.Editora;
import biblioteca.dao.LivroDAO;
import biblioteca.dao.AutorDAO;
import biblioteca.dao.EditoraDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Livro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaLivrosCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private ComboBox<Autor> cbAutor;
    @FXML
    private ComboBox<Editora> cbEditora;
    @FXML
    private TextField txTitulo;
    @FXML
    private TextField txGenero;
    @FXML
    private TextField txAno;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbAutor.setItems(FXCollections.observableArrayList(new AutorDAO().getAutor("")));
        cbEditora.setItems(FXCollections.observableArrayList(new EditoraDAO().getEditora("")));
        
        if(TelaLivrosController.livro != null)
        {
            Livro l = TelaLivrosController.livro;
            txId.setText("" + l.getCodigo());
            txTitulo.setText(l.getTitulo());
            txGenero.setText(l.getGenero());
            txAno.setText(l.getAno());
            cbAutor.getSelectionModel().select(l.getAutor());
            cbEditora.getSelectionModel().select(l.getEditora());
        }
        Platform.runLater(()->{txTitulo.requestFocus();});
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Livro livro = new Livro(txTitulo.getText(), txGenero.getText(), txAno.getText(), cbAutor.getSelectionModel().getSelectedItem(), cbEditora.getSelectionModel().getSelectedItem());
        if(txId.getText().isEmpty())
        {
            if(!new LivroDAO().inserir(livro))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            livro.setCodigo(Integer.parseInt(txId.getText()));
            if(!new LivroDAO().alterar(livro))
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
