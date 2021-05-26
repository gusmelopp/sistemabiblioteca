
package biblioteca;

import biblioteca.dao.ExemplarDAO;
import biblioteca.dao.LivroDAO;
import biblioteca.dao.Singleton;
import biblioteca.entity.Exemplar;
import biblioteca.entity.Livro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaExemplaresCadastroController implements Initializable {

    @FXML
    private TextField txId;
    @FXML
    private TextField txQuantidade;
    @FXML
    private TextField txLocal;
    @FXML
    private TextField txValor;
    @FXML
    private ComboBox<Livro> cbLivro;
    @FXML
    private TextField txStatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbLivro.setItems(FXCollections.observableArrayList(new LivroDAO().getLivro("")));
        if(TelaExemplaresController.exemplar != null)
        {
            Exemplar e = TelaExemplaresController.exemplar;
            txId.setText("" + e.getCodigo());
            txQuantidade.setText(""+e.getQtde());
            txLocal.setText(e.getLocal());
            txValor.setText(""+e.getValor());
            txStatus.setText(""+e.getStatus());
            cbLivro.getSelectionModel().select(e.getLivro());
        }
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) {
        Exemplar exemplar = new Exemplar(Integer.parseInt(txQuantidade.getText()), Double.parseDouble(txValor.getText()), txLocal.getText(), true, cbLivro.getSelectionModel().getSelectedItem());
        if(txId.getText().isEmpty())
        {
            if(!new ExemplarDAO().inserir(exemplar))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao gravar: " + Singleton.getCon().getMensagemErro());
                alert.showAndWait();
            }
        }
        else
        {
            if(exemplar.getQtde() < 1)
                exemplar.setStatus(false);
            else
                exemplar.setStatus(true);
            exemplar.setCodigo(Integer.parseInt(txId.getText()));
            if(!new ExemplarDAO().alterar(exemplar))
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
