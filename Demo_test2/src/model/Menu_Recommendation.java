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
	private int tagFreq[] = new int[50];//태그 50개
	private int menuID[][] = new int[50][2];//메뉴 50개
	private int tagNum;//태그 갯수
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
		
		System.out.println(this.question_list.length);			//질문 길이
		
		make_filtered_list();
		
		initTagTable();//태크 테이블 채운다
		/*
		Arrays.fill(menuID, 1);
		
		System.out.println(question_list.length);			//질문 길이		

		
		initTagTable(table);//태크 테이블 채운다
		*/
		while(filtered>3){//3개남을때까지 계속 반복
			
			fitTag = CalcFreqeuncyofTag(table);
			System.out.println(question_list[fitTag].getQuestionSTR());//질문 이런식으로
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
			//System.out.println(filtered);			//고른 메뉴 갯수
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
						menuID[k][0] = 2;//우선 해당태그 가진 음식을 전부 선택
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
		//클래스 다이어그램에 있는거. 근데 굳이 기능은 불필요
	}
	
	
	private int CalcFreqeuncyofTag(Menu_List table) {
		
		int menuSize =  table.tableSize();
		int curTag;
		int fitTag = 0;
		
		
		for(int k=0; k<50; k++)//태그수 50가지라 가정
			tagFreq[k]=0;

		for(int k=0; k<menuSize; k++) {

			if(menuID[k][0]==-1) {}//제외된 메뉴는 스킵
			else//제외되지 않은 메뉴
				for(int j=0; j< tag.get(k).length()/2; j++) {
					//System.out.println(k + "번째 -크기"+tag.get(k).length()/2);	//태그 갯수
					curTag = Integer.parseInt(tag.get(k).substring(j*2, j*2+2));
					tagFreq[curTag]++;											//나온 태그에 1 더해준다
					//System.out.println( (j*2) +"~" + (j*2+1));				//넣은 태그
				}
		}
		for(int k=0; k<tagNum; k++) {
			if(Math.abs(tagFreq[fitTag]-menuSize/2) >Math.abs(tagFreq[k]-menuSize/2))
				fitTag = k;
			//System.out.println(k + "번째 태그 ="+tagFreq[k]);						//태그 몇번나왔는가 test
		}
		//System.out.println(fitTag);											//지금 알맞은 태그가 무엇인가
		return fitTag;
	}
	
	
	public Question[] questionList(){		
		int n=0;
		Question [] list = new Question[50];
	 
		File file = new File("./txt/question.txt");
		//입력 스트림 생성
		FileReader filereader = null;
		try {
			filereader = new FileReader(file);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//입력 버퍼 생성
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		try {
			while((line = bufReader.readLine()) != null){
				list[n] = new Question(n, line);
				//System.out.println(line);			//질문 제대로 읽었는지 테스트
				n++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tagNum=n; //질문갯수 = 태그갯수이므로 여기서 체크
		
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