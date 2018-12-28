package tests.core.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.AttemptDao;
import teamchat.data.domain.Attempt;
import tests.core.MyAbstractWebAppContext;

@Transactional
public class AttemptDaoImplTest extends MyAbstractWebAppContext {

	
	@Autowired
	private AttemptDao attemptDao;
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	

	@Test
	public void testFindAll() throws Exception {
		int expectedValue=0;
		List<Attempt> attempts=attemptDao.findAll();
		
		assertEquals(expectedValue,attempts.size());
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByUserId() {
		fail("Not yet implemented");
	}

}
