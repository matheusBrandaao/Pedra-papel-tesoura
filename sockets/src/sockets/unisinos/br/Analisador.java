package sockets.unisinos.br;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Analisador {
    String jogador;
    static InputStream entrada;
    static boolean rodando = true;
    
    
    public Analisador(){}
    
    
    private  static void resultado(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
            
    public static void analisarJogada(String jogadaMaquina, String jogadaHumano){
        String maquina = jogadaMaquina;
        String humano = jogadaHumano;
        
        
        if(humano.equals(maquina)){
            resultado("Empate");
        }
        //CASOS QUE O HUMANO VENCE
        else if(humano.equals("PEDRA") && maquina.equals("TESOURA")){
            resultado("Humano venceu");
        }
        else if(humano.equals("PAPEL") && maquina.equals("PEDRA")){
            resultado("Humano venceu");
        }
        else if(humano.equals("TESOURA") && maquina.equals("PAPEL")){
            resultado("Humano venceu");
        }
        
        //CASOS QUE A MAQUINA VENCE
        else if(maquina.equals("PEDRA") && humano.equals("TESOURA")){
            resultado("Maquina venceu");
        }
        else if(maquina.equals("PAPEL") && humano.equals("PEDRA")){
            resultado("Maquina venceu");
        }
        else if(maquina.equals("TESOURA") && humano.equals("PAPEL")){
            resultado("Maquina venceu");
        }
    }
    
    public static void enviarDados() throws UnknownHostException, IOException {
     
   }
}
