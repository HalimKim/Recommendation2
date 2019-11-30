package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.beans.property.SimpleIntegerProperty;


public class Menu_Recommendation {
	private List<String> tag = new ArrayList<String>();
	private int tagFreq[] = new int[50];//�±� 50��
	private int menuID[][] = new int[50][2];//�޴� 50��
	private int tagNum;//�±� ����
	private Question[] question_list = questionList();
	private Menu_List table;
	
	public Menu_Recommendation(Menu_List menuTable){
		table = menuTable;
		System.out.println("Menu_Recommendation initiated");
	}
	
	public  ArrayList<Integer> get_menu_recommending(){
		int fitTag;
		int filtered=4;
		int answer;
		
		ArrayList<Integer> final_list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println(this.question_list.length);			//���� ����
		
		make_filtered_list();
		
		initTagTable();//��ũ ���̺� ä���
		/*
		Arrays.fill(menuID, 1);
		
		System.out.println(question_list.length);			//���� ����		

		
		initTagTable(table);//��ũ ���̺� ä���
		*/
		while(filtered>3){//3������������ ��� �ݺ�
			
			fitTag = CalcFreqeuncyofTag(table);
			System.out.println(question_list[fitTag].getQuestionSTR());//���� �̷�������
			System.out.println("YES=1 NO=0 // SHOW MENU=2");
			
			answer = scan.nextInt();			
			if (answer==2) show_menu_list();
			else if(answer==1 || answer==0) {
				filter_menu(this.table.tableSize(), fitTag, answer);

				
				filtered=0;
				for(int k=0; k<this.table.tableSize(); k++) {
					if(this.menuID[k][0] == 1) filtered++;
				}
		//			System.out.println(menuID[k][0]);
			}
			/*
			Scanner scan = new Scanner(System.in);
			int answer = scan.nextInt();			
			
			filter_menu(table.tableSize(), fitTag, answer);

			
			filtered=0;
			for(int k=0; k<table.tableSize(); k++) {
				if(menuID[k] == 1) filtered++;
		//			System.out.println(menuID[k]);
			}
			//System.out.println(filtered);			//�� �޴� ����
			 */
		}
		
		int num=1;
		for(int k=0; k< this.table.tableSize(); k++) {
			if(this.menuID[k][0] == 1) {
				System.out.println(num+ "." + this.table.get_Menu(k).getValue());
				System.out.println(this.menuID[k][1]);
				final_list.add(this.menuID[k][1]);
				num++;
				}
		}
		
		/*
		System.out.println("------your choice--------");
		for(int k=0; k<table.tableSize(); k++) {
			if(menuID[k] == 1) System.out.println(table.get_Menu(k));
		}
		*/
		
		/*while (true) {
			System.out.println("Choose your menu :");
			answer = scan.nextInt();
			
			if(answer>num || answer<1)	System.out.println("ERROR) Type right number");
			else break;
		}
		System.out.println(answer + "**********" + final_list.get(answer-1));
		return table.get_Food(new SimpleIntegerProperty(final_list.get(answer-1)));*/
		return final_list;
		
	}
	
	
	
	
	private void initTagTable() {
		int menuSize =  table.tableSize();
		for(int k=0; k<menuSize; k++)
			this.tag.add(table.getTag(k));
	}
	
	
	private void filter_menu(int menuSize, int fitTag, int answer) {
		int tagTemp;
		for(int k=0; k<menuSize; k++) {
			for(int j=0; j< tag.get(k).length()/2; j++) {
				tagTemp = Integer.parseInt(tag.get(k).substring(j*2, j*2+2));
				if(fitTag == tagTemp) {
					if(menuID[k][0] != -1)
						menuID[k][0] = 2;//�켱 �ش��±� ���� ������ ���� ����
				}
					
			}
			
		}
		if(answer == 1)
			for(int k=0; k<menuSize; k++)
				if (menuID[k][0] == 2) menuID[k][0] = 1;
				else menuID[k][0] = -1;
		else
			for(int k=0; k<menuSize; k++)
				if (menuID[k][0] == 2) menuID[k][0] = -1;
				else if (menuID[k][0] != 1) menuID[k][0] = -1;

	}
	
	
	
	
	public void getQuestion(int fitTag) {
		//Ŭ���� ���̾�׷��� �ִ°�. �ٵ� ���� ����� ���ʿ�
	}
	
	
	private int CalcFreqeuncyofTag(Menu_List table) {
		
		int menuSize =  table.tableSize();
		int curTag;
		int fitTag = 0;
		
		
		for(int k=0; k<50; k++)//�±׼� 50������ ����
			tagFreq[k]=0;

		for(int k=0; k<menuSize; k++) {

			if(menuID[k][0]==-1) {}//���ܵ� �޴��� ��ŵ
			else//���ܵ��� ���� �޴�
				for(int j=0; j< tag.get(k).length()/2; j++) {
					//System.out.println(k + "��° -ũ��"+tag.get(k).length()/2);	//�±� ����
					curTag = Integer.parseInt(tag.get(k).substring(j*2, j*2+2));
					tagFreq[curTag]++;											//���� �±׿� 1 �����ش�
					//System.out.println( (j*2) +"~" + (j*2+1));				//���� �±�
				}
		}
		for(int k=0; k<tagNum; k++) {
			if(Math.abs(tagFreq[fitTag]-menuSize/2) >Math.abs(tagFreq[k]-menuSize/2))
				fitTag = k;
			//System.out.println(k + "��° �±� ="+tagFreq[k]);						//�±� ������Դ°� test
		}
		//System.out.println(fitTag);											//���� �˸��� �±װ� �����ΰ�
		return fitTag;
	}
	
	
	public Question[] questionList(){		
		int n=0;
		Question [] list = new Question[50];
	 
		File file = new File("./txt/question.txt");
		//�Է� ��Ʈ�� ����
		FileReader filereader = null;
		try {
			filereader = new FileReader(file);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//�Է� ���� ����
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		try {
			while((line = bufReader.readLine()) != null){
				list[n] = new Question(n, line);
				//System.out.println(line);			//���� ����� �о����� �׽�Ʈ
				n++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tagNum=n; //�������� = �±װ����̹Ƿ� ���⼭ üũ
		
		System.out.println("read all questions!!");
		return list;
	}

	

	public void make_filtered_list() {
		for(int k=0; k< this.table.tableSize(); k++) {
			this.menuID[k][0] = 1;
			this.menuID[k][1] = this.table.get_FoodID(k).getValue();
		}
	}


	public void show_menu_list() {
		int num=1;
		for(int k=0; k< this.table.tableSize(); k++) {
			if(this.menuID[k][0] == 1) {
				System.out.println(num+ "." + this.table.get_Menu(k));
				num++;
				}
		}
	}

	
	public Question get_Question(int index) {
		return question_list[index];
	}


	public void show_Question() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void get_answer() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


}