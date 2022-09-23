package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Tree;

class realTreeTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File file = new File("objects/dd4840f48a74c1f97437b515101c66834b59b1be");
		file.delete();
	}

	@Test
	void test() throws FileNotFoundException {
		ArrayList <String> listy = new ArrayList<String>();
		listy.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f");
		listy.add("blob : 01d82591292494afd1602d175e165f94992f6f5f");
		listy.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83");
		listy.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b");
		listy.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976");
		File file = new File("objects/dd4840f48a74c1f97437b515101c66834b59b1be");
		Tree tree = new Tree(listy);
		tree.createIndexFile();
		//assertTrue(file.exists());
		Scanner s = new Scanner(file);
		assertTrue(s.nextLine().equals("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f"));
		assertTrue(s.nextLine().equals("blob : 01d82591292494afd1602d175e165f94992f6f5f"));
		assertTrue(s.nextLine().equals("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83"));
		assertTrue(s.nextLine().equals("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b"));
		assertTrue(s.nextLine().equals("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976"));
	}

}
