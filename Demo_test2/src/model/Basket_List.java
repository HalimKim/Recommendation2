package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class Basket_List {
	
	private ArrayList<Food> picked_list = new ArrayList<Food>();
	//private ObservableSet<Food> item_set = FXCollections.observableSet();
	//private ObservableList<Integer> item_count = FXCollections.observableArrayList();
	
	private QRcode qrcode;

	/*public void make_item_set() // 중복 없애기 위한 용도 
	{
		for(int i = 0; i < this.get_List_size(); i++) 
		{
			item_set.add(this.get_Food(i));
		}
	}*/
	/*public void count_Item() // 중복 없애기 위한 용도
	{
		for(int i = 0; i < item_set.size(); i++)
		{
			item_count.add(this.get_Food_count(item_set.iterator().next().getFoodID().getValue()));
		}	
	}*/
	
	/*public void show_Item_Set_with_Count() 
	{
		for(int i = 0; i < item_set.size(); i++) 
		{
			System.out.println("Food : " +item_set.toArray()[i]+"Count : " + item_count.toArray()[i]);
		}
	}*/
	
	public void add_food_to_basket_list(Food item) {
		picked_list.add(item);
	}
	public void add_food_to_basket_list(ArrayList<Food> item) {
		picked_list.addAll(item);
	}
	public Food get_Food(int i) 
	{
		return picked_list.get(i);
	}
	public int get_List_size() 
	{
		return picked_list.size();
	}
	public int get_Food_count(int FoodID) 
	{
		int count=0;
		for(int i = 0; i < this.get_List_size(); i++) 
		{
			if(this.get_Food(i).getFoodID().getValue() == FoodID) 
			{
				count++;
			}
		}
		return count;
	}
}