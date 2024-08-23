package sample;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TaskManagerApp {
	static Scanner sc=new Scanner(System.in);
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
	static EntityManager em=emf.createEntityManager();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter key to do operation:\n1. Save task\n2. Find Task\n3. Update Task\n4. Delete Task");
			switch(sc.nextInt()) {
				case 1: saveTask();
					break;
				case 2: findTask();
					break;
				case 3: updateTask();
					break;
				case 4: deleteTask();
					break;
				default: System.out.println("Invalid Choice");
			}
		}
	}
	
	public static void saveTask() {
//		Scanner sc=new Scanner(System.in);
		Task t=new Task();
		System.out.println("Enter ID");
		t.setId(sc.nextInt());
		System.out.println("Enter Title");
		t.setTitle(sc.next());
		System.out.println("Enter Description");
		t.setDes(sc.next());
		System.out.println(t);
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
//		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(t);
		et.commit();
		System.out.println(".........done!!!!!!!!!");
	}
	public static void findTask() {
//		Scanner sc=new Scanner(System.in);
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
//		EntityManager em=emf.createEntityManager();
		System.out.println("Enter ID");
		Task task=em.find(Task.class, sc.nextInt());
		System.out.println(task);
	}
	public static void updateTask() {
//		Scanner sc=new Scanner(System.in);
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
//		EntityManager em=emf.createEntityManager();
		System.out.println("Enter ID");
		Task task=em.find(Task.class, sc.nextInt());
		System.out.println("Enter Description");
		task.setDes(sc.next());
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(task);
		et.commit();
	}
	public static void deleteTask() {
//		Scanner sc=new Scanner(System.in);
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
//		EntityManager em=emf.createEntityManager();
		System.out.println("Enter ID");
		Task task=em.find(Task.class, sc.nextInt());
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(task);
		et.commit();
	}
}
