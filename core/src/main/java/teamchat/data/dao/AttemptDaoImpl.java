package teamchat.data.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Attempt;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class AttemptDaoImpl implements AttemptDao{
	
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public AttemptDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	
	@Override
	public List<Attempt> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Attempt order by id";
		Query<Attempt> query=session.createQuery(hql,Attempt.class);
		
	    return query.getResultList();
	}

	@Override
	public Attempt findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Attempt attempt=session.get(Attempt.class,id);
		return attempt;
	}

	@Override
	public void save(Attempt attempt) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(attempt);
		
	}

	@Override
	public void update(Attempt attempt) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(attempt);
		
	}

	@Override
	public void delete(Attempt attempt) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(attempt);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Attempt A where A.id=:var";
		Query<Attempt> query=session.createQuery(hql);
		query.setParameter("var", id);
		
		return query.executeUpdate();
	}


	@Override
	public List<Attempt> findByUserId(Long userId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Attempt where user_id=:var";
		Query<Attempt> query=session.createQuery(hql,Attempt.class);
		query.setParameter("var", userId);
		
		return query.getResultList();
	}

}
