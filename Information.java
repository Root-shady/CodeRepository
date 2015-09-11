import java.util.*;
public class Information{
	private int number = 0;
	public LinkedList<Student> infor = new LinkedList<>();
	
	public static void main(String... args){
	Information list = new Information();
	int option = list.menu();
	list.select(list, option);
	}
	public int menu(){
		String format = "| %-50s|%n";
		
		System.out.format("------------------------------------------------------%n");
		System.out.format(format, "Options:");
		System.out.format(format, "1. Enter Information");
		System.out.format(format, "2. Display Information");
		System.out.format(format, "3. Change Information.");
		System.out.format(format, "4. Clear all Information.");
		System.out.format(format, "5. Delete Specific Information.");
		System.out.format(format, "6. Find Information.");
		System.out.format(format, "7. Show Help.");
		System.out.format(format, "8. Exit.");
		System.out.format("------------------------------------------------------%n");
		System.out.println();
		System.out.print("Please enter an option: ");
		System.out.println("Make sure the integer(0~8): ");
		int option = getInteger(true);
		return option;
	}
		private int getInteger(boolean test){
			Scanner input = new Scanner(System.in);
			int integer;
			while(true){
				String in = input.nextLine();
				try{
					integer = Integer.parseInt(in);
					if(test && integer>0 && integer < 9)
						return integer;
					else if(test == false)
						return integer;
					else
						continue;
				}catch(NumberFormatException e){
					continue;
				}
			}
	}
	public void select(Information list, int option){
		boolean running = true;
		while(running){
			switch(option){
				case 1:
					list.enterInformation(list);
					sleep(	0);
					option = list.menu();
					break;
				case 2:
					displayInformation(list);
					sleep(	0);
					option = list.menu();
					break;
				case 3:
					changeInformation(list);
					sleep(	0);
					option = list.menu();
					break;
				case 4:
					list.infor.clear();
					sleep(	0);
					System.out.println("The information are all cleared.");
					option = list.menu();
					break;
				case 5:
					deleteInformation(list);
					sleep(	0);
					option = list.menu();
					break;
				case 6:
					findInformation(list);
					sleep(	0);
					option = list.menu();
					break;
				case 7:
					showHelp();
					sleep(	0);
					option = list.menu();
					break;
				case 8:
					System.out.println("Thanks for use, the program is exiting!");
					sleep(	0);
					System.exit(0);
  
				default:
					System.out.println("Enter the number 1~8, Man");
					option = list.menu();
					break;
			}
		}
	}
	public void enterInformation(Information list){
		boolean add = true;
		char choice;
		while(add){
			list.infor.add(getItem());
			System.out.println("Added Success!");
			System.out.println("Want to add another?(Y|y), Hit any key to go back to the menu: ");
			Scanner input = new Scanner(System.in);
			choice = input.next(".").charAt(0);
			if(choice == 'Y' || choice == 'y')
				add = true;
			else
				add = false;
		}
	
	}
	private Student getItem(){
		System.out.println("Please enter the inforamtion:"
		+ "Name: Age: Sex: Phone: Major: ");
		Scanner input = new Scanner(System.in);
		String name;
		int age;
		char sex;
		String phone;
		String major;
		
		while(true){
			System.out.println("Make sure enter the right format input.");
			try{
				name = input.next();
				if(input.hasNextInt())
					age = input.nextInt();
				else
					throw new InputMismatchException();
				sex = input.next(".").charAt(0);
				phone = input.next();
				major = input.next();
				Student one = new Student(name, age, sex, phone, major);
				return one;
			}catch(InputMismatchException e){
				input.nextLine(); //Consume the remained garbage
				continue;	
			}
		}
	}
	public void displayInformation(Information list){
		ListIterator listitor = list.infor.listIterator();
		int record = list.infor.size();
		System.out.println("You have " + record+" records in the system.");
		if(record == 0)
			return ;
		while(listitor.hasNext()){
			System.out.println(listitor.next());
		}
		System.out.println();
	}
	public void changeInformation(Information list){
		int index = 0;
		if(validIndex(list) != -1){
			System.out.println("The index is:" + index);
			Student modify = getItem();
			list.infor.set(index, modify);
			System.out.println("Update Success!");
		}
		else
			return ;
	}
	private int validIndex(Information list){
		boolean condition = true;
		int index = -1;
		while(condition){
			System.out.println("Please enter the index of the information: "); //Super sucks...bu GUI will save the life.
			condition =false;
			index = getInteger(false);
			if(index<0 || index>list.infor.size()-1){
				System.out.println("The information index dosen't exist, want to enter another:");
				System.out.println("Enter Y|y to confirm, hit any key to return to the menu.");
				Scanner input = new Scanner(System.in);
				char again = input.next(".").charAt(0);
				if(again == 'Y' || again == 'y')
					condition = true;
				else
					index = -1;
			}
		}
		return index;
	}
 
	public void deleteInformation(Information list){
		int index = validIndex(list);	
		if(index != -1){
			//delete something.
			list.infor.remove(index);
			System.out.println("Delete Success!");
		}
		else 
			return ;
	}
 
	public void findInformation(Information list){
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		boolean found = false;
		String name;
		while(condition){
			condition = false;
			System.out.println("Please enter the name of the Student: ");
			name = input.nextLine();
			System.out.println("The searching result: ");
			for(Student e: list.infor){
				if(e.getName().equals(name)){
					System.out.println(e);
					found = true;
				}
			}
			if(found == false )
				System.out.println("Cannot be found!");
			System.out.println("Wanna perform another search?(Y|y)");
			char choice = input.next(".").charAt(0);
			if(choice == 'Y'|| choice == 'y'){
				found = false;
				condition = true;
				input.nextLine();
			}
		}
	}
	public void showHelp(){
		System.out.println("You got Me!");
		System.out.println("Happy Coding!");
	}
 
	private void sleep(int time){
		try{
			Thread.sleep(time);
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
 }
