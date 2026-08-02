import java.util.Scanner;
public class Arena {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int player = 100;

        int[] enemiesHP = {50,50,50};

        System.out.println("Welcome to the Arena!"+"\nplayer HP: "+ player +"\nEnemies in the Arena: "+ enemiesHP.length);

        int currentEnemy =0;

        while(player > 0 && currentEnemy < enemiesHP.length){
            System.out.println("\n1- Sword attack \n2- Using treatment");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if(choice==1){
                enemiesHP[currentEnemy] = attackSword(enemiesHP[currentEnemy]);
                System.out.println("Enemies Health: "+enemiesHP[currentEnemy]);
            }
            else if(choice==2){
                player = applyTreatment(player);
                System.out.println("Player Health: "+player);
            }

            else{
                System.out.println("Invalid choice");
            }

            if (enemiesHP[currentEnemy] <= 0){
                System.out.println("You killed enemy! Advance to the next one.");
                currentEnemy++;
            }

            else{
                player -= 30;
                if(player < 0){
                    player = 0;
                    System.out.println("YOU DIED!");
                    break;
                }
                System.out.println("You take damage! Your health: " +player);
            }
            if (currentEnemy >= enemiesHP.length && player > 0){
                System.out.println("YOU WIN!");
            }
        }
    }
    public static int applyTreatment(int currentHP){
        int newHP = currentHP+40;
        if(newHP>100){
            return  100;
        }
        return  newHP;
    }

    public static int attackSword(int damageSword){
        return damageSword-25;
    }
}