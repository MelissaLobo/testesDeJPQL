package persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;

public abstract class DaoGenerico<T, I extends Serializable> {
	// T é o tipo, a classe. E I é o tipo do id, int ou long

	protected final EntityManager entityManager;
	protected final Class<T> clazz;

	protected DaoGenerico() {
		this.entityManager = JPAUtil.getEntityManager();

		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		this.clazz = clazz;
	}

	public void create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public T update(T entity) {
		T entityUpdated = null;
		try {
			entityManager.getTransaction().begin();
			entityUpdated = entityManager.merge(entity);
			entityManager.flush();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return entityUpdated;

	}

	public void destroy(T entity) {
		try {
			entityManager.getTransaction().begin();

			entityManager.remove(entity);
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public T find(I id) {

		T object = null;

		try {
			entityManager.getTransaction().begin();

			object = entityManager.find(clazz, id);
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		List<T> resultList = null;

		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("from " + clazz.getName());

			resultList = query.getResultList();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return resultList;
	}
}