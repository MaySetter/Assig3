package assig3_2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        GamePlay game = new GamePlay(); // creates new game
        Gamer player1 = new Gamer(game);
        Gamer player2 = new Gamer(game);

        player1.start();
        player2.start();

        player1.join();
        player2.join();

        if (player1.getScore() > player2.getScore())
            System.out.println("player 1 wins");
        else if (player1.getScore() < player2.getScore())
            System.out.println("player 2 wins");
        else
            System.out.println("tie");

    }
}