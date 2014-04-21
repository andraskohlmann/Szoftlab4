package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProtoManager {
	
	private static boolean outputStd = true;
	private static PrintWriter pw;

	public static void print(String printableDoc)
	{
		if(outputStd)
		 {
			System.out.println(printableDoc);
		 }
		else
		{
			if(pw != null)
			{
				pw.println(printableDoc);
			}
			else
			{
				System.out.println("Cannot write to file, because no outputfile was added. Please insert saveGame code with appropriate parameters");
			}
		}
	}
	
	public static void codeTranslate()
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String inputCode = new String();
			try {
				inputCode = bf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(inputCode == null) break;
			else
			{
				String[] codes = inputCode.split(" ");
				if(codes[0].equals("switchOutput")) 
				{
					
				}
				else if(codes[0].equals("loadMap"))
				{
					
				}
				else if(codes[0].equals("putTower"))
				{
					
				}
				else if(codes[0].equals("putRune"))
				{
					
				}
				else if(codes[0].equals("putSwamp"))
				{
					
				}
				else if(codes[0].equals("gameInfo"))
				{
					
				}
				else if(codes[0].equals("saveGame"))
				{
					
				}
				else if(codes[0].equals("tick"))
				{
					
				}
				else if(codes[0].equals("listUnits"))
				{
					
				}
				else if(codes[0].equals("listTowers"))
				{
					
				}
				else if(codes[0].equals("listSwamps"))
				{
					
				}
				else if(codes[0].equals("clear"))
				{
					
				}
				else if(codes[0].equals("turnRndOn"))
				{
					
				}
				else if(codes[0].equals("putFog"))
				{
					
				}
				else if(codes[0].equals("turnRndOff"))
				{
					
				}
				else if(codes[0].equals("turnRndRnd"))
				{
					
				}
				else if(codes[0].equals("printMap"))
				{
					
				}
			}
			
		}
	}
	
	
}

