package teamchat.data.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamchat.data.dao.TeamDao;
import teamchat.data.domain.Team;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Repository
public class TeamDaoImpl implements TeamDao{
	
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public TeamDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Team> findAll() throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Team";
		Query<Team> query=session.createQuery(hql,Team.class);
		return query.getResultList();
	
	}

	@Override
	public Team findById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		Team team=session.get(Team.class, id);
		return team;
	}

	@Override
	public List<Team> findByName(String name) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Team T where T.name like :var";
		Query<Team> query=session.createQuery(hql,Team.class);
		query.setParameter("var", name+"%");
		return query.getResultList();
		
	}

	@Override
	public List<Team> findByDepartmentId(Long departmentId) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Team where department_id=:var";
		Query<Team> query=session.createQuery(hql,Team.class);
		query.setParameter("var", departmentId);
		return query.getResultList();
	}

	@Override
	public void save(Team team) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.save(team);
		
	}

	@Override
	public void update(Team team) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(team);
	}

	@Override
	public void delete(Team team) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		session.delete(team);
		
	}

	@Override
	public int deleteById(Long id) throws Exception {
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Team T where T.id=:var";
		Query<Team> query=session.createQuery(hql,Team.class);
		return query.executeUpdate();
	}
	
	

}
