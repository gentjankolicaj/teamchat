package teamchat.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.UserAdressDao;
import teamchat.data.domain.UserAdress;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class UserAdressDaoImpl implements UserAdressDao {

	private SessionFactory sessionFactory;

	@Autowired
	public UserAdressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<UserAdress> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		return query.getResultList();
	}

	@Override
	public UserAdress findById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		UserAdress userAdress = session.get(UserAdress.class, id);
		return userAdress;
	}

	@Override
	public List<UserAdress> findByCityLike(String cityName) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress U where U.city like :var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", cityName + "%");
		return query.getResultList();
	}

	@Override
	public List<UserAdress> findByStreetLike(String street) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress U where U.street like :var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", street + "%");
		return query.getResultList();

	}

	@Override
	public List<UserAdress> findByCountryId(Long countryId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from UserAdress where country_id=:var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", countryId);
		return query.getResultList();
	}

	@Override
	public UserAdress save(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(userAdress);
		return userAdress;

	}

	@Override
	public UserAdress update(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userAdress);
		return userAdress;
	}

	@Override
	public void delete(UserAdress userAdress) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(userAdress);

	}

	@Override
	public void deleteById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from UserAdress U where U.id=:var";
		Query<UserAdress> query = session.createQuery(hql, UserAdress.class);
		query.setParameter("var", id);
		query.executeUpdate();
	}

	@Override
	public List<UserAdress> findAllById(List<Long> ids) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<UserAdress> list = new ArrayList<>(ids.size());
		for (Long id : ids) {
			UserAdress tmp = session.get(UserAdress.class, id);
			list.add(tmp);
		}
		return list;
	}

	@Override
	public List<UserAdress> saveAll(List<UserAdress> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (UserAdress tmp : entities)
			session.save(tmp);

		return entities;
	}

	@Override
	public List<UserAdress> updateAll(List<UserAdress> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (UserAdress tmp : entities)
			session.saveOrUpdate(tmp);

		return entities;
	}

	@Override
	public void deleteAll(List<UserAdress> entities) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		for (UserAdress tmp : entities)
			session.delete(tmp);

	}

	@Override
	public boolean existById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		UserAdress tmp = session.get(UserAdress.class, id);
		if (tmp != null)
			return true;
		else
			return false;
	}

}
