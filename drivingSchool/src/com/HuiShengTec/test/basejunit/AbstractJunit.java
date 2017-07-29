package com.HuiShengTec.test.basejunit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)          
@ContextConfiguration(locations = {"classpath:com/HuiShengTec/test/config/Spring-*.xml"})  
public abstract class AbstractJunit {  
}  