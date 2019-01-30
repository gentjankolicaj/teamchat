package teamchat.data.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.DepartmentDao;
import teamchat.data.domain.Department;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class DepartmentDaoImpl  implements DepartmentDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public DepartmentDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Department> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Department";
		Query<Department> query=session.createQuery(hql,Department.class);
		return query.getResultList();
		
	}

	@Override
	public Department findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Department department=session.get(Department.class, id);
		return department;
	}

	@Override
	public List<Department> findByName(String name) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Department D where D.name=:var";
		Query<Department> query=session.createQuery(hql,Department.class);
		query.setParameter("var",name+"%");
		
		return query.getResultList();
	}

	@Override
	public List<Department> findByCreatorId(Long creatorId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Department where creator_id=:var";
		Query<Department> query=session.createQuery(hql,Department.class);
		query.setParameter("var",creatorId);
		
		return query.getResultList();
	}

	@Override
	public void save(Department department) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(department);
		
	}

	@Override
	public void update(Department department) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(department);
		
	}

	@Override
	public void delete(Department department) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(department);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Department D where D.id=:var";
		Query<Department> query=session.createQuery(hql,Department.class);
		query.setParameter("var", id);
		return query.executeUpdate();
	}
	
	

}
