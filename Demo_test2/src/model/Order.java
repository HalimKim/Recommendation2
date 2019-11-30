package model;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Order {

	private Basket_List basket_list;
	
	public Order()
	{
		this.basket_list = new Basket_List();
	}
	public void show_Basket_List()
	{
		for(int i = 0; i < basket_list.get_List_size(); i++) 
		{
			System.out.print(i+" ");
			System.out.println(basket_list.get_Food(i).getFoodName().getValue());
		}
	}
	public IntegerProperty get_Total_price()
	{
		IntegerProperty total = new SimpleIntegerProperty(0);;
		int size = this.basket_list.get_List_size();
		NumberBinding sum;
		for(int i = 0; i < size; i++) 
		{
			sum = Bindings.add(total,basket_list.get_Food(i).getPrice());
			total.setValue(sum.getValue());
		}
		
		return total;
	}
	public void add_Food(Food item) 
	{
		this.basket_list.add_food_to_basket_list(item);
	}
	public void add_Food(ArrayList<Food> item) 
	{
		this.basket_list.add_food_to_basket_list(item);
	}
	public void choose_order_type() {
		
	}

	public void QRcode_To_Basket() {
		
	}

	public void Make_QRcode() {
	
	}
	public Order getOrder() 
	{
		return this;
	}
	public Basket_List getBasket_List() 
	{
			return this.basket_list;
	}
}