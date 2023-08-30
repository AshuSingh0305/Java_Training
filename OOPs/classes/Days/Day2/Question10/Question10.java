package classes.Days.Day2.Question10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Scanner;

import interfaces.Start;

public class Question10 implements Start {

	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		String textToWrite = scanner.nextLine();
		File file = new File("C://Users//ashu.singh//eclipse-workspace//Exercise//classes//Days//Day2//Question10//Output.txt");
		writeToFile(file, textToWrite);
		
		String readText = readFromFile(file);
		System.out.println("Read Text: "+ readText);
		scanner.close();
	}
	public void writeToFile(File filename, String text) {
		try {
			long currentTime = System.currentTimeMillis();
			Date currentDate = new Date(currentTime);
			FileWriter filewriter = new FileWriter(filename, true);
			filewriter.write("\n \n"+currentDate+"\n"+text);
			System.out.println("text written to "+ filename);
			filewriter.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static String readFromFile(File filename) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(filename));
			String line;
			while((line = bufferReader.readLine())!=null) {
				stringBuilder.append(line);
			}
			bufferReader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

}
