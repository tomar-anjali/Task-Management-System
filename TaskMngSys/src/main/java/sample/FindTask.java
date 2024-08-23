package sample;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindTask {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
		EntityManager em=emf.createEntityManager();
		System.out.println("Enter ID");
		Task task=em.find(Task.class, sc.nextInt());
		System.out.println(task);
//		EntityTransaction et=em.getTransaction();   persist merge remove (no need for find())
	}
}
