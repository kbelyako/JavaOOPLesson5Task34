package com.yandex.kbelyako;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements Comparator<Human>, Military {

	private Student[] group1 = new Student[10];

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student[] getGroup1() {
		return group1;
	}

	public void setGroup1(Student[] group1) {
		this.group1 = group1;
	}

	public Group(Student[] group1) {
		super();
		this.group1 = group1;
	}

	public String toStringSorted() {

		return "Group [group1=" + Arrays.toString(sort(group1)) + "]";

	}

	@Override
	public String toString() {

		return "Group [group1=" + Arrays.toString(group1) + "]";
	}

	public void toStringTable() {

		for (int i = 0; i <= 9; i++) {
			System.out.println(i + 1 + " " + group1[i]);

		}

	}

	public void addstudent(Student student, int i) {

		if (i - 1 > 10) {
			try {
				throw new MyException();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (i - 1 < 10) {
			if (group1[i - 1] == null) {
				group1[i - 1] = student;
			} else
				System.out.println("Position " + i
						+ " is already busy in this group, please delete student from this position first or try to add student to another position");

		}
	}

	public void addstudentInteractive(int i) {

		Student newStudent = new Student();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		try {
			newStudent.setfName(in.next());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("Enter student last name: ");
		newStudent.setlNname(in.next());
		System.out.print("Enter student patronymic: ");
		newStudent.setPatronymic(in.next());
		System.out.print("Enter student sex: ");
		newStudent.setSex(in.next());
		System.out.print("Enter student age: ");
		newStudent.setAge(in.nextInt());
		if (i - 1 > 10) {
			try {
				throw new MyException();
			} catch (MyException e) {

				e.printStackTrace();
			}
		}

		if (i - 1 < 10) {
			if (group1[i - 1] == null) {
				group1[i - 1] = newStudent;
			} else
				System.out.println("Position " + i
						+ " is already busy in this group, please delete student from this position first or try to add student to another position");

		}
	}

	public void rmvStudent(int i) {
		try {
			if (group1[i - 1] != null) {
				group1[i - 1] = null;
			} else
				System.out.println("Position " + i + " is already empty in this group");

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Not possible to delete student from this position, because it's out of range 1..10");
		}
	}

	public Student[] sortNulls(Student[] group) {
		Student[] groupNew = group;
		boolean isSorted = false;
		Student buf;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < groupNew.length - 1; i++) {
				if ((groupNew[i] == null) && (groupNew[i + 1] != null)) {
					isSorted = false;
					buf = groupNew[i];
					groupNew[i] = groupNew[i + 1];
					groupNew[i + 1] = buf;
				} else {
					continue;
				}
			}
		}
		return groupNew;

	}

	public Student[] sort(Student[] group) {

		Student[] groupNew = sortNulls(group);

		boolean isSorted = false;
		Student buf;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < groupNew.length - 1; i++) {
				if ((groupNew[i] != null) && (groupNew[i + 1] != null)) {
					if (groupNew[i].getlName().charAt(0) > groupNew[i + 1].getlName().charAt(0)) {
						isSorted = false;
						buf = groupNew[i];
						groupNew[i] = groupNew[i + 1];
						groupNew[i + 1] = buf;
					}
				}

				else {
					continue;
				}
			}
		}
		return groupNew;
	}

	public void sorbysName() {
		Arrays.sort(group1);

	}

	@Override
	public int compare(Human o1, Human o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sortByParam(int option) {

		Comparator<Human> ageComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return (int) (h1.getAge() - h2.getAge());
			}
		};

		Comparator<Human> fNameComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return h1.getfName().compareTo(h2.getfName());
			}
		};
		if (option == 1) {
			Arrays.sort(group1, ageComparator);
		}

		if (option == 2) {
			Arrays.sort(group1, fNameComparator);
		}

		else {
			System.out.println("Wrong sort option !!!");
		}
		;

	}

	public String findStudentOutString(String lName) {
		Student result = null;
		int counter = 0;

		String strResult = "Search result for last name " + lName + ":";
		for (int i = 0; i <= 9; i++) {
			if (group1[i] != null) {
				if (group1[i].getlName() == lName) {
					result = group1[i];
					counter = counter + 1;
					strResult = strResult + (char) 0x0D + result.toString();

				}
			} else
				continue;

		}
		if (result == null) {
			strResult = strResult + (char) 0x0D + "No such student in this group";
		}
		return strResult;

	}

	public Student[] findStudent(String lName) {
		int counter = -1;
		Student[] fresult = new Student[10];
		for (int i = 0; i <= 9; i++) {

			if (group1[i] != null) {
				if (group1[i].getlName() == lName) {
					counter = counter + 1;
					fresult[counter] = group1[i];
				}
			}
		}
		Student[] ffresult = new Student[counter + 1];
		java.lang.System.arraycopy(fresult, 0, ffresult, 0, counter + 1);

		return ffresult;
	}

	@Override
	public Student[] getMilReadyStudents() {
		Student[] fresult = new Student[10];
		int i = 0;
		for (Student student : group1) {
			if (student == null) {
				continue;
			} else {
				if (student.getSex() == "male" && student.getAge() >= 18) {
					fresult[i] = student;
					i = i + 1;
				}
			}
		}
		System.out.println(Arrays.toString(fresult));
		return fresult;
	}

}