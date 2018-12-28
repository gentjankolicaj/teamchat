package tests.core.dao;

import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.CountryDao;
import teamchat.data.domain.Country;
import tests.core.MyAbstractWebAppContext;

@Transactional //added this because at dao layer we don't have transaction help form spring.I have putted at service layer
public class CountryDaoImplTest extends MyAbstractWebAppContext {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CountryDao countryDao;

	@Before
	public void setUp() throws Exception {

		logger.info("\n\n");
		logger.info("---------------------------------Before Test---------------------------------");
		logger.info("");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("\n\n");
		logger.info("---------------------------------After Test---------------------------------");
		logger.info("");
	}

	@Test
	@Rollback(true)
	public void testFindAll() throws Exception {
		List<Country> list = countryDao.findAll();
		for (Country country : list)
			logger.info(country.toString());

	}
	
	@Test
	@Rollback(true)
	public void testFindById() throws Exception {
		Country country=countryDao.findById(new Long(1));
		logger.info(country.toString());

	}
	
	@Test
	@Rollback(true)
	public void testSave() throws Exception {
		Country country=new Country();
		country.setCountryName("Test country");
		country.setIsoCodes("TEST");
		country.setPhonePrefix("010101");
		countryDao.save(country);
		

	}
	@Test
	@Rollback(true)
	public void testUpdate() throws Exception {
		Country country=new Country();
		country.setCountryName("Test country");
		country.setIsoCodes("TEST");
		country.setPhonePrefix("010101");
		
		countryDao.save(country);
		

	}
	
	@Test
	@Rollback(true)
	public void testDelete() throws Exception {
		
		

	}
	
	@Test
	@Rollback(true)
	public void testDeleteById() throws Exception {
		countryDao.deleteById(new Long(1) );		

	}
	
	

}
