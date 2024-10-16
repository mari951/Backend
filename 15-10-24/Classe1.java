import java.util.*;

public class Classe1 {
public static void main(String[] args){
Scanner scnInputUsuario = new Scanner(System.in);
System.out.println("Olá!Bem vindo a calculadora de Java.Digite o primeiro número a ser calculadoe tecle:\"Enter\".");
int intInputUsuario1 = scnInputUsuario.nextInt();
System.out.println("Digite o número da opcao desejada e tecle:\"Enter\".");
String[] opcoes = Classe2.mostrarOpcoes();

for(int count = 0;count< opcoes.length;count++){
System.out.println(count+"-"+opcoes[count]);
}

int opcaoEscolhida = scnInputUsuario.nextint();

System.out.println("O resultado da " + opscoes[opcoesEscolhida]+"é:"+Classe2.resultado(intInputUsuario1,intInputUsuario2,opcaoEscolhida));
scnInputUsuario.close();
}
}





}

}
