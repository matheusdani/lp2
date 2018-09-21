package br.com.unialfa.aula.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unalfa.aula.exeption.DadosInvalidosExeption;
import br.com.unialfa.aula.enumerator.SexoEnum;
import br.com.unialfa.aula.enumerator.TipoAbordagemEnum;
import br.com.unialfa.aula.model.entity.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PacienteController implements Initializable {

	@FXML
	private TableView<Paciente> tblPanicente;

	@FXML
	private TableColumn<Paciente, Number> clnId;

	@FXML
	private TableColumn<Paciente, String> clnNome;

	@FXML
	private TableColumn<TipoAbordagemEnum, String> clTipoAbordagem;

	@FXML
	private TableColumn<Paciente, String> clnEmail;

	@FXML
	private JFXTextField txtId;

	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnNovo;

	@FXML
	private GridPane grdConteudo;

	@FXML
	private ToggleGroup tgrSexo;

	@FXML
	private JFXComboBox<TipoAbordagemEnum> cbAbordagem;

	private ObservableList<Paciente> pacientes = FXCollections.observableArrayList();

	private Paciente pacienteSelecionado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pacientes.add(new Paciente(1L, "João", "joao@gmail.com", TipoAbordagemEnum.ANALISE_DO_COMPORTAMENTO));

		carregarTipoAbordagem();
		clnId.setCellValueFactory(c -> c.getValue().idProperty());
		clnNome.setCellValueFactory(c -> c.getValue().nomeProperty());
		clnEmail.setCellValueFactory(c -> c.getValue().emailProperty());
		this.tblPanicente.setItems(pacientes);
	}

	private void carregarTipoAbordagem() {
		cbAbordagem.getItems().add(null);
		cbAbordagem.getItems().addAll(TipoAbordagemEnum.values());
	}

	@FXML
	void excluir(ActionEvent event) {
		selecao();
		if (pacienteSelecionado != null) {
			pacientes.remove(pacienteSelecionado);
			clear(grdConteudo);
		}
	}

	@FXML
	private void selecao() {
		pacienteSelecionado = this.tblPanicente.getSelectionModel().getSelectedItem();
		this.txtId.setText(String.valueOf(pacienteSelecionado.getId()));
		this.txtNome.setText(pacienteSelecionado.getNome());
		this.txtEmail.setText(pacienteSelecionado.getEmail());
		this.cbAbordagem.getSelectionModel().select(pacienteSelecionado.getTipoAbordagem());
	}

	@FXML
	void novo(ActionEvent event) {

	}

	@FXML
	void salvar(ActionEvent event) throws DadosInvalidosExeption {
	
		testeException();
		Paciente p = new Paciente(Long.valueOf(txtId.getText()), txtNome.getText(), txtEmail.getText(),
				cbAbordagem.getSelectionModel().getSelectedItem());

		RadioButton selectedRadionButton = returnSelectedRadioButton();
		if (selectedRadionButton.getText().equals("M")) {
			p.setSexo(SexoEnum.MASCULINO);
		} else if (selectedRadionButton.getText().equals("F")) {
			p.setSexo(SexoEnum.FEMININO);
		} else {
			System.out.println("Deu bug... deveria ter selecionado algo");
		}
		pacientes.add(p);
		clear(grdConteudo);
	}

	private RadioButton returnSelectedRadioButton() {
		if (tgrSexo != null) {
			RadioButton r = (RadioButton) this.tgrSexo.getSelectedToggle();
			return r;
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	private void clear(Pane pane) {
		ObservableList<Node> nodes = pane.getChildren();
		for (Node node : nodes) {
			if (node instanceof TextField) {
				((TextField) node).setText("");
			}
			if (node instanceof ComboBox) {
				((ComboBox) node).getSelectionModel().select(0);
			}
		}

	}

	private void testeException() throws DadosInvalidosExeption {
		if (txtId.getText().equals("") || txtId.getText() == null || txtId.getText().isEmpty()) {
			throw new DadosInvalidosExeption("O campo não pode ser vazio ou nulo");
		}
	}
}
