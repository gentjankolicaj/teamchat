package teamchat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.GroupDao;
import teamchat.data.domain.Group;
import teamchat.data.domain.User;
import teamchat.exception.GroupException;
import teamchat.service.GroupService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	
	private GroupDao groupDao;
	
    @Autowired
	public GroupServiceImpl(GroupDao groupDao) {
		super();
		this.groupDao = groupDao;
	}

  
	@Override
	public List<Group> getAll() throws Exception {
		return groupDao.findAll();
	}

	@Override
	public List<Group> getAllById(List<Long> ids) throws Exception {
		return groupDao.findAllById(ids);
	}

	@Override
	public Group getById(Long id) throws Exception {
		return groupDao.findById(id);
	}

	@Override
	public Group create(Group entity) throws Exception {
		return groupDao.save(entity);
	}

	@Override
	public List<Group> createAll(List<Group> entities) throws Exception {
		return groupDao.saveAll(entities);
	}

	@Override
	public Group edit(Group entity) throws Exception {
		return groupDao.update(entity);
	}

	@Override
	public List<Group> editAll(List<Group> entities) throws Exception {
		return groupDao.updateAll(entities);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		groupDao.deleteById(id);
		
	}

	@Override
	public void delete(Group entity) throws Exception{
		groupDao.delete(entity);
		
	}

	@Override
	public void deleteAll(List<Group> entities) throws Exception {
		groupDao.deleteAll(entities);
		
	}

	@Override
	public boolean existById(Long id) throws Exception {
		return groupDao.existById(id);
	}

	@Override
	public List<Group> getByNameLike(String name) throws Exception {
		return groupDao.findByNameLike(name);
	}

	@Override
	public Group addUser(Group group, User user) throws Exception {
		List<User> userList=group.getMembers();
		if(userList==null) {
			userList=new ArrayList<>();
			userList.add(user);
			group.setMembers(userList);
		}else {
			userList.add(user);
		}
		return groupDao.update(group);
	}

	@Override
	public Group addUsers(Group group, List<User> users) throws Exception {
		List<User> userList=group.getMembers();
		if(userList==null) {
			userList=users;
			group.setMembers(userList);
		}else {
			userList.addAll(users);
		}
		return groupDao.update(group);
	}

	@Override
	public Group removeUser(Group group, User user) throws Exception {
		List<User> userList=group.getMembers();
		if(userList==null) {
			throw new GroupException("User "+user+" dosen't belong to group "+group);
		}else {
			userList.remove(user);
		}
		return groupDao.update(group);
	}
    

	
}
