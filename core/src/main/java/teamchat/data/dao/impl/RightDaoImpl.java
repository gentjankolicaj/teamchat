package teamchat.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.RightDao;
import teamchat.data.domain.Right;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class RightDaoImpl implements RightDao{
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public RightDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

    
	@Override
	public List<Right> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Right";
		Query<Right> query=session.createQuery(hql,Right.class);
		return query.getResultList();
		
	}

	@Override
	public Right findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Right right=session.get(Right.class, id);
		return right;
	}

	@Override
	public void save(Right right) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(right);
	}

	@Override
	public void update(Right right) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.update(right);
	}

	@Override
	public void delete(Right right) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(right);;
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Right R where R.id=:var";
		Query<Right> query=session.createQuery(hql,Right.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}

}
