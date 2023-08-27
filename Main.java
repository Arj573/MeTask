package Lec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
public static void sleep() {
	try {
		Thread.sleep(700);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
public static void logo() {
	
	System.out.println("    _ ____ __ ___       ______ ___ _  ____  __     ");
	System.out.println("   /'_   _ ' / _ \\     /__  __/ _ ' |/ ___// /__      ");
	sleep();
	System.out.println("  / / / / / /  __/  _    / / / |_|  |\\__ \\/ //_/              ");
	sleep();
	System.out.println(" /_/ /_/ /_/\\___/       / /  \\___/\\_|__/ / ,<          ");
	sleep();
	System.out.println("                       /_/          /___/_/|_|        ");
	sleep();
	
}
public static void cls() {
	for(int i = 0; i < 50; i++) {
		System.out.println("");
	}
}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int ch = 0, priority = 0;
		String taskName = "", deadline = "", priorityLevel = "", taskCode = "", subjectName = "", searchTask = "",
				ch1 = "", ch2=" ";
		String regex1 = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-(2[0][2-9][2-9])$";
		boolean exit = false;
		

		ArrayList<tasks> listTask = new ArrayList<>();
		ArrayList<Integer> listLevel = new ArrayList<>();
		
		do {
			logo();
			System.out.println("1. Add New Task");
			System.out.println("2. View Task List");
			System.out.println("3. Search Task");
			System.out.println("4. Exit");
			System.out.print(">> ");
			try {
				ch = scan.nextInt();
			} catch (Exception e) {

			}

			scan.nextLine();
			cls();

			switch (ch) {
			case 1:
				cls();
				System.out.println("");
				System.out.println("");

				System.out.println("1. ADD NEW TASK");
			
				do {
					
					cls();
					System.out.println("A. Input Task Name [St | As]: ");
					System.out.println("   1. St = study");
					System.out.println("   2. As = assignment");
					System.out.print(">> ");
					taskCode = scan.nextLine();
					if (taskCode.equals("St")) {
						taskName = "Study";
					}
					if (taskCode.equals("As")) {
						taskName = "Assignment";
					}
				} while (!(taskCode.equals("St") || taskCode.equals("As")));

				do {
					System.out.println(
							"B. Input Subject Name [Programming | Accounting | Business | Indonesian | English]: ");
					System.out.print(">> ");
					subjectName = scan.nextLine();
				} while (!(subjectName.equals("Programming") || subjectName.equals("Accounting")
						|| subjectName.equals("Business") || subjectName.equals("Indonesian")
						|| subjectName.equals("English")));

				do {
					System.out.println("C. Select Priority [1 - 3]: ");
					System.out.println("   1. Low Priority");
					System.out.println("   2. Medium Priority");
					System.out.println("   3. High Priority");
					System.out.print(">> ");
					try {
						priority = scan.nextInt();
					} catch (Exception e) {

					}
					scan.nextLine();
					if (priority == 1) {
						priorityLevel = "Low priority";
					}
					if (priority == 2) {
						priorityLevel = "Medium priority";
					}
					if (priority == 3) {
						priorityLevel = "High priority";
					}
				} while (priority < 1 || priority > 3);

				do {
					System.out.println("D. Deadline Date [mm-dd-yyyy]:");
					System.out.println("   1. Year/ yyyy must equals or greater 2022");
					System.out.println("   2. month/ mm must between 01 - 12");
					System.out.println("   3. date/ dd must between 01 - 31");

					System.out.print(">> ");
					deadline = scan.nextLine();
				} while (!(deadline.matches(regex1)));

				listTask.add(new tasks(taskName, subjectName, priorityLevel, deadline, priority));
				listLevel.add(priority);

				System.out.println("");

				System.out.println("Data has been input! Press Enter to Continue...");
				scan.nextLine();
				
				cls();
				break;

			case 2:
				
				cls();
				System.out.println("2. VIEW TASK LIST");

				if (listTask.isEmpty()) {

					System.out.println("");

					System.out.println("No data!!!");

				} else {
					System.out.println("");

					System.out.println("\t\t\t\t ME TASK TABLE");

					System.out.println(
							"+===================================================================================+");
					System.out.printf("|%-2s| %-30s| %-25s| %-20s| \n", "No", "Task Name", "Priority Level",
							"Deadline");
					System.out.println(
							"+===================================================================================+");

					for (int i = 0; i < listTask.size(); i++) {
						System.out.printf("|%-2d| %-30s| %-25s| %-20s| \n", (i + 1),
								(listTask.get(i).task + " " + listTask.get(i).subject), listTask.get(i).priority,
								listTask.get(i).date);

					}
					
					System.out.println(
							"+===================================================================================+");
					do {
						
						try {
							System.out.println("");
							System.out.print("Do You Want To Sort Task Name By Priority [yes / no] ? ");
							ch2 = scan.nextLine();
						} catch (Exception e) {
							
						}
						
						if (ch2.equals("yes")) {
							
							cls();
							System.out.println("Please wait, Sorting data by priority still in progress...");
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							cls();
							for (int i = 0; i < listTask.size() - 1; i++) {
								for (int j = 0; j < listTask.size() - i - 1; j++) {
									if (listLevel.get(j) < listLevel.get(j + 1)) {
										int temp = listLevel.get(j);
										listLevel.set(j, listLevel.get(j + 1));
										listLevel.set(j + 1, temp);

										Collections.swap(listTask, j, j + 1);
									}
								}
							}
							System.out.println("");

							System.out.println("\t\t\t\t ME TASK TABLE");

							System.out.println(
									"+===================================================================================+");
							System.out.printf("|%-2s| %-30s| %-25s| %-20s| \n", "No", "Task Name", "Priority Level",
									"Deadline");
							System.out.println(
									"+===================================================================================+");

							for (int i = 0; i < listTask.size(); i++) {
								System.out.printf("|%-2d| %-30s| %-25s| %-20s| \n", (i + 1),
										(listTask.get(i).task + " " + listTask.get(i).subject), listTask.get(i).priority,
										listTask.get(i).date);

							}

							System.out.println(
									"+===================================================================================+");
						

						System.out.println("");

						System.out.println("Press Enter to Continue...");
						scan.nextLine();
						cls();

							
						} else if (ch2.equals("no")) {
							cls();
						}
						
					} while (!(ch2.equals("yes") || ch2.equals("no")));
					
				}
				break;

			case 3:
				
				cls();

				System.out.println("3. SEARCH TASK");

				if (listTask.isEmpty()) {

					System.out.println("");

					System.out.println("No data!!!");
					System.out.println("press enter to continue...");
					scan.nextLine();

				} else {

					System.out.println("");

					do {
						System.out.println("A. Input task type [Study | Assignment]: ");
						System.out.print(">> ");
						searchTask = scan.nextLine();
						cls();
					} while (!(searchTask.equals("Study") || searchTask.equals("Assignment")));

					boolean ketemu = false;
					int ctr = 1;

					System.out.println("\t\t\t\t" + searchTask.toUpperCase() + " TASK TABLE");

					System.out.println(
							"+===================================================================================+");
					System.out.printf("|%-2s| %-30s| %-25s| %-20s| \n", "No", "Task Name", "Priority Level",
							"Deadline");
					System.out.println(
							"+===================================================================================+");

					for (tasks tasks : listTask) {
						if (tasks.task.equals(searchTask)) {

							System.out.printf("|%-2d| %-30s| %-25s| %-20s| \n", ctr, (tasks.task + " " + tasks.subject),
									tasks.priority, tasks.date);

							ketemu = true;
							ctr++;

						}

					}

					System.out.println(
							"+===================================================================================+");

					if (ketemu == false) {

						System.out.println("");
						System.out.println("data can't be founded!!!");

					}

					System.out.println("");

					System.out.println("Press enter to continue...");
					scan.nextLine();
					cls();

				}

				break;

			case 4:		
				cls();
				logo();
				System.out.println("");
				System.out.println("  Thank You For Using Me-Task :)");
				exit = true;
				break;
			}

		} while (ch != 4);

	}

}
