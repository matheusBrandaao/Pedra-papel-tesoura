package sockets.unisinos.br;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Servidor {
    static String[] jogada = {"PEDRA", "PAPEL", "TESOURA"};
    
    private static int sorteiaIndice(){
        return (int)(Math.random() * 3);
    }
    
    private static String getJogada(){
        int indice = sorteiaIndice();
        return jogada[indice];
    }
    
    private static void message(String msg){
        System.out.println(msg);
    }
    
    public static void main(String[] args) throws IOException {
     ServerSocket servidor = new ServerSocket(420);
     System.out.println("[+] Servidor iniciado");
     
     //bloqueante
     Socket cliente = servidor.accept();
     
     System.out.println("Nova conexão iniciada");
     
     
     //le os dados enviados pela classe Principal
     Scanner s = new Scanner(cliente.getInputStream());
     
     //jogo em uma variavel o valor lido
     String lido = s.nextLine();
     
     
     //realizada uma jogada do servidor
     String jogadaSorteada = getJogada();
     
     message("Jogada da máquina: " + jogadaSorteada);
     
     //analisa o resultado
     Analisador.analisarJogada(jogadaSorteada, lido);
     
     
     
     //while(){
     //    
     //}
     
     
    s.close();
    servidor.close();
    cliente.close();
    }
}
