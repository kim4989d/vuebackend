package com.base.webapp.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.webapp.common.tray.ResultSetTray;
import com.base.webapp.common.tray.Tray;
import com.base.webapp.dao.BoardDao;

public class NoticeListCmd extends CommandFactory{
	private static final Logger logger = LoggerFactory.getLogger(NoticeListCmd.class);
	
	
public NoticeListCmd() {
	logger.info(this.getClass().getName());

	
}
	
	@Override
	public ResultSetTray execute(Tray reqTray, HttpServletRequest request, HttpServletResponse response) {
		final Logger logger = LoggerFactory.getLogger(NoticeListCmd.class);
			
		
		logger.info("do execute 실행 .");	
		
		ResultSetTray rsTray     = null;
		ResultSetTray checkoptiontray     = null;
		
		try {
			BoardDao dao = new BoardDao();
			rsTray=dao.BoardList(getConnection(), reqTray);
		
		} catch (Exception ex) {
				ex.printStackTrace();
			}
		finally{
			request.setAttribute("rsTray", rsTray);			
		}
		
		// TODO Auto-generated method stub
		return rsTray;
	}

	
	
	
}