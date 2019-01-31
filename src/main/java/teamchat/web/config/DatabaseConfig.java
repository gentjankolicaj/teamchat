package teamchat.web.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-mysql.properties")
public class DatabaseConfig {

	
	   // set up variable to hold the properties
		@Autowired
		private Environment env;
		
		// set up a logger for diagnostics
		private Logger logger = Logger.getLogger(getClass().getName());
		
		
		
		// define a bean for our security datasource
		
		@Bean
		public DataSource securityDataSource() {
			
			// create connection pool
			ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

			// set the jdbc driver
			try {
				securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));		
			}
			catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}
			
			// for sanity's sake, let's log url and user ... just to make sure we are reading the data
	        logger.info("--------------------------------------------------------------------");
			logger.info("jdbc.driver=" + env.getProperty("jdbc.driver"));
			logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
			logger.info("jdbc.username=" + env.getProperty("jdbc.username"));
			logger.info("jdbc.password=" + env.getProperty("jdbc.password"));
			
			 logger.info("--------------------------------------------------------------------");
			// set database connection props
			
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.username"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
			
			// set connection pool props
			securityDataSource.setInitialPoolSize(
			getIntProperty("connection.pool.initialPoolSize"));

			securityDataSource.setMinPoolSize(
					getIntProperty("connection.pool.minPoolSize"));
			
			securityDataSource.setMaxPoolSize(
					getIntProperty("connection.pool.maxPoolSize"));
			
			securityDataSource.setMaxIdleTime(
					getIntProperty("connection.pool.maxIdleTime"));
					
			return securityDataSource;
		}
		
		// need a helper method 
		// read environment property and convert to int
		
		private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}
		
		private Properties getHibernateProperties() {

			// set hibernate properties
			Properties props = new Properties();

			props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
			props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
			return props;				
		}

		
		@Bean
		public LocalSessionFactoryBean sessionFactory(){
			
			// create session factorys
			LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
			
			// set the properties
			localSessionFactory.setDataSource(securityDataSource());
			localSessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
			localSessionFactory.setHibernateProperties(getHibernateProperties());
			
			return localSessionFactory;
		}
		

		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			
			// setup transaction manager based on session factory
			HibernateTransactionManager txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);

			return txManager;
		}
}
