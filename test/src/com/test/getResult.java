package com.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class getResult {


public getResult() {
   
}

public static void main(String [] args) throws IOException {
	
	
	search() ; 
}


public static void search() throws IOException {
	
	
Path path = Paths.get("C:\\Users\\Ps\\Desktop\\project-deliv\\testDirectory\\");

Scanner scan  ; 

File file; 

String filename=""; 
try (Stream<Path> walk=Files.walk(path.toAbsolutePath())){
	
List<File> result = walk.filter(Files::isRegularFile).map(x->x.toFile()).collect(Collectors.toList());
	

for(int i = 0; i<result.size(); i++) {
	
	file = (File)result.get(i) ; 

	scan = new Scanner (new BufferedReader(new FileReader(file ))); 
	while (scan.hasNextLine()){
    filename = scan.findInLine(Pattern.quote("A55555555"));

    if(filename!=null) {
    	System.out.println("found" + "\t"+ filename + "at\t" + file.getName());
    }

	
	        scan.nextLine(); 
		
}
	

}


}catch(Exception ex) {
	ex.printStackTrace();
}
		
	}
	
	
}






/*for (int i=0; i<filesList.size(); i++) {
	file = (File) filesList.get(i) ; 
	
	
	
	
	scan = new Scanner (new BufferedReader(new FileReader(file ))); 
	while (scan.hasNextLine()){
    String str = scan.findInLine("A020202");



if(str!=null) {
	System.out.println("found" + "\t"+ str + "at\t" + file.getName());
    }
    	
    
    scan.nextLine(); 
           
    }
}	*/
