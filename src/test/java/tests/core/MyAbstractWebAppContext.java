package tests.core;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import teamchat.web.config.RootConfig;

@WebAppConfiguration
@ContextConfiguration(classes= {RootConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(true)
public class MyAbstractWebAppContext {

}
