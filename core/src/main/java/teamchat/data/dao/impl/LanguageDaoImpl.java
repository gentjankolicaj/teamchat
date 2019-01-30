package teamchat.data.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.LanguageDao;
import teamchat.data.domain.Language;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class LanguageDaoImpl implements LanguageDao{
	
	
	 private SessionFactory sessionFactory;
	 
    @Autowired 
	public LanguageDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	

	@Override
	public List<Language> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Language";
		Query<Language> query=session.createQuery(hql,Language.class);
		return query.getResultList();
	}

	@Override
	public Language findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
	    Language language=session.get(Language.class, id);
	    
		return language;
	}

	@Override
	public List<Language> findByLang(String lang) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Language L where L.language like :var";
		Query<Language> query=session.createQuery(hql,Language.class);
		query.setParameter("var", lang+"%");
		return query.getResultList();
	}

	@Override
	public void save(Language language) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(language);
		
	}

	@Override
	public void update(Language language) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(language);
		
	}

	@Override
	public void delete(Language language) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(language);
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Language L where L.id=:var";
		Query<Language> query=session.createQuery(hql,Language.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}

}
