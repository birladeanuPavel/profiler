package com.profiler.dal;

import com.profiler.dal.config.AppDalConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppDalConfig.class})
@Transactional
public abstract class GenericTest {

}
