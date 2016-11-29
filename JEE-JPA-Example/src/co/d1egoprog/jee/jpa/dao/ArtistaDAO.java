package co.d1egoprog.jee.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.d1egoprog.jee.jpa.entity.Artista;

public class ArtistaDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
	private static EntityManagerFactory factory;
	private EntityManager em;


	public ArtistaDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	public String  create(Artista artista){
		try{
			em.getTransaction().begin();
			em.persist(artista);
			em.getTransaction().commit();
			return "Artista creado correctamente";
		}catch(Exception e){
			em.getTransaction().rollback();
			return "Error Creando el Artista";
		}
	}
	
	public String delete(Artista artista){
		try{
			em.getTransaction().begin();
			em.remove(artista);
			em.getTransaction().commit();
			return "Artista eliminado correctamente";
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			return "Error eliminado el Artista, Razon: " + e.getMessage();
		}
	}

	public Artista find(long id){
		Artista artista = em.find(Artista.class, id);
		return artista;
	}
	
	public List<Artista> findAll(){
		List<Artista> artistas = em.createQuery("from Artista a").getResultList();
		return artistas;
	}

}
