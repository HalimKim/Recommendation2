package Menu_recommendation_view;

import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;
import controllor.Kiosk_Handler;

public class Question_controller {

	
	private Kiosk_Handler mainApp;
	
	@FXML
	private TextFlow tflow;

    /**
     * ������.
     * initialize() �޼��� ������ ȣ��ȴ�.
     */
    public Question_controller() {
    }
    
    
    /**
     * ��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.
     * fxml ������ �ε�ǰ� ���� �ڵ����� ȣ��ȴ�.
     */
    @FXML
    private void initialize() {
    }
    
    
    /**
     * ������ �ٽ� �����ϱ� ���� ���� ���ø����̼��� ȣ���Ѵ�.
     *
     * @param mainApp
     */
    public void setMainApp(Kiosk_Handler mainApp) {
        this.mainApp = mainApp;
    }
    
    
	// ��ư �� ������ �Լ� �̰� Yes��ư�� ������ �Լ�
	@FXML
    private void handle_Yes() {
		mainApp.show_menu_selection();
    }
	
	// ��ư �� ������ �Լ� �̰� No��ư�� ������ �Լ�
	@FXML
    private void handle_No() {
		mainApp.show_final_selection();
    }
	
   
}
