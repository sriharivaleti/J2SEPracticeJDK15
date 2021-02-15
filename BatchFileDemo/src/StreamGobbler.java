
import java.util.*;
import java.io.*;
public class StreamGobbler extends Thread
{
	InputStream is;
	List   streamList;
    
    /**
     * 
     * @param is
     * @param errorList
     */
	public StreamGobbler(InputStream is, List  errorList)
	{
		this.is = is;
		this.streamList = errorList;
	}
    
	
    /**
     * 
     */
	public void run()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line=null;
			while ( (line = br.readLine()) != null)
			{
				getStreamList().add(line);
			}    
	     } 
		 catch (IOException ioe)
		 {
			 getStreamList().add(ioe.getMessage());  
		 }
	}

	/**
	 * @return the streamList
	 */
	public List getStreamList() {
		return streamList;
	}


	/**
	 * @param streamList the streamList to set
	 */
	public void setStreamList(List streamList) {
		this.streamList = streamList;
	}
}