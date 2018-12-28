package teamchat.data.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Industry;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class IndustryDaoImpl implements IndustryDao {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public IndustryDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Industry> findAll() throws Exception {
	  Session session=sessionFactory.getCurrentSession();
	  String hql="from Industry";
	  Query<Industry> query=session.createQuery(hql,Industry.class);
	  return query.getResultList();
	}

	@Override
	public Industry findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Industry industry=session.get(Industry.class, id);
		return industry;
	}

	@Override
	public List<Industry> findByName(String name) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Industry I where I.name like :var"; 
		Query<Industry> query=session.createQuery(hql,Industry.class);
		query.setParameter("var",name+"%");
		
		return query.getResultList();
	}

	@Override
	public void save(Industry industry) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(industry);
		
	}

	@Override
	public void update(Industry industry) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(industry);;
		
	}

	@Override
	public void delete(Industry industry) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(industry);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Industry I where I.id=:var";
		Query<Industry> query=session.createQuery(hql,Industry.class);
		query.setParameter("var",id);
		return query.executeUpdate();
	}

}
