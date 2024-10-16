public class Classe {
    public static int calcularSoma(int numero1,int numero2) {
       return numero1+numero2;

    }
    public static String[] mostrarOpcoes() {
        return operadoresMatematicos;
    }


        public static String processarDados(int intInputUsuario1,int intInputUsuario2,int opcaoEscolhida) {
            int resultado;

           switch(opcaoEscolhida)  {
            case 0:
            resultado = somar(intInputUsuario1,intputUsuario2);
            break;

            case 1:
             resultado = subtrair(intInputUsuario1,intputUsuario2);
            break;

             case 2:
             resultado = Multiplicar(intInputUsuario1,intputUsuario2);
             break;

             case3:
             resultado = dividir(intInputUsuario1,intputUsuario2);
             break;

             defautl:
             resultado = 0;
             break;
             
          }
        }

        public static int somar(int numero 1,int numero2) {
            return numero1+ numero2;


