package com.company.lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectpath="E:\\JAVA Full Stack\\Final Project\\CompanyLockersProject\\LockedMe";
	
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner (System.in);
		int ch;
		
		do
		{
		displayMenu();
		System.out.println("Enter your choice");
		ch= Integer.parseInt(obj.nextLine());
		
		switch(ch)
		{
			case 1:getAllFiles();
			break;
			case 2:createFile();
			break;
			case 3:deleteFile();
			break;
			case 4:searchFile();
			break;
			case 5:System.exit(0);
			break;
			default: System.out.println("Invalid Option");
			break;
		}
		
	}
		while (ch>0);
			
	}

	public static void displayMenu()
	{
		System.out.println("*************************************************");
		System.out.println("Welcome to Company Lockers - LockedMe.com");
		System.out.println("Developer Name: Uday Saxena");
		System.out.println("*************************************************");
		System.out.println("\t1. Display all files");
		System.out.println("\t2. Add files to existing directory");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
		System.out.println("*************************************************");
	}
	
	public static void getAllFiles()
	{
		File [] listofFiles = new File (projectpath).listFiles();
		
		//if the folder is empty
		if(listofFiles.length==0)
			System.out.println("No files exists in the directory");
		else
		{
			for (var l:listofFiles)
				System.out.println(l.getName());
		}
	}
	
	public static void createFile()
	{
		try
		{
			Scanner obj = new Scanner (System.in);
			String FileName;
			int linescount;
			
			System.out.println("Enter file name");
			FileName = obj.nextLine();
			System.out.println("Enter how many lines you want to add in a file");
			linescount = Integer.parseInt(obj.nextLine());
			
			FileWriter fw = new FileWriter (projectpath+"\\"+FileName);
			
			for (int i=1;i<=linescount;i++)
			{
				System.out.println("Enter File content line");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("File created successufully");
			
		}
		catch (Exception Ex)
		{
			System.out.println("Some error occured");
		}
	}
	
	public static void deleteFile()
	{
		Scanner obj = new Scanner (System.in);
		try
		{
			String fileName;
			System.out.println("Enter file name to be deleted");
			fileName= obj.nextLine();
			
			File fl = new File (projectpath+"\\"+fileName);
			
			if (fl.exists())
			{
				fl.delete();
				System.out.println("File deleted successfully");
			}
			else
				System.out.println("File do not exist");
			
		}
		catch(Exception Ex)
		{
			System.out.println("Some error occured");
		}
	}
	
	public static void searchFile()
	{
		Scanner obj = new Scanner (System.in);
		try
		{
			String fileName;
			System.out.println("Enter file name to be searched");
			fileName= obj.nextLine();
			
			File fl = new File (projectpath+"\\"+fileName);
			
			if (fl.exists())
			{
				System.out.println("File is available");
			}
			else
				System.out.println("File do not exist");
			
		}
		catch(Exception Ex)
		{
			System.out.println("Some error occured");
		}
	}
	
}
