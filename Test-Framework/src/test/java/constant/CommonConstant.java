package constant;

import java.io.File;

public interface CommonConstant {

	public String Chrome = "Chrome";
	public String Firefox = "Firefox";
	public String Edge = "Edge";
	public String Safari = "Safari";

	public String Linux = "Linux";
	public String MAC = "MAC";
	public String Windows = "Windows";

	public String Local = "Local";
	public String Remote = "Remote";

	public String DownloadFilesFolderPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "java" + File.separator + "resources" + File.separator + "downloadFiles";
}