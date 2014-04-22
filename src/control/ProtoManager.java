package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import model.Game;
import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Field;
import model.mapitem.Map;
import model.mapitem.Road;
import model.mapitem.Tile;

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
				try {
					pw = new PrintWriter(new File("log.txt"));
					pw.println(printableDoc);
					System.out.println("Writed to log.txt default file, Please insert saveGame code with appropriate parameters to save in another file");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				  
				    	RuneType type;
				    	
				    	if (codes[3].equals("dwarfRune")) {
				    		type = RuneType.Dwarf;
				    	} else if (codes[3].equals("elfRune")) {
				    		type = RuneType.Elf;
				    	} else if (codes[3].equals("hobbitRune")) {
				    		type = RuneType.Hobbit;
				    	} else if (codes[3].equals("manRune")) {
				    		type = RuneType.Man;
				    	} else if (codes[3].equals("reloadRune")) {
				    		type = RuneType.Reload;
				    	} else {
				    		type = RuneType.Range;
				    	}
				    	
				    	g.putRune(Integer.parseInt(codes[1]),Integer.parseInt(codes[2]),type);
				    	
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
					}
					
				}
				else if(codes[0].equals("saveGame"))
				{
					listTowers();
					listSwamps();
					listUnits();
				}
				else if(codes[0].equals("tick"))
				{
					if(codes.length!= 2)
						ProtoManager.Problem();
				    else
				    {
				        for(ticked = 0;ticked < Integer.parseInt(codes[1]); ticked++)
				        {
				        	g.tick();
				        }
				    	
				    	print("Game ticked "+ticked+" times");
				    	
				    }
				}
				else if(codes[0].equals("listUnits"))
				{
					listUnits();
				}
				else if(codes[0].equals("listTowers"))
				{
					listTowers();
				}
				else if(codes[0].equals("listSwamps"))
				{
					listSwamps();
				}
				else if(codes[0].equals("clear"))
				{
					
					g = null;
					print("Game cleared");
					
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
				    		Problem();
				    		
				    	}	
				    }
				}
				else if(codes[0].equals("printMap"))
				{
					Map m = g.getMap();
					Tile[][] tiles = m.Prototype_getTiles();
					for (int i = 0; i < tiles.length; i++) 
					{
						String line = new String();
						for (int j = 0; j < tiles[i].length; j++) 
						{
							Class cl = tiles[i][j].getClass();
							if(cl.getName().equals("Field"))  
							{
								if(((Field) tiles[i][j]).hasTower())
									line = line+"T";
								else
									line = line+"#";
							}
							else if(cl.getName().equals("Road"))
							{
								if(i==0) line = line+"-";
								else
								{
									if(((Road) tiles[i][j]).hasSwamp())
										line = line+"S";
									else
										line = line+" ";
								}
							}
							else if(cl.getName().equals("FinishedRoad"))
							{
								line = line+"A";
							}
					
				        }
						print(line);
				    }
				}	
				else if(codes[0].equals("exit"))
				{
					break;
				}
			}
			
		}
	}
	public static void listTowers()
	{
		Map m = g.getMap();
		Tile[][] tiles = m.Prototype_getTiles();
		
		for (int i = 0; i < tiles.length; i++) 
		{
			for (int j = 0; j < tiles[i].length; j++) 
			{
				Class cl = tiles[i][j].getClass();
				if(cl.getName().equals("Field"))  
				{
					if(((Field) tiles[i][j]).hasTower())
					{
						Tower t = ((Field) tiles[i][j]).Prototype_getTower();
						String line = new String();
						line = t.ProtoType_getName()+" "+Integer.toString(i)+" "+Integer.toString(j)+" "+t.ProtoType_getRune()+" "+
						Integer.toString(t.ProtoType_getRuneDistance())+" "+Integer.toString(t.ProtoType_getCounter())+" ";
						print(line);
					}	
				}
	      }
		
	   }
	}	
	public static void listSwamps()
	{
		Map m = g.getMap();
		Tile[][] tiles = m.Prototype_getTiles();
		
		for (int i = 0; i < tiles.length; i++) 
		{
			for (int j = 0; j < tiles[i].length; j++) 
			{
				Class cl = tiles[i][j].getClass();
				if(cl.getName().equals("Road"))  
				{
					if(((Road) tiles[i][j]).hasSwamp())
					{
						Swamp s = ((Road) tiles[i][j]).Prototype_getSwamp();
						String line = new String();
						line = s.ProtoType_getName()+" "+Integer.toString(i)+" "+Integer.toString(j)+" "+s.ProtoType_getRune();
						print(line);
					}	
				}
	      }
		
	   }
	}
	public static void listUnits()
	{
		Map m = g.getMap();
		Tile[][] tiles = m.Prototype_getTiles();
		
		for (int i = 0; i < tiles.length; i++) 
		{
			for (int j = 0; j < tiles[i].length; j++) 
			{
				Class cl = tiles[i][j].getClass();
				if(cl.getName().equals("Road"))  
				{
					List<EnemyUnit> enemyList = ((Road) tiles[i][j]).ProtoType_getList();
					for(int p = 0; p< enemyList.size(); p++)
					{
						EnemyUnit e = enemyList.get(p);
						Class cls = e.getClass();
						String line = new String();
						line = e.ProtoType_getName()+" "+Integer.toString(i)+" "+Integer.toString(j)+" "
						+cls.getName()+" "+Integer.toString(e.ProtoType_getHealth())+" "+Integer.toString(e.ProtoType_getCounter());
						print(line);
					}	
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

