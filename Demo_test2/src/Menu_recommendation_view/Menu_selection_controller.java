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
	

	
	
	// next question 버튼이 눌리키면 실행할 함수
	@FXML
	private void handle_next_question() {
		mainApp.show_question();
    }
	
	/**
     * 참조를 다시 유지하기 위해 메인 애플리케이션이 호출한다.
     *
     * @param mainApp
     */
    public void setMainApp(Kiosk_Handler mainApp) {
        this.mainApp = mainApp;
    }
}
