import java.util.*;

public class RuntimeDemo {

	
	public static void main(String[] args) {
		try {
		List returnedErrorMessages = new ArrayList();
		Runtime rt = Runtime.getRuntime();
		String cmd = "C:\\ExpenseBuilds\\Exp17.4.0.0\\EXP17400_32216_wls1213.ear\\NechoStandardAdaptor.war\\StandardAdaptor\\Visa VCF4\\Visa VCF4.bat";
		Process proc = rt.exec(cmd);
		 StreamGobbler errorGobbler = new
				   StreamGobbler(proc.getErrorStream(),  returnedErrorMessages);

			    List outputList = new ArrayList();
			    // any output?
			    StreamGobbler outputGobbler = new
				   StreamGobbler(proc.getInputStream(), outputList );

			    // Launch the readers
			    errorGobbler.start();
			    outputGobbler.start();
				int exitVal = proc.waitFor();
				boolean success = (exitVal == 0 ? true : false);
				System.out.println("success 1:= " + success);
				if ((!success) || (!returnedErrorMessages.isEmpty()))
				{
					System.out.println("checkMemoryException(returnedErrorMessages)");
					//checkMemoryException(returnedErrorMessages);
					//returnedErrorMessages.add("Adaptor " + processName + " has finished with error : " +  exitVal);
				}	else {
					success = true;
				}
				System.out.println("success 2:= " + success);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
