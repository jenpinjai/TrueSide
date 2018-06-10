package truecorp.prm.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class ReadSqlUtils {

	private static final String strNull = "'null'";
	
	

	/**
	 * Description : Read SQL command from .sql and prepared sql statement with parameters
	 * @param schemas
	 * @param path
	 * @param key
	 * @param params
	 * @return string sql
	 */
	public static String getSQLString(String path,String key, Object...params){
		String sql = "";
		try {
			if(key.indexOf("insert") != -1){
				sql = getSQL(path, key);
				sql =  String.format(sql,params);
				sql = sql.replaceAll(strNull, "null");
				sql = sql.replaceAll(strNull.toUpperCase(), "null");
			}else{
				sql =  getSQL(path, key, params);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sql;
	}
	
	/**
	 * Description : SQL with Null value.(such as ADD,EDIT)
	 * @param path sql file
	 * @param key
	 * @return string sql
	 */
	protected static String getSQL(String path,String key){
		StringBuilder sql = new StringBuilder();
		try (InputStream is = ReadSqlUtils.class.getResourceAsStream(path); 
				BufferedReader br = new BufferedReader(new InputStreamReader(is,Constants.UTF_8));){
		    
			String strLine;
			boolean read = false;
			while ((strLine = br.readLine()) != null) {

				if(strLine.trim().replace("{", "").trim().equals(key)){
					read = true;
					continue;
				}

				if(read){
					if(!strLine.trim().equals("}")){
						if(strLine.trim().length()>0){
							sql.append(strLine.trim()+" \n");
						}
					}else{
						break;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return sql.toString();
	}
	
	/**
	 * Description : SQL without Null value.
	 * @param path sql file
	 * @param key
	 * @param params
	 * @return string sql
	 */
	protected static String getSQL(String path,String key, Object...params ){
		StringBuilder sql = new StringBuilder();
		try (InputStream is = ReadSqlUtils.class.getResourceAsStream(path); 
				BufferedReader br = new BufferedReader(new InputStreamReader(is,Constants.UTF_8));){
			String strLine;
			boolean read = false;
			int i = 0;

			while ((strLine = br.readLine()) != null) {
				if(strLine.trim().replace("{", "").trim().equals(key)){
					read = true;
					continue;
				}

				if(read){
					if(!strLine.trim().equals("}")){

						if(strLine.indexOf("%s")!= -1){
							if(params!=null){
								if(params[i]==null){
									i++;
									continue;
								}else{
									sql.append(strLine.trim().replaceAll("%s", Matcher.quoteReplacement(params[i].toString())) + "\n");
								}
							}

							i++;
						}else{
							if(strLine.trim().length()>0){
								sql.append(strLine.trim()+" \n");
							}
						}

					}else{
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return sql.toString();
	}
}
