package Menu_recommendation_view;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import controllor.Kiosk_Handler;

public class Show_menu_controller {
	/* 사용할 데이터 선언
    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label firstNameLabel;
	*/
	
	@FXML
    private FlowPane fpane ;
	
    // 메인 애플리케이션 참조
    private Kiosk_Handler mainApp;

    /**
     * 생성자.
     * initialize() 메서드 이전에 호출된다.
     */
    public Show_menu_controller() {
    }

    /**
     * 컨트롤러 클래스를 초기화한다.
     * fxml 파일이 로드되고 나서 자동으로 호출된다.
     */
    @FXML
    private void initialize() {
        // 연락처 테이블의 두 열을 초기화한다.
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * 참조를 다시 유지하기 위해 메인 애플리케이션이 호출한다.
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
     //* 사용자가 Menu recommendation 버튼을 클릭할 때 호출된다.
     //* 질문하기전에 전체 메뉴 목록을 보여주고 선택할 수 있게해주는 화면을 출력한다.(Menu_selection.fxml)
     
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
            // 아무것도 선택하지 않았다.
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
