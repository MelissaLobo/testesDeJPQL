package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT = "testeJPQL";
	private static EntityManagerFactory entityManagerFactory;

	private JPAUtil() {
	}

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return entityManagerFactory.createEntityManager();
	}
}
