package mig.process;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

import mig.connnection.Connection11g;
import mig.connnection.Connection8i;
import mig.connnection.runCommand;
import mig.oracle8i.ProcessSQL;
import mig.oracle8i.Sql11g;
import mig.oracle8i.Sql8i;
import mig.resources.Constants;

public class CreateAccountType {
	// CreateAccountType_sh /home/appadm/var/tea/MigData/RC_RATE/input/ 01
	public static void main(String[] args) throws Exception {
		String pathFileInput = args[0];
		String pidFile = args[1];

		String runOutput = runCommand.executeCommand("touch " + Constants.accountTypePid + "CreateAccountType_" + pidFile + ".pid");
		System.out.println(runOutput);

		Path pathPid = Paths.get(Constants.accountTypePid + "CreateAccountType_" + pidFile + ".pid");

		Connection conn8i = null;
		conn8i = Connection8i.getConnection();

		Connection conn11g = null;
		conn11g = Connection11g.getConnection();

		// while (Files.exists(pathPid)) {

		if (Files.notExists(pathPid)) {
			return;
		}
		try {
			System.out.println("File " + pathFileInput + " Process ");
			int staturProcess = 0;
			int recordInsert = 0;
			// System.out.println(accountIdList);
			String sql = ProcessSQL.readSql(Constants.accountTypeXLS);
			int count = Sql8i.wirteValueSql(conn8i, sql, pathFileInput + "AccountType.txt");

			sql = ProcessSQL.readSqlInsert(Constants.accountTypeXLS);
			recordInsert = Sql11g.insertFromFile(conn11g, sql, pathFileInput + "AccountType.txt");
			if (recordInsert != count) {
				staturProcess = -1;
			}

			if (staturProcess == 0) {
				runOutput = runCommand
						.executeCommand("mv " + pathFileInput + "AccountType.txt" + " " + Constants.accountTypeBackUp);
				System.out.println(runOutput);
			}

		} catch (Exception e) {
			throw e;
		}

		// }//while
		try {
			conn8i.close();
			conn11g.close();
		} catch (Exception e2) {
		}
		System.out.println("End");
	}
}
