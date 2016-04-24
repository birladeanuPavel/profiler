package com.profiler.service;

import com.profiler.dal.config.AppDalConfig;
import com.profiler.service.config.AppServiceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppServiceConfig.class, AppDalConfig.class})
@Transactional
public abstract class GenericTest {

}
