package com.base.webapp.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.webapp.common.tray.ResultSetTray;
import com.base.webapp.common.tray.Tray;
import com.base.webapp.dao.QuestionDao;

public class QuestionMainCmd    extends CommandFactory{
	private static final Logger logger = LoggerFactory.getLogger(BoardCmd.class);
	
	public QuestionMainCmd() {
	logger.info("QuestionCmd");

	setNextPage("QuestionCmd");
}
	
	@Override
	public ResultSetTray execute(Tray reqTray, HttpServletRequest request, HttpServletResponse response) {
		final Logger logger = LoggerFactory.getLogger(QuestionMainCmd.class);
			
		
		logger.info("do execute 실행 .");	
		
		ResultSetTray rsTray     = null;
		ResultSetTray checkoptiontray     = null;
		
		try {
			QuestionDao dao=new QuestionDao();
			rsTray=dao.QuestionList(getConnection(), reqTray);
		
		} catch (Exception ex) {
				ex.printStackTrace();
			}
		finally{
			logger.info("userid:"+reqTray.get("questionname"));
			logger.info("passwd:"+reqTray.get("questionphone"));
			
			
			request.setAttribute("rsTray", rsTray);			
			request.setAttribute("questionname",reqTray.get("questionname"));			
			request.setAttribute("questionphone",reqTray.get("questionphone"));			
		
		}
		
		// TODO Auto-generated method stub
		return rsTray;
	}

	
	
	
}
	
