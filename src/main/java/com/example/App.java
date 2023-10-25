package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Scanner tastiera = new Scanner(System.in);
            Socket s = new Socket("localhost", 3000);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            String inizio = in.readLine();
            System.out.println(inizio);

            String risposta;
            do{
                System.out.println("inserisci il numero:");
                String input = tastiera.nextLine();
                out.writeBytes(input+'\n');

                risposta = in.readLine();

                switch(risposta){
                    case "1":
                        System.out.println("numero troppo piccolo");
                        break;
                    case "2":
                        System.out.println("numero troppo grande");
                        break;
                    case "3":
                        String tentativi = in.readLine();
                        System.out.println("Hai indovinato "+ tentativi + " volte");
                        break;
                    default:
                        System.out.println("errore"); 
                        break;
                }
               
            } while(risposta != "3");

           

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
