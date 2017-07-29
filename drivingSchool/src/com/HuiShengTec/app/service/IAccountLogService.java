package com.HuiShengTec.app.service;

import java.text.ParseException;
import com.HuiShengTec.entity.Accountstatistics;

public interface IAccountLogService {

	public void countAccountLog(Accountstatistics data)throws ParseException;

}
