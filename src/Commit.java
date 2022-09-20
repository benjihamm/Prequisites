import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Commit {
	File p = null;
	File c = null;
	String pointToTree;
	String date;
	String name;
	String summary;
	File pTree;
	public Commit(String parent, String child, String pointTo, String author, String description) {
		pointToTree = pointTo;
		if(parent != null)
			p = new File("objects", parent);
		if(child != null)
			c = new File("objects", child);
		summary = description;
		name = author;
		if(!(pointToTree == null)) {
			pTree = new File("objects", pointToTree);
		}
	}
	public String getPTree() {
		return pTree.toString();
	}
	public boolean pTreeExists() {
		return pTree.exists();
	}
	public static String encrypt(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger num = new BigInteger(1, messageDigest);
			String hex = num.toString(16);
			while (hex.length() < 40) {
				hex = "0" + hex;
			}
			return hex;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	public String generateSHA1() {
		return encrypt(summary + getDate() + name + p);
	}
	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		date = dtf.format(now);  
		return date;
	}
	public void writeFile() throws FileNotFoundException {
		File f = new File("objects", generateSHA1());
		PrintWriter pw = new PrintWriter(f);
		pw.println(pTree.toString());
		if(p != null)
			pw.println(p.toString());
		else
			pw.println();
		if(c != null)
			pw.println(c.toString());
		else
			pw.println();
		pw.println(name);
		pw.println(getDate());
		pw.println(summary);
		pw.close();
	}
	
	
}
