package teamchat.data.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Currency;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class CurrencyDaoImpl implements CurrencyDao{
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public CurrencyDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	

	@Override
	public List<Currency> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Currency";
		Query<Currency> query=session.createQuery(hql,Currency.class);
		
		return query.getResultList();
	}

	@Override
	public Currency findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Currency currency=session.get(Currency.class, id);
		return currency;
	}

	@Override
	public void save(Currency currency) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(currency);
		
	}

	@Override
	public void update(Currency currency) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(currency);
		
	}

	@Override
	public void delete(Currency currency) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(currency);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Currency C where C.id=:var";
		Query<Currency> query=session.createQuery(hql,Currency.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}



	@Override
	public List<Currency> findByName(String name) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Currency C where C.currencyName like :var";
		Query<Currency> query=session.createQuery(hql,Currency.class);
		query.setParameter("var", name+"%");
		return query.getResultList();
	}

}
