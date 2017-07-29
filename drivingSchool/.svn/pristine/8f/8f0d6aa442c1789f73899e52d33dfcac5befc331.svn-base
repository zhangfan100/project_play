package com.HuiShengTec.test.service;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.HuiShengTec.app.service.IAccountLogService;
import com.HuiShengTec.entity.Accountstatistics;
import com.HuiShengTec.test.basejunit.AbstractJunit;

public class AccountLogServiceTest extends AbstractJunit{

	@Autowired
	private IAccountLogService iAccountLogService;
	
	@Test
	public void get() throws ParseException{
		Accountstatistics data = new Accountstatistics();
		//data.setStatisticType(1);
		//data.setStatisticType(2);
		//data.setStatisticType(3);
		//data.setStatisticType(4);
		data.setStatisticType(5);
		iAccountLogService.countAccountLog(data);
	}
}
