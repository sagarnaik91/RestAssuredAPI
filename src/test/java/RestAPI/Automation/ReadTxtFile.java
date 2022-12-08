package RestAPI.Automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

public class ReadTxtFile {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\IBMADMIN\\Documents\\mentalTest.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();

	}

}
