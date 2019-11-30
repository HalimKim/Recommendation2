package Menu_recommendation_view;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import controllor.Kiosk_Handler;

public class Show_menu_controller {
	/* ����� ������ ����
    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label firstNameLabel;
	*/
	
	@FXML
    private FlowPane fpane ;
	
    // ���� ���ø����̼� ����
    private Kiosk_Handler mainApp;

    /**
     * ������.
     * initialize() �޼��� ������ ȣ��ȴ�.
     */
    public Show_menu_controller() {
    }

    /**
     * ��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.
     * fxml ������ �ε�ǰ� ���� �ڵ����� ȣ��ȴ�.
     */
    @FXML
    private void initialize() {
        // ����ó ���̺��� �� ���� �ʱ�ȭ�Ѵ�.
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * ������ �ٽ� �����ϱ� ���� ���� ���ø����̼��� ȣ���Ѵ�.
     *
     * @param mainApp
     */
    public void setMainApp(Kiosk_Handler mainApp) {
        this.mainApp = mainApp;
    }
   
    @FXML
    private void handleMenuRecommendation() {
    	mainApp.show_menu_selection();
    }
   
    
    /*
    /**
     //* ����ڰ� Menu recommendation ��ư�� Ŭ���� �� ȣ��ȴ�.
     //* �����ϱ����� ��ü �޴� ����� �����ְ� ������ �� �ְ����ִ� ȭ���� ����Ѵ�.(Menu_selection.fxml)
     
    @FXML
    private void handle_menu_recommendation() {
        
    	boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
    	
    	Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // �ƹ��͵� �������� �ʾҴ�.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    */
}
