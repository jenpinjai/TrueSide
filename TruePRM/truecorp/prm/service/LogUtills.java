package truecorp.prm.service;

import java.sql.Connection;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import truecorp.prm.resource.setEnv;


public class LogUtills {
	public static <T> Logger getLogger(Class<T> clazz) {
		Connection conn = null;
		try {
			
			// creates pattern layout
			PatternLayout layout = new PatternLayout();
			// on windows
//			String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
			// on linux
			String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m\r\n";
			layout.setConversionPattern(conversionPattern);
			
			// creates daily rolling file appender
			DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
			rollingAppender.setFile(setEnv.homePath + "/log/" + clazz.getSimpleName() + ".log");
			rollingAppender.setDatePattern("'.'yyyy-MM-dd'.log'");
			rollingAppender.setLayout(layout);
			rollingAppender.activateOptions();
			// configures the root logger
			Logger rootLogger = Logger.getRootLogger();
			

			 rootLogger.setLevel(Level.ALL);
			rootLogger.addAppender(rollingAppender);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		Logger log = Logger.getLogger(clazz);
		return log;
	}
	
	public static <T> Logger getLogger(Class<T> clazz , String cycleCode) {
		try {
			
			// creates pattern layout
			PatternLayout layout = new PatternLayout();
			// on windows
//			String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n";
			// on linux
			String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m\r\n";
			layout.setConversionPattern(conversionPattern);
			
			// creates daily rolling file appender
			DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
			rollingAppender.setFile(setEnv.homePath + "/log/" + clazz.getSimpleName() +"_"+cycleCode+ ".log");
			rollingAppender.setDatePattern("'.'yyyy-MM-dd'.log'");
			rollingAppender.setLayout(layout);
			rollingAppender.activateOptions();
			// configures the root logger
			Logger rootLogger = Logger.getRootLogger();
			
			rootLogger.setLevel(Level.ALL);
			rootLogger.addAppender(rollingAppender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Logger log = Logger.getLogger(clazz);
		return log;
	}

}
