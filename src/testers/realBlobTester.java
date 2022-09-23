package testers;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Blob;

class realBlobTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File testFile = new File("tester.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws NoSuchAlgorithmException, IOException {
		//Blob test = new Blob("tst");
		Blob test2 = new Blob("tester.txt");
	    //System.out.println(test.method("tester.txt"));
		System.out.println(System.getProperty("user.dir"));
	}

}
