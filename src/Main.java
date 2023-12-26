import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        boolean finish = false;
        boolean answer;
        String[] split;
        String operator;
        String digit_letter;
        String operation;
        Scanner sc = new Scanner(System.in);

        while(finish == false) {

            System.out.println("Escribe una operación de 2 parámetros separando por espacios");
            operation = sc.nextLine();
            System.out.println("La operación que me solicitas que calcule es " + operation + ", y el resultado es:");

            split = operation.split(" ");

            try {
                double number1 = Double.parseDouble(split[0]);
                double number2 = Double.parseDouble(split[2]);
                operator = split[1];
                switch (operator) {
                    case "+":
                        System.out.println(number1 + number2);
                        break;
                    case "/":
                        System.out.println(number1 / number2);
                        break;
                    case "*":
                        System.out.println(number1 * number2);
                        break;
                    case "-":
                        System.out.println(number1 - number2);
                        break;
                    default:
                        System.out.println("Datos no introducidos correctamente");

                }
                answer = false;
                while (answer==false){
                    System.out.println("Presiona un número para continuar");
                    System.out.println("Presiona una letra para finalizar");
                    digit_letter= sc.nextLine();
                    if (digit_letter.length()==1 && Character.isDigit(digit_letter.charAt(0))){
                        System.out.println("Has presionado un número");
                        answer = true;
                    }else if (digit_letter.length()==1 && Character.isLetter(digit_letter.charAt(0))){
                        System.out.println("Has presionado una letra. Cerrando programa...");
                        finish = true;
                        answer = true;
                    }else{
                        System.out.println("Datos no introducidos correctamente");
                    }

                }
            } catch (Exception e) {
                System.out.println("Datos no introducidos correctamente");
            }

        }
    }
}
