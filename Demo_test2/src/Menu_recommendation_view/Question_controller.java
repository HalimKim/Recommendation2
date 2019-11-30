package Menu_recommendation_view;

import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;
import controllor.Kiosk_Handler;

public class Question_controller {

	
	private Kiosk_Handler mainApp;
	
	@FXML
	private TextFlow tflow;

    /**
     * 생성자.
     * initialize() 메서드 이전에 호출된다.
     */
    public Question_controller() {
    }
    
    
    /**
     * 컨트롤러 클래스를 초기화한다.
     * fxml 파일이 로드되고 나서 자동으로 호출된다.
     */
    @FXML
    private void initialize() {
    }
    
    
    /**
     * 참조를 다시 유지하기 위해 메인 애플리케이션이 호출한다.
     *
     * @param mainApp
     */
    public void setMainApp(Kiosk_Handler mainApp) {
        this.mainApp = mainApp;
    }
    
    
	// 버튼 별 실행할 함수 이건 Yes버튼에 실행할 함수
	@FXML
    private void handle_Yes() {
		mainApp.show_menu_selection();
    }
	
	// 버튼 별 실행할 함수 이건 No버튼에 실행할 함수
	@FXML
    private void handle_No() {
		mainApp.show_final_selection();
    }
	
   
}
