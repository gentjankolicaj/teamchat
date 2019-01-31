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

		System.out.println();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testFindAll() throws Exception {
		List<Country> list = countryDao.findAll();
		for (Country country : list)
			System.out.println(country.toString());

	}
	
	@Test
	public void testFindById() throws Exception {
		Country country=countryDao.findById(new Long(1));
		System.out.println(country.toString());

	}
	
	@Test
	public void testSave() throws Exception {
		Country country=new Country();
		country.setCountryName("Test country");
		country.setIsoCodes("TEST");
		country.setPhonePrefix("010101");
		countryDao.save(country);
		

	}
	@Test
	public void testUpdate() throws Exception {
		Country country=new Country();
		country.setCountryName("Test country");
		country.setIsoCodes("TEST");
		country.setPhonePrefix("010101");
		
		countryDao.save(country);
		

	}
	
	@Test
	public void testDelete() throws Exception {
		
		

	}
	
	@Test
	public void testDeleteById() throws Exception {
		countryDao.deleteById(new Long(1) );		

	}
	
	

}
