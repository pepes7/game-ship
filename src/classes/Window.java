package classes;
import java.lang.Thread;

public class Window {
	private String enemy = "<^>";
	private String player =  "('_')";
	private String shoot = " * ";
	private String space = " -|";

	private String[][] tabuleiro = new String[10][10];

	public final static void clearConsole()
	{
		 for (int i = 0; i < 50; ++i)  
		       System.out.println();  
	}
	
	public void populate() {
		for(int i =0; i< 10; i++) {
			for(int j =0; j<10;j++) {
			tabuleiro[i][j] = space;
			}
		}
	}

	public int createPlayer(int x, int y) {
		tabuleiro[y][x] = player;
		return 0;
	}
	public int createEnemy(int x, int y) {
		tabuleiro[y][x] = enemy;
		return 0;
	}
	
	public  void drawBoard () {
		for(int i=0; i<10;i++) {
			for(int j = 0; j<10; j++) {
				System.out.printf("%s",  this.tabuleiro[i][j]);
			}
		System.out.print("\n");
		}
	}
	
	public  void drawCommands () {
		System.out.println("\nComandos");
		System.out.println(
				 "    ^\n"
				+ "   8\n"
				+ "< 4  6>\n"
				+ "   2\n"
				+ "   v \n"
				+ "5 = Ataque\n"
				+ "0 =  Sair do jogo\n\n"
				+ "Comando :");
	}
	
	public void drawShoot(int x, int y) {
		clearConsole();
		for (int i=y-1; i>=0; i--) {
			try {
				tabuleiro[i][x] = shoot;	
				this.drawBoard();
				System.out.println("\n\n");
				//a longer delay only for the last shot
				if(i == 0) {
					Thread.sleep(1000);
				}else {
					Thread.sleep(100);
				}
				
				clearConsole();
			}catch (Exception e){
		      System.out.println(e);
			}
			
		}
	}	
}
