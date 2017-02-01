package mig.process;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

import mig.connnection.Connection11g;
import mig.connnection.runCommand;
import mig.oracle8i.Sql11g;
import mig.resources.Constants;

public class ExecuteCommand {
	// ExecuteCommand_sh /home/appadm/var/tea/MigData/Generate/Filename.txt 01
	public static void main(String[] args) throws Exception {
		String pathFileInput = args[0];
		String pidFile = args[1];

//		String runOutput = runCommand
//				.executeCommand("touch " + Constants.featurePid + "ExecuteCommand_" + pidFile + ".pid");
//		System.out.println(runOutput);
//
//		Path pathPid = Paths.get(Constants.featurePid + "ExecuteCommand_" + pidFile + ".pid");

		Connection conn11g = null;
		conn11g = Connection11g.getConnection();

//		if (Files.notExists(pathPid)) {
//			return;
//		}
		try {
			System.out.println("File " + pathFileInput + " Process ");

			Sql11g.executeCommand(conn11g, pathFileInput);
		
		} catch (Exception e) {
			throw e;
		}

		try {
			conn11g.close();
		} catch (Exception e2) {
		}
		System.out.println("End");
	}
}