package teamchat.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Country;



/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class CountryDaoImpl implements CountryDao {
	
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public CountryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Country> findAll() throws Exception {
         Session session=sessionFactory.getCurrentSession();
         String hql="from Country order by id";
         Query<Country> query=session.createQuery(hql, Country.class);
        
		return query.getResultList();
	}

	@Override
	public Country findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Country country=session.get(Country.class, id);
		
		return country;
	}

	@Override
	public void save(Country country) throws Exception {
    Session session=sessionFactory.getCurrentSession();
    session.save(country);
		
	}

	@Override
	public void update(Country country) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(country);
		
	}

	@Override
	public void delete(Country country) throws Exception {
	  Session session=sessionFactory.getCurrentSession();
	  session.delete(country);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Country C where C.id=:var";
		Query<Country> query=session.createQuery(hql,Country.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}

}
