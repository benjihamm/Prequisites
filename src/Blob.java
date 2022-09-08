import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Blob {
	private static File end;
	private String filesName;
	public Blob(String origFile) throws IOException {
		File oldFile = new File(System.getProperty("user.dir") + "/" + origFile);
		byte[] input = convertToByte(oldFile.getAbsoluteFile());
		String newFileName = toSHA1(input);
		filesName = newFileName;
		File newFile = new File(System.getProperty("user.dir") + "/objects", newFileName);
		copyFileUsingStream(oldFile, newFile);
	}
	 public static byte[] convertToByte(File file) throws IOException
		    {
		        // Creating an object of FileInputStream to
		        // read from a file
		        FileInputStream fl = new FileInputStream(file);
		  
		        // Now creating byte array of same length as file
		        byte[] arr = new byte[(int)file.length()];
		  
		        // Reading file content to byte array
		        // using standard read() method
		        fl.read(arr);
		  
		        // lastly closing an instance of file input stream
		        // to avoid memory leakage
		        fl.close();
		  
		        // Returning above byte array
		        return arr;
		    }
	public static String toSHA1(byte[] convertme) {
	    MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("SHA-1");
	    }
	    catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } 
	    return new String(md.digest(convertme));
	}
	private static void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	    end = dest;
	}
	public String getSHA1() {
		return filesName;
	}
	public File getFile() {
		return end;
	}
}
