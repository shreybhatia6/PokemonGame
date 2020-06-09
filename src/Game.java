import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        String[] trainerPokemon = {"Bulbasaur", "Charmander", "Squirtle"};
        String starterPokemon = "";
        String enemyPokemon = "";
        String[] enemies = {"Abra", "Aron", "Pikachu", "Mankey", "Oddish"};
        String determinePokemon ="";
        String determineAction = "";

        int pokemonHP = 100;
        int enemyHP = 50;
        int maxPokemonAttackDamage = 50;
        int maxEnemyAttackDamage = 25;
        int pokemonAttackDamage;
        int enemyAttackDamage;

        boolean running = true;
        boolean validInput = true;
        boolean newPokemon = true;


        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to pokemon!");
        System.out.println("-------------------\n");
        System.out.println("What starter pokemon would you like?\nType 1 for Balbasaur.\nType 2 for Charmander.\nType 3 for Squirtle.");

        while (validInput) {

            determinePokemon = scan.nextLine();

            if (determinePokemon.equals("1")) {
                starterPokemon = trainerPokemon[0];
                validInput = false;
            } else if (determinePokemon.equals("2")) {
                starterPokemon = trainerPokemon[1];
                validInput = false;
            } else if (determinePokemon.equals("3")) {
                starterPokemon = trainerPokemon[2];
                validInput = false;
            } else
                System.out.println("Invalid input. Try again!\n");
        }

        System.out.println("Congratulations! Your starter pokemon is " + starterPokemon + "!");
        System.out.println("-------------------\n");

        GAME:
        while (newPokemon) {
            enemyPokemon = enemies[rand.nextInt(5)];
            System.out.println("An enemy " + enemyPokemon + " appeared!\n ");

            DECISIONS:
            while (running) {


                System.out.println(starterPokemon + "'s HP: " + pokemonHP);
                System.out.println(enemyPokemon + "'s HP: " + enemyHP);
                System.out.println("-------------------\n");
                System.out.println("What would you like to do?\nType 1 to fight.\nType 2 to run away.\nType 3 to return home (exit game).");
                validInput = true;

                while (validInput) {

                    determineAction = scan.nextLine();

                     if (determineAction.equals("1")) {

                         enemyAttackDamage = rand.nextInt(maxEnemyAttackDamage);
                         pokemonAttackDamage = rand.nextInt(maxPokemonAttackDamage);

                         System.out.println(starterPokemon + " dealt " + pokemonAttackDamage + " damage on " + enemyPokemon);
                         System.out.println(enemyPokemon + " dealt " + enemyAttackDamage + " damage on " + starterPokemon);

                         pokemonHP -= enemyAttackDamage;
                         enemyHP -= pokemonAttackDamage;

                         if (pokemonHP < 1 && enemyHP < 1) {
                             System.out.println(starterPokemon + " and " + enemyPokemon + " have both died. Thanks for playing!");
                             break GAME;
                         }
                         else if (pokemonHP < 1) {
                             System.out.println(starterPokemon + " died. Thanks for playing!");
                             break GAME;

                         } else if (enemyHP < 1) {
                             System.out.println("Congratulations! " + enemyPokemon + " died!");
                             System.out.println("");
                             enemyHP = 50;
                             continue GAME;

                         }
                         else {
                             System.out.println("");
                             continue DECISIONS;
                         }
                     }


                    if (determineAction.equals("2")) {
                        System.out.println("You ran away from the pokemon...\n");
                        enemyHP = 50;
                        continue GAME;


                    } else if (determinePokemon.equals("3")) {
                        System.out.println("You returned home a hero! Thanks for playing!");
                        break GAME;

                    } else
                        System.out.println("Invalid input. Try again!\n");


                    }

                }

            }
        }

    }

















