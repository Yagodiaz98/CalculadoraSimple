import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args){

        boolean finish = false;//Variable que finaliza el programa
        boolean answer; //Variable para saber si continuar haciendo cálculos
        String[] split;
        String operator;
        String digit_letter;
        String operation;
        double calc;
        Scanner sc = new Scanner(System.in);
        boolean validation = false;//Valida si la operacion puede llevarse a cabo

        while(!finish) {

            //Solicitamos parámetros de entrada y separamos por espacios
            System.out.println("Escribe una operación de 2 parámetros separando por espacios");
            operation = sc.nextLine();
            split = operation.split(" ");

            //Validación de los parámetros de entrada
            try {
                if (split.length != 3) {
                    System.out.println("Parece que faltan espacios. Vuelve a insertar los parámetros");
                    validation = true;
                    continue;
                }
            }catch(Exception e){
                System.out.println("Valida los parámetros y vuelve a insertarlos");
                continue;
            }

            //Realizamos la operacion
                double number1 = Double.parseDouble(split[0]);
                double number2 = Double.parseDouble(split[2]);
                operator = split[1];
                switch (operator) {
                    case "+":
                        calc= (number1 + number2);
                        validation = true;
                        break;
                    case "/":
                        if(number2==0){
                            System.out.println("No se permite dividir por 0");
                            continue;
                        }else{
                            calc= (number1 / number2);
                            validation = true;
                        }
                        break;
                    case "*":
                        calc= (number1 * number2);
                        validation = true;
                        break;
                    case "-":
                        calc= (number1 - number2);
                        validation = true;
                        break;
                    default:
                        System.out.println("No has insertado un operador válido");
                        validation = false;
                        continue;
                }
                //Informamos el resultado en caso de haberlo
                if(validation){
                System.out.println("La operación que me solicitas que calcule es " + operation + ", y el resultado es: " + calc);
                }

                //Valoramos si continuamos calculando o terminamos
                answer = false;
                while (!answer){
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
                        System.out.println("Se ha solicitado únicamente una letra/dígito. No son válidos los carácteres especiales");
                    }
                }
        }
        sc.close();
    }
}
