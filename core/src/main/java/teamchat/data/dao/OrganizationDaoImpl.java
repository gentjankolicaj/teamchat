package teamchat.data.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.domain.Organization;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public OrganizationDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Organization> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Organization";
		Query<Organization> query=session.createQuery(hql,Organization.class);

		return query.getResultList();
	}

	@Override
	public Organization findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Organization organization=session.get(Organization.class, id);
		return organization;
	}

	@Override
	public void save(Organization organization) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(organization);
		
	}

	@Override
	public void update(Organization organization) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(organization);
		
	}

	@Override
	public void delete(Organization organization) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(organization);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Organization O where O.id=:var";
		Query<Organization> query=session.createQuery(hql,Organization.class);
		return query.executeUpdate();
	}
	
	

}
