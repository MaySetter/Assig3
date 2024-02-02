//Nir Hazan 316009489 , May Seter 312123037
package assig3_2;
/**
 * Main class to run the game.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        GamePlay game = new GamePlay(); // creates new game
        Gamer player1 = new Gamer(game);
        Gamer player2 = new Gamer(game); // creates two player.
        //start
        player1.start();
        player2.start();
        game.getJudge().start();  // start Threads .
        //join
        player1.join();
        player2.join();
        game.getJudge().join();
        //print winner or tie.
        if (player1.getScore() > player2.getScore()) // end of the game check who wins or tie.
            System.out.println("player 1 wins");
        else if (player1.getScore() < player2.getScore())
            System.out.println("player 2 wins");
        else
            System.out.println("tie");
    }
}
