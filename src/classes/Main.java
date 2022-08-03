package classes;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Window gameWindow = new Window();
		Player player = new Player();
		Enemy alien = new Enemy();
		
		
		gameWindow.populate();
		gameWindow.criaPlayer(5, 8);
		 
		player.setHealth(5);
		player.setX(5);
		player.setY(8);
		
		alien.setHealth(100);
		alien.setX(alien.coordenadaGerador(9, 0));
		alien.setY(alien.coordenadaGerador(9, 0));
		
		gameWindow.criaEnemy(alien.getX(), alien.getY());

 		Scanner sc = new Scanner(System.in);
		int userInput = 1;
		//game logic;
		int turnos = 1;
		while(userInput != 0) {
			System.out.println("\n\n\nPlayer <3: [" + player.getHealth() + "] | Enemy HP:[" + alien.getHealth() + "]");
			gameWindow.imprimeTabuleiro();
			System.out.println(//controls
					"\nTurno " + turnos
					+ " \n   ^\n"
					+ "   8\n"
					
					+ "< 4  6>\n"
					+ "   2\n"
					+ "   v \n"
					+ "5 = ataque\n"
					+ "[0 para Sair]Comando >:");
			userInput = sc.nextInt();
		 
			if(userInput == 6 && player.getX()  < 9) {
				player.goRight();;  //new object.x
			}
			else if(userInput == 4 && player.getX() > 0){
				player.goLeft();
			}else if (userInput == 8 && player.getY() > 0) {
				player.goUp();
			}else if(userInput == 2 && player.getY() < 9) {
				player.goDown();
			}else if(userInput == 5) {
				gameWindow.imprimirTiro(player.getX(), player.getY());
				gameWindow.imprimeTabuleiro();
				if(player.getX() ==alien.getX() && player.getY() > alien.getY()) {
					alien.setHealth(alien.getHealth() - 10);  //enemy gets damaged
				}
			}
			System.out.println("Fim do turno " + turnos);
			turnos++;
			//movements do alien
			if(alien.getX() == 9) {
				alien.setX(alien.getX() - 1);
			}else if(alien.getX() == 0) {
				alien.setX(alien.getX() + 1);
			}else if(alien.getY() == 0) {
				alien.setY(alien.getY() + 1);
			}else if(alien.getY() == 9) {
				alien.setY(alien.getY() - 1);
			}else {
				alien.setX(alien.getX() + alien.movimentoGerador());
				alien.setY(alien.getY() + alien.movimentoGerador());
			}
			
			// player receives damage
			if(alien.getX() == player.getX() && alien.getY()==player.getY()) { //position do alien == player position => reseted positions && -1 life
				player.setHealth(player.getHealth() - 1);
				player.setX(5); player.setY(8);
				alien.setX(alien.coordenadaGerador(9, 0));
			}
			
			gameWindow.populate();//cleans the board
			gameWindow.criaEnemy(alien.getX(),alien.getY());   // < e V prints the board with the new positions;
			gameWindow.criaPlayer(player.getX(), player.getY());
			
			if (alien.getHealth()==0) {
				System.out.println("\n\n\nVictory!"
						+ "\nTurns: " + turnos 
						+ "| <3:["+player.getHealth()+"]");
				System.exit(0);
			}else if(player.getHealth()==0) {
				System.out.println("\n\n\nDefeat"
						+ "Turns: " + turnos);
				System.exit(0);
			}
		}
		
		
	}

}
