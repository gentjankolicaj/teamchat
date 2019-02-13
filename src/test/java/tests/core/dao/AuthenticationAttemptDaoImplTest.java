package tests.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.AuthenticationAttemptDao;
import teamchat.data.domain.AuthenticationAttempt;
import tests.core.MyAbstractWebAppContext;


@Transactional
public class AuthenticationAttemptDaoImplTest extends MyAbstractWebAppContext {

	
	@Autowired
	private AuthenticationAttemptDao attemptDao;
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	

	@Test
	public void testFindAll() throws Exception {
		int expectedValue=0;
		List<AuthenticationAttempt> attempts=attemptDao.findAll();
		
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
