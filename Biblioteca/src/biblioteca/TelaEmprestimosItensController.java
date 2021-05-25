
package biblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaEmprestimosItensController implements Initializable {

    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> colTitulo;
    @FXML
    private TableColumn<?, ?> colDtLimite;
    @FXML
    private TableColumn<?, ?> colDtDevolucao;
    @FXML
    private TableColumn<?, ?> colValor;
    @FXML
    private TableColumn<?, ?> colSituacao;

    private void carregarTabela(String filtro) {
        /*AutorDAO dao = new AutorDAO();
        List <Autor> autores = dao.get(filtro);
        tabela.setItems(FXCollections.observableArrayList(autores));*/
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //carregarTabela();
    }
    
    
    
}
