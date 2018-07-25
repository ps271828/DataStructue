package firstWeek;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.spec.KeySpec;

import org.bouncycastle.util.encoders.Hex;

/**
 * fun：使用md5校验下载的mysql文件是否完整
 * @author panshuang
 *
 */
public class CheckFile {

	/**
	 * mysql压缩文件读取效率太低
	 * @throws Exception
	 */
	public static void testMySql() throws Exception {
		String mySqlPath = "C:\\Users\\panshuang\\Downloads\\mysql-installer-web-community-8.0.11.0.msi";
		
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File(mySqlPath)));
		
		DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
		
		byte[] buffer = new byte[1024*1024*1024*5];
		
	//	System.err.println(buffer.length);
		
		int length = 1024;
		
		int read = dis.read(buffer, 0, length);
		
		while(read > -1) {
			read = dis.read(buffer, 0, length);  //坑
		//	System.out.println(read);
		}
		
		dis.close();
		
		MessageDigest md = dis.getMessageDigest();
		
		byte[] code = md.digest();
		
		String result = Hex.toHexString(code);
		
		System.out.println(result);
		
	}
	
	public static void testSignature() {
		//mysql-5.7.22-winx64.zip.asc
	///	KeySpec keySpec = 
	}
	
	public static void main(String[] args) {
		try {
			testMySql();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
