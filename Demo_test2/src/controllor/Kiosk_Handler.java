package controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Menu_recommendation_view.Final_selection_controller;
import Menu_recommendation_view.Menu_selection_controller;
import Menu_recommendation_view.Question_controller;
import Menu_recommendation_view.Show_menu_controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import model.QRcodeManager;
import model.Menu_Recommendation;
import model.Menu_Selection;
import model.Order;


public class Kiosk_Handler extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    private QRcodeManager QRcodeManager;
    private Menu_Recommendation Menu_Recommendation;
    private Menu_Selection Menu_Selection;
    
    private Order new_order;
    
    // variable example
    /*
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    */
    
    // Person ��ü�� ������ �� MainApp���� �� ��ü�� Ŭ�󽺸��� �־ ����ϱ�
    //private ObservableList<Person> personData = FXCollections.observableArrayList();
    
    public Kiosk_Handler() {
    	this.Menu_Selection = new Menu_Selection();
	    this.QRcodeManager = new QRcodeManager(this.Menu_Selection.getMenu_List());
    	this.Menu_Recommendation = new Menu_Recommendation(this.Menu_Selection.getMenu_List());
    }
	
	@Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Unmanned Kiosk");

        initRootLayout();
        show_show_menu();
    }
	
	
     //* ���� ���̾ƿ��� �ʱ�ȭ�Ѵ�.
     
    public void initRootLayout() {
        try {
            // fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Kiosk_Handler.class.getResource("/Menu_recommendation_view/Root_layout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���� ���̾ƿ� �ȿ� Show_menu.fxml �����ش�.
     */
    public void show_show_menu() {
    	
    	List<Button> buttonlist = new ArrayList<>();
    	List<Button> buttonlist1 = new ArrayList<>();
    	
    	
    	
    	try {
            // ����ó ����� �����´�.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Kiosk_Handler.class.getResource("/Menu_recommendation_view/Show_menu.fxml"));
            AnchorPane show_menu = (AnchorPane) loader.load();
            
            Map<String, Object> fxmlNamespace = loader.getNamespace();
            FlowPane fpane = (FlowPane) fxmlNamespace.get("fpane");
            
            for(int i=0;i<7;i++) {
            	if(i==0) {
            		Button bt = new Button("Menu Recommendation");
            		bt.setPrefHeight(150);
            		bt.setPrefWidth(150);
            		buttonlist.add(bt);
            		bt.setOnAction((ActionEvent) -> { 
            			// ���⿡ ó�� �ۼ�
            			this.show_menu_selection();
            		});
            	}
            	else {
            		Button bt = new Button(this.Menu_Selection.getMenu_List().getMenuTable().get(i-1).getFoodName().getValue());
            		bt.setPrefHeight(150);
            		bt.setPrefWidth(150);
            		buttonlist.add(bt);
            	}
            }
            fpane.getChildren().clear();
            fpane.getChildren().addAll(buttonlist);
            
            FlowPane fpane1 = (FlowPane) fxmlNamespace.get("fpane1");
            
            for(int i=0;i<5;i++) {
            	if(i==0) {
            		Button bt = new Button("Menu Recommendation");
            		bt.setPrefHeight(150);
            		bt.setPrefWidth(150);
            		buttonlist1.add(bt);
            		bt.setOnAction((ActionEvent) -> { 
            			// ���⿡ ó�� �ۼ�
            			this.show_menu_selection();
            		});
            	}
            	else {
            		Button bt = new Button(Integer.toString(i));
            		bt.setPrefHeight(150);
            		bt.setPrefWidth(150);
            		buttonlist1.add(bt);
            	}
            }
            fpane1.getChildren().clear();
            fpane1.getChildren().addAll(buttonlist1);
            

            // ����ó ����� ���� ���̾ƿ� ����� �����Ѵ�.
          rootLayout.setCenter(show_menu);

            // ���� ���ø����̼��� ��Ʈ�ѷ��� �̿��� �� �ְ� �Ѵ�.
            Show_menu_controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void show_menu_selection() {
    	
    	List<Button> buttonlist1 = new ArrayList<>();
    	List<Button> buttonlist2 = new ArrayList<>();
    	List<Button> buttonlist3 = new ArrayList<>();
    	
    	int burger_count = 7;
    	int beverage_count = 10;
    	int side_count = 5;
    	
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Kiosk_Handler.class.getResource("/Menu_recommendation_view/Menu_selection.fxml"));
            AnchorPane menu_selection = (AnchorPane) loader.load();
            
            Map<String, Object> fxmlNamespace = loader.getNamespace();
            GridPane gpane = (GridPane) fxmlNamespace.get("gpane");
            gpane.setHgap(10);
            gpane.setVgap(10);
            
            
                        
            gpane.add(new Label("burger"),0,0,2,1);
            
            // ���ſ� �ش��ϴ� ��ư�� ���۾����� �߰��ϱ� 
            for(int i=0;i<burger_count;i++) {
            	//Button bt = new Button(Integer.toString(i));
            	Button bt = new Button(this.Menu_Selection.getMenu_List().getMenuTable().get(i).getFoodName().getValue());
            	bt.setPrefHeight(150);
            	bt.setPrefWidth(150);
            	gpane.add(bt,i%3,i/3+1,1,1);
            	//System.out.println(i/3);
            	//System.out.println(i%3);
            	bt.setOnAction((ActionEvent) -> { 
        			// ���⿡ ó�� �ۼ�
        			this.show_show_menu();
        		});
            }
          
            gpane.add(new Label("beverage"),(burger_count-1)%3,burger_count/3+2,2,1);
            

            for(int i=burger_count-1;i<burger_count-1+beverage_count;i++) {
            	Button bt = new Button(Integer.toString(i+1));
            	bt.setPrefHeight(150);
            	bt.setPrefWidth(150);
            	gpane.add(bt,i%3,i/3+3,1,1);
            	bt.setOnAction((ActionEvent) -> { 
        			// ���⿡ ó�� �ۼ�
        			this.show_show_menu();
        		});
            }

            
            
           
            // ����ó ����� ���� ���̾ƿ� ����� �����Ѵ�.
            rootLayout.setCenter(menu_selection);

            // ���� ���ø����̼��� ��Ʈ�ѷ��� �̿��� �� �ְ� �Ѵ�.
            Menu_selection_controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void show_question() {
    	try {
            // ����ó ����� �����´�.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Kiosk_Handler.class.getResource("/Menu_recommendation_view/Question.fxml"));
            AnchorPane show_question = (AnchorPane) loader.load();
            
            Map<String, Object> fxmlNamespace = loader.getNamespace();
            TextFlow tflow = (TextFlow) fxmlNamespace.get("tflow");
            
            //Text text1 = new Text("question\n\n\tIs it cold?");
            Text text1 = new Text(this.Menu_Recommendation.get_Question(0).getQuestionSTR());
            text1.setFont(new Font(15));
            text1.setFill(Color.DARKSLATEBLUE);
            
            if(tflow == null) {System.out.println("1\n1\n1\n1\n");}
            tflow.getChildren().add(text1);

            // ����ó ����� ���� ���̾ƿ� ����� �����Ѵ�.
            rootLayout.setCenter(show_question);

            // ���� ���ø����̼��� ��Ʈ�ѷ��� �̿��� �� �ְ� �Ѵ�.
            Question_controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void show_final_selection() {
    	
    	List<Button> buttonlist = new ArrayList<>();
    	
    	try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Kiosk_Handler.class.getResource("/Menu_recommendation_view/Final_selection.fxml"));
            AnchorPane final_selection = (AnchorPane) loader.load();
            
            Map<String, Object> fxmlNamespace = loader.getNamespace();
            HBox hbox = (HBox) fxmlNamespace.get("hbox");

            Button bt1 = new Button("menu1");
            bt1.setPrefHeight(150);
    		bt1.setPrefWidth(150);
    		buttonlist.add(bt1);
    		bt1.setOnAction((ActionEvent) -> { 
    			// ���⿡ ó�� �ۼ�
    			// ������ �޴� ������ show_menuȭ�� �ؿ� �߰��Ǿ�� �Ѵ�
    			this.show_show_menu();
    		});
    		
            Button bt2 = new Button("menu2");
            bt2.setPrefHeight(150);
    		bt2.setPrefWidth(150);
    		buttonlist.add(bt2);
    		bt2.setOnAction((ActionEvent) -> { 
    			// ���⿡ ó�� �ۼ�
    			this.show_show_menu();
    		});
    		
            Button bt3 = new Button("menu3");
            bt3.setPrefHeight(150);
    		bt3.setPrefWidth(150);
    		buttonlist.add(bt3);
    		bt3.setOnAction((ActionEvent) -> { 
    			// ���⿡ ó�� �ۼ�
    			this.show_show_menu();
    		});
    		
            hbox.getChildren().clear();
            hbox.getChildren().addAll(buttonlist);
            
            // ����ó ����� ���� ���̾ƿ� ����� �����Ѵ�.
            rootLayout.setCenter(final_selection);

            // ���� ���ø����̼��� ��Ʈ�ѷ��� �̿��� �� �ְ� �Ѵ�.
            Final_selection_controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	
	public static void main(String[] args) {
		// for testing UI
		launch(args);
		
		// for testing main.java (code)
		Kiosk_Handler kiosk = new Kiosk_Handler();
		int order_type = 0;
		Scanner input = new Scanner(System.in);
				
		Order New_Order = new Order();
				
		while(true) 
		{
			System.out.print("Choose order type : ");
			order_type = input.nextInt();
			if(order_type == 1) //Menu Selection 
			{
				System.out.println("Menu Selection mode");
				System.out.print("Enter Food ID : ");
				int foodID = input.nextInt();
				New_Order.add_Food(kiosk.Menu_Selection.select_Food(foodID));
			}
			else if(order_type == 2) //Menu Recommendation
			{
				System.out.println("Menu Recommendation mode");
				//New_Order.add_Food(kiosk.Menu_Recommendation.get_menu_recommending());
			}
			else if(order_type == 3)//Use QR code 
			{
				// test make qrcode
				kiosk.QRcodeManager.make_QRcode("https://crunchify.com/aaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaac");
				System.out.println("Using QR code mode");
				try {
					System.out.println(kiosk.QRcodeManager.read_QRcode());
				}
				catch(IOException e) {
					
				}
			}
			else if(order_type == 4) //Cancel 
			{
				System.out.println("All canceled");
				continue;
			}
			else if(order_type == 5) // Show current Basket_list 
			{
				System.out.println("Show Current Basket_list");
				New_Order.show_Basket_List();
			}
			
		}
	}

	
	/*
	//Menu_selection.fxml�� �����ִ� �Լ� 
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/Menu_selection.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // ���̾�α� ���������� �����.
	        Stage Menu_selection_stage = new Stage();
	        Menu_selection_stage.setTitle("Edit Person");
	        Menu_selection_stage.initModality(Modality.WINDOW_MODAL);
	        Menu_selection_stage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        Menu_selection_stage.setScene(scene);

	        // person�� ��Ʈ�ѷ��� �����Ѵ�.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	*/
}
