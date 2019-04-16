/*3. Усовершенствуйте класс, описывающий группу студентов, добавив возможность сохранения группы в файл.
4. Реализовать обратный процесс. Т.е. считать данные о группе из файла, и на их основе создать объект типа группа.*/


package com.yandex.kbelyako;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Human person1 = new Human();
		//Human person2 = new Human("Petr", "Ivanovich", "Ivanov", 19, "male");
	//	System.out.println(person2);
		
		// student1=person2;
	//System.out.println(student1);
		Group testGroup = new Group();
		//System.out.println(testGroup);
		
		Student student1 = new Student("Petr", "Ivanovich", "Ivanov", 19,
				"male");
		System.out.println(student1.toString());

		Student student2 = new Student("Evgeniy", "Ivanovich", "Gurin", 19,
				"male");
		
		Student student3 = new Student("Vasiliy", "Aleksandrovich", "Arbuzov",
				19, "male");
		student3.setfName("Alex");
		Student student4 = new Student("Aleksey", "Olegovich", "Vasiliyev", 19,
				"male");
		Student student5 = new Student("Dmitri", "Ivanovich", "Ivanov", 18,
				"male");
		Student student6 = new Student("Olga", "Petrovna", "Kravtsova", 21,
				"female");
		Student student7 = new Student("Petr", "Ivanovich", "Bublikov", 22,
				"male");
		Student student8 = new Student("Vasiliy", "Aleksandrovich", "Kaverin",
				19, "male");
		Student student9 = new Student("Aleksey", "Ivanovich", "Ivanov", 17,
				"male");
		Student student10 = new Student("Dmitri", "Olegovich", "Afanasiev", 18,"male");
				
		Student student11 = new Student("Olga", "Petrovna", "Romashkina", 19,
				"female");
		
			testGroup.addstudent(student1, 1);
			testGroup.addstudent(student2, 2);
			testGroup.addstudent(student10, 10);
			testGroup.addstudent(student3, 3);
			testGroup.addstudent(student5, 5);
			testGroup.addstudent(student9, 9);
		/*	testGroup.addstudent(student4, 4);
			
			testGroup.addstudent(student6, 6);
			testGroup.addstudent(student7, 7);
			testGroup.addstudent(student8, 8);
			
	
			testGroup.addstudent(student11, 11);
			testGroup.addstudent(student11, 12);
			testGroup.addstudent(student11, 13);
			testGroup.addstudent(student1, 1);*/
	
		System.out.println(testGroup);
		testGroup.addstudent(student11, 13);

/*		try {

			testGroup.addstudent(student1, 1);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}*/
testGroup.rmvStudent(-11);
//System.out.println(testGroup);
//testGroup.rmvStudent(1);
//testGroup.rmvStudent(1);
testGroup.toStringTable();
System.out.println("Group");
System.out.println(testGroup);
System.out.println("Group to string");
System.out.println(testGroup.toString());
System.out.println("Group to string Sorted");
//System.out.println(testGroup.toStringSorted());
testGroup.toStringTable();
System.out.println(testGroup.findStudentOutString("Ivanov"));
System.out.println(testGroup.findStudentOutString("Ivanova"));
System.out.println(testGroup.findStudentOutString("Gurin"));

System.out.println("Last ver");
System.out.println(Arrays.asList(testGroup.findStudent("Ivanov")));
System.out.println(Arrays.asList(testGroup.findStudent("Gurin")));
System.out.println(Arrays.asList(testGroup.findStudent("Ivanova")));

//System.out.println(testGroup.toStringSorted());

testGroup.addstudent(student4, 4);
testGroup.addstudent(student6, 6);
testGroup.addstudent(student7, 7);
testGroup.addstudent(student8, 8);

testGroup.sorbysName();
testGroup.toStringTable();

testGroup.sortByParam(1);


testGroup.toStringTable();

testGroup.sortByParam(2);
testGroup.rmvStudent(5);


testGroup.toStringTable();
testGroup.sortByParam(3);
testGroup.sortByParam(-83);
//testGroup.addstudentInteractive(5);
testGroup.toStringTable();


testGroup.getMilReadyStudents();



/*try (PrintWriter a = new PrintWriter("test1.txt")) {
	
	testGroup.toString();

	a.print(testGroup.toString());
	a.println("Black Rabbit");
	a.println("Green Lamp");
} catch (FileNotFoundException e) {
	System.out.println("ERROR FILE WRITE");
}
*/
testGroup.addstudent(student3, 3);
testGroup.saveToFile();
File test1 = new File("test1.txt");

System.out.println(student10.toStringToFile());

System.out.println(Group.FiletoString(test1));
String[] array4 = Group.FiletoString(test1).split(";");
System.out.println(Arrays.toString(array4));
Group  groupFromFile = new Group();
String line="Aleksey Olegovich Vasiliyev 19 male";
groupFromFile.addstudent(Group.studentFromString(line), 2);
String line1="Vlad Olegovich Vasiliyev 19 male";

groupFromFile.addstudent(Group.studentFromString(line), 1);
String line3="";
groupFromFile.addstudent(Group.studentFromString(line), 2);

for (int i = 0; i < array4.length; i++) {
	groupFromFile.addstudent(Group.studentFromString(array4[i]), i+1);
//	
	}
System.out.println("from file:");
System.out.println(groupFromFile.toString());
	}

}
