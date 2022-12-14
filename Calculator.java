import java.util.Scanner;

class Calculator{
    public static void main(String[] args){

        System.out.println("Choose an option: ");
        System.out.println("-----basic operations-----");
        System.out.println("1. Addition (a + b)");
        System.out.println("2. Subtraction (a - b)");
        System.out.println("3. Multiplication (a * b)");
        System.out.println("4. Division (a / b)");

        System.out.println("-----root operations-----");
        System.out.println("5. Square root (sqrt(a))");
        System.out.println("6. Cube root (cbrt(a))");
        System.out.println("7. X root (xrt(a, b))");
        System.out.println("8. Exit");
        System.out.print(">");

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()){
            System.out.println("Invalid option, please try again");
            System.out.print(">");
            sc.next();
        }
        int option = sc.nextInt();
        while (option < 1 || option > 8){
            System.out.println("Invalid option, please try again");
            System.out.print(">");
            option = sc.nextInt();
        }
        if (option == 8){
            System.out.println("Thank you for using this calculator");
            return;
        }

        if (option <= 4){
            double num1 = validateInput("Enter the first number, a: ");
            double num2 = validateInput("Enter the second number, b:");        
            
            switch(option){
                case 1:
                    printout(num1 + num2);
                    break;
                case 2:
                    printout(num1 - num2);
                    break;
                case 3:
                    printout(num1 * num2);
                    break;
                case 4:
                    printout(num1 / num2);
                    break;
                default:
                    System.out.print("Invalid operator");
            }
            System.out.println();
        }
        if (option>4 && option<=7){

            double num1 = validateInput("Enter the number, X: ");
            switch(option){
                case 5:
                    printout(Math.sqrt(num1));
                    break;
                case 6:
                    printout(Math.cbrt(num1));
                    break;
                case 7:
                    double num2 = validateInput("Enter the number you want to root, b: ");
                    printout(String.format("The %.2fth root of %.2f ",num1, num2),xroot(num1, num2));
                    break;
                default:
                    System.out.print("Invalid operator");
            }
            System.out.println();
        }
        return;
    }

    public static double xroot(double x, double y){
        return Math.pow(x, 1/y);
    }

    public static void printout(double x){
        System.out.println("Your final answer is: "+x);
    }

    public static void printout(String message , double x){
        System.out.println(message + x);
    }

    public static double validateInput(String message){
        Scanner sc2 = new Scanner(System.in);
        System.out.print(message);
        while (!sc2.hasNextDouble()){
            System.out.println("Invalid input, please try again");
            System.out.print(message);
            sc2.next();
        }
        return sc2.nextDouble();
    }
}