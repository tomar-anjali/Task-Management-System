package sample;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateTask {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tsk");
		EntityManager em=emf.createEntityManager();
		System.out.println("Enter ID");
		Task task=em.find(Task.class, sc.nextInt());
		task.setDes("Study core java");
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(task);
		et.commit();
	}

}
