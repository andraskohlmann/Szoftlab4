package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

import model.Game;

public class ProtoManager {
	
	private static boolean outputStd = true;
	private static PrintWriter pw = null;

	public static RandomStates randomSplitting = RandomStates.off;
	public static RandomStates randomRouting = RandomStates.off;
	public static RandomStates randomFog = RandomStates.off;
	public static int ticked = 0;

	public static String mapName = new String();
	
	private static Game g = new Game();
	
	
	public static void main(String[] args) 
	{
       ProtoManager.codeTranslate();
	}
	
	
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
	public static void Problem()
	{
	  System.out.println("Some of the parameters, or the codes were inserted incorrectly");
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
				   if(codes.length!= 2)
						ProtoManager.Problem();
				   else
				   {
						
					
					   if(codes[1].equals("std")) 
					   {
						 ProtoManager.print("Output to standard output");
						 ProtoManager.outputStd = true;
					   }
					   else if(codes[1].equals("file"))
					   {
						   ProtoManager.outputStd = false;
						   ProtoManager.print("Output to file");
					   }	
					   		else ProtoManager.Problem();
				   }
				} 
				else if(codes[0].equals("loadMap"))
				{
					if(codes.length!= 2)
						ProtoManager.Problem();
				    else
				    {
				        mapName = codes[1];
				    	g.loadMap(codes[1]);
				    	
				    }
				}
				else if(codes[0].equals("putTower"))
				{
					if(codes.length!= 3)
						ProtoManager.Problem();
				    else
				    {
				    	g.putTower(Integer.parseInt(codes[1]),Integer.parseInt(codes[2]));
				    	
				    }
				}
				else if(codes[0].equals("putRune"))
				{
					if(codes.length!= 4)
						ProtoManager.Problem();
				    else
				    {
				  
				    	g.putRune(Integer.parseInt(codes[1]),Integer.parseInt(codes[2]),codes[3]);
				    	
				    }
				}
				else if(codes[0].equals("putSwamp"))
				{
					if(codes.length!= 3)
						ProtoManager.Problem();
				    else
				    {
				  
				    	g.putSwamp(Integer.parseInt(codes[1]),Integer.parseInt(codes[2]));
				    	
				    }
					
				}
				else if(codes[0].equals("gameInfo"))
				{
					print("Map name: "+mapName+"\n");
					print("Life: "+g.getLife()+"\n");
					print("Magitzka: "+g.getMagitzka()+"\n");
					print("Ticked: "+ticked+"\n");
					
					switch (randomFog)
					{
						case on: print("Random mode fog: on"); break;
						case off: print("Random mode fog: off"); break;
						case random: print("Random mode fog: random"); break;
					}
					
					switch (randomSplitting)
					{
						case on: print("Random mode splitting: on"); break;
						case off: print("Random mode splitting: off"); break;
						case random: print("Random mode splitting: random"); break;
					}
				
					switch (randomRouting)
					{
						case on: print("Random mode routing: on"); break;
						case off: print("Random mode routing: off"); break;
						case random: print("Random mode routing: random"); break;
					}
					
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

					if(codes.length!= 2)
						ProtoManager.Problem();
				    else
				    {
				    	if(codes[1].equals("fog"))
				    	{
				    		randomFog = RandomStates.on;
				    		print("Random mode fog: on");
				    		
				    	}
				    	if(codes[1].equals("splitting"))
				    	{
				    		randomSplitting = RandomStates.on;
				    		print("Random mode splitting: on");
				    		
				    	}
				    	if(codes[1].equals("routing"))
				    	{
				    		randomRouting = RandomStates.on;
				    		print("Random mode routing: on");
				    		
				    	}	
				    }
				}
				else if(codes[0].equals("putFog"))
				{
					if(codes.length!= 3)
						ProtoManager.Problem();
				    else
				    {
				    	g.putFog(Integer.parseInt(codes[1]),Integer.parseInt(codes[2]));
				    	
				    }
				}
				else if(codes[0].equals("turnRndOff"))
				{
					if(codes.length!= 2)
						ProtoManager.Problem();
				    else
				    {
				    	if(codes[1].equals("fog"))
				    	{
				    		randomFog = RandomStates.off;
				    		print("Random mode fog: off");
				    		
				    	}
				    	if(codes[1].equals("splitting"))
				    	{
				    		randomSplitting = RandomStates.off;
				    		print("Random mode splitting: off");
				    		
				    	}
				    	if(codes[1].equals("routing"))
				    	{
				    		randomRouting = RandomStates.off;
				    		print("Random mode routing: off");
				    		
				    	}	
				    }
				}
				else if(codes[0].equals("turnRndRnd"))
				{
					if(codes.length!= 2)
						ProtoManager.Problem();
				    else
				    {
				    	if(codes[1].equals("fog"))
				    	{
				    		randomFog = RandomStates.random;
				    		print("Random mode fog: random");
				    		
				    	}
				    	if(codes[1].equals("splitting"))
				    	{
				    		randomSplitting = RandomStates.random;
				    		print("Random mode splitting: random");
				    		
				    	}
				    	if(codes[1].equals("routing"))
				    	{
				    		randomRouting = RandomStates.random;
				    		print("Random mode routing: random");
				    		
				    	}	
				    }
				}
				else if(codes[0].equals("printMap"))
				{
					
				}
				else if(codes[0].equals("exit"))
				{
					break;
				}
			}
			
		}
	}
	public static int randomInt(int max)
	{
		Random r = new Random();
		return r.nextInt(max);
		
	}
	public static boolean randomBoolean(int percentage)
	{
		Random r = new Random();
		int number = r.nextInt(100);
		if (number<50) return true;
		else return false;
	}
	
	
	
}

