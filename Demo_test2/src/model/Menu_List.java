package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;






public class Menu_List {
	
	public ObservableList<Food> getMenuTable() {
		return menuTable;
	}

	ObservableList<Food> menuTable = FXCollections.observableArrayList();			//private Set<Food> food; 원래 이거였음
	int menuTable_max_count = 0;
	
	public Menu_List() {

		int i=0;
		File file = new File("./txt/food_list_txt_file.txt");
		FileReader filereader = null;
		
		String [] line;
		String [] tags;
		
		try {
			filereader = new FileReader(file);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//입력 버퍼 생성
		BufferedReader bufReader = new BufferedReader(filereader);
		String temp = "";
		try {
			if((temp = bufReader.readLine()) != null) {// remove first line
			}
			while((temp = bufReader.readLine()) != null){
				line = temp.split("\t+");
				
				//food is generated
				this.menuTable.add(menuTable_max_count,new Food(Integer.parseInt(line[0]),
						line[1],Integer.parseInt(line[2]),line[3]));
				
				//split tags by ,
				tags = line[4].split(",");
				
				//tags are added
				for(i=0;i<tags.length;i++) {
					this.menuTable.get(menuTable_max_count).addTag(Integer.parseInt(tags[i]));
				}
				
				menuTable_max_count = menuTable_max_count +1;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public Food get_Food(IntegerProperty FoodID) {
		
		for(int k=0; k<this.tableSize(); k++) {
			if(this.menuTable.get(k).getFoodID().getValue() == FoodID.getValue()) {
				return this.menuTable.get(k);
			}
		}
		return null;
	}
	
	public IntegerProperty get_FoodID(int index) {
		
		return this.menuTable.get(index).getFoodID();
	}
	
	public StringProperty get_Menu(int num){
		return menuTable.get(num).getFoodName();
	}
	public String getTag(int num) {
		String taglist ="";
		int size = menuTable.get(num).getTagLength();
		
		for(int k=0; k<size ;k++)
			if(menuTable.get(num).getTagval(k)<10)
				taglist = taglist + "0" + menuTable.get(num).getTagval(k);
			else
				taglist = taglist + menuTable.get(num).getTagval(k);
		return taglist;
	}
	
	public int tableSize() {
		//int k;
		//System.out.print(menuTable.size()+"skdjlskjdkljsld\n");
		//for(k=0; menuTable.get(k) != null;k++) {}
		//System.out.print(k+"skdjlskjdkljsld\n");
		return menuTable.size();
	}
	
	//public void get_filtered_list() 삭제됨
}