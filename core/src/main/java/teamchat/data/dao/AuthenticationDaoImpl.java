package teamchat.data.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Authentication;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

	private SessionFactory sessionFactory;

	@Autowired
	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Authentication> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Authentication";
		Query<Authentication> query = session.createQuery(hql, Authentication.class);
		return query.getResultList();
	}

	@Override
	public Authentication findById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Authentication authentication = session.get(Authentication.class, id);

		return authentication;
	}

	@Override
	public void save(Authentication authentication) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(authentication);

	}

	@Override
	public void update(Authentication authentication) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(authentication);

	}

	@Override
	public void delete(Authentication authentication) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(authentication);
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Authentication A where A.id=:var";
		Query<Authentication> query = session.createQuery(hql, Authentication.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}

	@Override
	public Authentication findByUserId(Long userId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Authentication where user_id=:var";
		Query<Authentication> query = session.createQuery(hql, Authentication.class);
		query.setParameter("var", userId);

		return query.getSingleResult();
	}

}
