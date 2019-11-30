package model;

//import java.util.ArrayList;
//import java.util.Set;
import java.util.LinkedList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Tag {
	private Integer tag;
	
	Tag(Integer num){
		this.tag = num; 
	}
	Integer getTag() {
		return tag;
	}
}

public class Food{
	public void setFoodID(Integer foodID) {
		FoodID.set(foodID);
	}

	public void setFoodName(String foodName) {
		FoodName.set(foodName);
	}

	public void setPrice(Integer price) {
		this.price.set(price);
	}

	public void setFoodType(String foodType) {
		this.FoodType.set(foodType);
	}

	private IntegerProperty FoodID;
	private StringProperty FoodName;
	private IntegerProperty price;
	private StringProperty FoodType;
	private LinkedList<Tag> tag = new LinkedList();
	
	Food(int ID, String name) {
		this.FoodID.set(ID);	
		this.FoodName.set(name);
	}
	
	Food(int FoodID, String Foodname, int price, String FoodType) {
		this.FoodID = new SimpleIntegerProperty(FoodID);	
		this.FoodName = new SimpleStringProperty(Foodname);
		this.price = new SimpleIntegerProperty(price);
		this.FoodType = new SimpleStringProperty(FoodType);
	}
 
	public IntegerProperty getFoodID() {
		return this.FoodID;
	}
	public IntegerProperty getPrice() 
	{
		return this.price;
	}
	
	public StringProperty getFoodName() {
		return this.FoodName;
	}

	public void addTag(Integer num) {
		Tag tag1 = new Tag(num);
		this.tag.add(tag1);
	}
	
	public int getTagLength() {
		return this.tag.size();
	}
	
	public Integer getTagval(Integer num) {
		return this.tag.get(num).getTag();
	}
	
}