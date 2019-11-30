package model;
/**
 * 
 */

import javafx.beans.property.SimpleIntegerProperty;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author MJL
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Menu_Selection {
	
	private Menu_List menu_List;
	
	public Menu_List getMenu_List() {
		return menu_List;
	}
	
	public Menu_Selection() {
		this.menu_List = new Menu_List();
	}
	
	public Food select_Food(int FoodID) 
	{
		Food food = this.menu_List.get_Food(new SimpleIntegerProperty(FoodID));
		System.out.print(food.getFoodID().getValue());
		return food;
	}
}