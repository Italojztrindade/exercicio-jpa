package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Por estar em um ambiente transaction, qualquer alteração irá ser sincronizada com o DB.
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Leonardo");
		
		//em.merge(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
