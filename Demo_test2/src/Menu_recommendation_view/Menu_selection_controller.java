package Menu_recommendation_view;



import controllor.Kiosk_Handler;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;


public class Menu_selection_controller {
	
	private Kiosk_Handler mainApp;
	
	@FXML
	private GridPane gpane;

	//private Stage Menu_selection_stage;
	//private boolean okClicked = false;
	
	
	@FXML
    private void initialize() {
    }
	

	
	
	// next question ��ư�� ����Ű�� ������ �Լ�
	@FXML
	private void handle_next_question() {
		mainApp.show_question();
    }
	
	/**
     * ������ �ٽ� �����ϱ� ���� ���� ���ø����̼��� ȣ���Ѵ�.
     *
     * @param mainApp
     */
    public void setMainApp(Kiosk_Handler mainApp) {
        this.mainApp = mainApp;
    }
}
