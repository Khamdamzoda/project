package com.delivery.checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class getResult {


public String number ; 
public String filename; 
private String numbertitle ="рақам"; 
private String filedescription = "номи файл" ; 

//@Value("${directory.location}")	
//private String directory;

public String getFiledescription() {
	return filedescription;
}
public void setFiledescription(String filedescription) {
	this.filedescription = filedescription;
}
public String getNumbertitle() {
	return numbertitle;
}
public void setNumbertitle(String numbertitle) {
	this.numbertitle = numbertitle;
}

public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}


public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public getResult() {
	super();
}


public void search(String number) throws IOException {
	
Path path = Paths.get("C:\\Users\\DELIVERY");

Scanner scan  ; 

File file;


try (Stream<Path> walk=Files.walk(path.toAbsolutePath())){
	
List<File> result = walk.filter(Files::isRegularFile).map(x->x.toFile()).collect(Collectors.toList());
	

for(int i = 0; i<result.size(); i++) {
	
	file = (File)result.get(i) ; 
	
	scan = new Scanner (new BufferedReader(new FileReader(file ))); 
	while (scan.hasNextLine()){
	
	String fileN  = scan.findInLine(number);
    this.setNumber(fileN);
     
    String fName= file.getName(); 
    
    
    
    
    if(this.getNumber()!=null&&number.length()==9) {
    	
    	this.setFilename(fName);
    	
    } else if (this.getFilename()==null) {
    	
    	this.setFilename("рақам" + "\t" + "вуҷуд надорад");
    }
    
    scan.nextLine(); 
      
    
}	
}
  

}catch(Exception ex) {
	ex.printStackTrace();
}
		
	}


	
	
}

