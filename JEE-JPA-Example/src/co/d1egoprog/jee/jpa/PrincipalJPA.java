package co.d1egoprog.jee.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.d1egoprog.jee.jpa.entity.Artista;

public class PrincipalJPA {
	private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		// create new todo
		em.getTransaction().begin();
		Artista art1 =  new Artista("Dante", 1900);
		Artista art2 =  new Artista("Otro Dante", 1900);
		em.persist(art1);
		em.persist(art2);
		em.getTransaction().commit();
		em.close();
	}
}
