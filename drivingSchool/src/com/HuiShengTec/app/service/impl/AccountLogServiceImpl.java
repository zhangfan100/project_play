package com.HuiShengTec.app.service.impl;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HuiShengTec.app.dao.IAccountStatisticsDao;
import com.HuiShengTec.app.service.IAccountLogService;
import com.HuiShengTec.entity.Accountstatistics;
import com.HuiShengTec.utils.Toolkit;
/**
 * 账务统计service
 * @author wtr
 *
 */
@Service
@Transactional
public class AccountLogServiceImpl implements IAccountLogService {
	
	@Autowired
	private IAccountStatisticsDao iAccountStatisticsDao;
	
	/**
	 * 统计时间段内账目
	 * @throws ParseException 
	 */
	public void countAccountLog(Accountstatistics data) throws ParseException{
		Map<String, Object> dataLists = null; 
		Integer statisticType = data.getStatisticType();
		switch (statisticType) {
		case 1://日统计
			dataLists= iAccountStatisticsDao.dayStatistics(data);
			break;
		case 2://周统计
			dataLists = iAccountStatisticsDao.weekStatistics(data);
			break;
		case 3://月统计
			dataLists = iAccountStatisticsDao.monthStatistics(data);
			break;
		case 4://季度统计
			dataLists = iAccountStatisticsDao.quarterStatistics(data);
			break;
		case 5://年统计
			dataLists = iAccountStatisticsDao.yearStatistics(data);
			break;

		default://自定义统计
			break;
		}
		fillData(data, dataLists);
	}
	
	/**
	 * 填充数据并且进行插入统计记录
	 * @param data
	 * @param dataLists
	 * @throws ParseException 
	 */
	private void fillData(Accountstatistics data,Map<String, Object> dataLists) throws ParseException{
		if(dataLists!=null){//说明有开销 
			for(Map.Entry<String, Object> m:dataLists.entrySet()){
				if(m.getKey().equals("income")){//收入类型
					data.setType(1);
				}else{
					data.setType(2);
				}
				data.setTotalCash(Float.valueOf(m.getValue().toString()));
				//设置每日金额并且填充日期
				setAverageDaily(data);
				//插入统计数据
				iAccountStatisticsDao.addAccountStatistics(data);
			}
		}
	}
	
	//设置每日金额并且填充日期
	private void setAverageDaily(Accountstatistics data) throws ParseException{
		Float totalCash = data.getTotalCash();//记录总金额
		int days = 1;//记录总天数
		String dateStr = Toolkit.parseDate(getLastQuarterTime(), null)+" 23:59:59";//上一天的最后一秒
		data.setEndTime(Toolkit.formatDate(dateStr,Toolkit.dateTimePattern));//统计的最后一天的最后一秒
		Calendar calendar = Calendar.getInstance();
		switch (data.getStatisticType()) {
		case 1://日统计
			data.setBeginTime(Toolkit.formatDate(dateStr,null));
			days=1;
			break;
		case 2://周统计
			calendar.add(Calendar.DATE, -7);
			data.setBeginTime(Toolkit.formatDate(Toolkit.parseDate(new Date(calendar.getTimeInMillis()), null),null));
			days=7;
			break;
		case 3://月统计
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, -1);//设置为上个月的日期
			days=calendar.getActualMaximum(Calendar.DATE);//得到总天数
			calendar.add(Calendar.DATE, -days+1);//设置为上个月的第一天
			data.setBeginTime(Toolkit.formatDate(Toolkit.parseDate(new Date(calendar.getTimeInMillis()), null),null));
			break;
		case 4://季度统计
			days=getDifferencesDays(getLastQuarterTime(), getFirstQuarterTime(-3));
			data.setBeginTime(Toolkit.formatDate(Toolkit.parseDate(getFirstQuarterTime(-3), null),null));
			break;
		case 5://年统计
			days=getDifferencesDays(getLastQuarterTime(), getFirstQuarterTime(-12));
			data.setBeginTime(Toolkit.formatDate(Toolkit.parseDate(getFirstQuarterTime(-12), null),null));
			break;

		default://自定义统计
			break;
		}
		data.setStatisticTime(Toolkit.getCurrDateWithoutTime());//设置统计时间
		Float averyCash = totalCash/days;
		BigDecimal bg = new BigDecimal(averyCash);
		averyCash = bg.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		data.setEverydayCash(averyCash);
	}
	
	/**
	 * 通过传来的参数得到对应的日期 
	 *               传来-3表示上个季度的对应今天 
	 *               传来-12表示去年的对应今天       
	 * @param step
	 * @return
	 */
	private  Date getFirstQuarterTime(int step) {
	  Calendar calendar = Calendar.getInstance();
	  calendar.add(Calendar.MONTH, step);
      return new Date(calendar.getTimeInMillis());
   }
   
   /**
    * 得到上一天的日期 
    * @return
    */
   private  Date getLastQuarterTime() {
	   Calendar calendar = Calendar.getInstance();
	   calendar.add(Calendar.DATE, -1);
	   return new Date(calendar.getTimeInMillis());
   }
   
   /**
    * 计算两个时间相差的天数  都是闭区间
    * @param date1
    * @param date2
    * @return
    */
	private int getDifferencesDays(Date date1,Date date2){
		int days = (int)((date1.getTime() - date2.getTime())/86400000);
		return days+1;
	}

}
