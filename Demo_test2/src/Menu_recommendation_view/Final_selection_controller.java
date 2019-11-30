package Menu_recommendation_view;

import controllor.Kiosk_Handler;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class Final_selection_controller {

	private Kiosk_Handler mainApp;
	
	@FXML
	private HBox hbox;

    /**
     * ������.
     * initialize() �޼��� ������ ȣ��ȴ�.
     */
    public Final_selection_controller() {
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
    private void handle_one() {
		mainApp.show_show_menu();
    }
	
	// ��ư �� ������ �Լ� �̰� No��ư�� ������ �Լ�
	@FXML
    private void handle_two() {
		mainApp.show_show_menu();
    }
	
	// ��ư �� ������ �Լ� �̰� No��ư�� ������ �Լ�
	@FXML
	private void handle_three() {
		mainApp.show_show_menu();
	}
	
	@FXML
	private void handle_exit() {
		mainApp.show_show_menu();
	}
}
