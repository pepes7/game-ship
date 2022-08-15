package classes;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Player player = new Player();
		player.setHealth(3);
		player.setX(8);
		player.setY(8);
		
		Enemy enemy = new Enemy();
		enemy.setHealth(100);
		enemy.setX(enemy.coordenadaGerador(9, 0));
		enemy.setY(enemy.coordenadaGerador(9, 0));
		
		Window gameWindow = new Window();
		gameWindow.populate();
		gameWindow.createPlayer(3, 7);

		gameWindow.createEnemy(enemy.getX(), enemy.getY());
		
 		Scanner sc = new Scanner(System.in);
		int userInput = 1;
		
		while(userInput != 0) {
			System.out.println("\n\n\nJogador: " + player.getHealth() + " | Inimigo: " + enemy.getHealth() + "%");
			System.out.println("Acerte o inimigo\n");
			gameWindow.drawBoard();
			
			
			gameWindow.drawCommands();
			
			userInput = sc.nextInt();
			switch (userInput) {
			case 6:
				if( player.getX()  < 9) {
					player.goRight();
				}
				break;
			case 4:
				if( player.getX() > 0) {
					player.goLeft();
				}
				break;
			case 8:
				if(player.getY() > 0) {
					player.goUp();
				}
				break;
			case 2:
				if( player.getY() < 9) {
					player.goDown();
				}
				break;
			case 5:
				gameWindow.drawShoot(player.getX(), player.getY());
				//enemy gets damaged
				if(player.getX() == enemy.getX() && player.getY() > enemy.getY()) {
					enemy.setHealth(enemy.getHealth() - 10);  
				}
				break;
			default:
				break;
			}

			
			switch (enemy.getX()) {
			case 9:
				enemy.setX(enemy.getX() - 1);
				break;
			case 0:
				enemy.setX(enemy.getX() + 1);
				break;
			default:
				if(enemy.getY() == 0) {
					enemy.setY(enemy.getY() + 1);
				}else if(enemy.getY() == 9) {
					enemy.setY(enemy.getY() - 1);
				}else {
					enemy.setX(enemy.getX() + enemy.movimentoGerador());
					enemy.setY(enemy.getY() + enemy.movimentoGerador());
				}
				break;
			}
			
			// player receives damage
			if(enemy.getX() == player.getX() && enemy.getY()==player.getY()) { //position do enemy == player position => reseted positions && -1 life
				player.setHealth(player.getHealth() - 1);
				player.setX(5); player.setY(8);
				enemy.setX(enemy.coordenadaGerador(9, 0));
			}

			gameWindow.populate(); 
			gameWindow.createPlayer(player.getX(), player.getY());
			gameWindow.createEnemy(enemy.getX(),enemy.getY());

			if (enemy.getHealth()==0) {
				System.out.println("\n\nVocê derrotou o inimigoo!!!");
				System.exit(0);
			}else if(player.getHealth()==0) {
				System.out.println("\n\nDerrota! Seu inimigo esta com:" + enemy.getHealth());
				System.exit(0);
			}
		}
	}
}
