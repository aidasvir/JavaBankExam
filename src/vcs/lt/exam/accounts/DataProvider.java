package vcs.lt.exam.accounts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class DataProvider {
	

	private HashMap<String, Bank> banks = new HashMap<>();
	private String bankCode;
	
	public DataProvider() {
		readFromFile();
	}
	
	public HashMap<String, Bank> getBanks() {
		
		return this.banks;
	}
	

	
	
	public void readFromFile() {
		Path failoNuoroda = Paths.get("C:\\Users\\superuser\\Desktop\\VCS JAVA\\Pamoka 04\\JavaBankExam\\src\\vcs\\lt\\exam\\files\\banks.txt");
		
		
		try(Stream<String> lines = Files.lines(failoNuoroda)) {
			lines.forEach(line -> extractInfo(line));
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}	
		
	public void extractInfo (String line) {
			
			if (line.isEmpty() || line == null) {
				return;
			} 
			
			String[] lineParts = line.split(":");
			
			String name = lineParts[0];
			String address = lineParts[1];
			String bicCode = lineParts[2];
			String lastDigits = bicCode.substring(bicCode.length() - 5, bicCode.length());
			String locale = bicCode.substring(4, 6);
			String bankCode = locale.concat(lastDigits);
			
			
			Bank bank = new Bank(locale, bicCode, name, address);
			banks.put(bankCode, bank);
					
					
		}
		
}
	
	
	

