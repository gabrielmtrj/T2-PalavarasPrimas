/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palavrasprimas;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Gabri
 */
public class PalavrasPrimas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        String [] palavras;
        Scanner ler = new Scanner(System.in);
        
        
        System.out.println("Entre com o numero de palavras que deseja verificar:");
        n = ler.nextInt();
       
        palavras = new String[n];
        
        for(int i = 0; i<n;i++)
        {
            System.out.println("Entre a palavra " + (i+1) + ":");
            palavras[i] = ler.next();
            
            if(palavras[i].matches("^[a-zA-Z2]*$"))
                valor(palavras[i], palavras[i].length());
            else
            {
                System.out.println("Essa palavra cotém caracteres não permitidos.");
                i--;
            }
        }
        
    }
    
    public static void valor(String palavra, int n){
        
        int[] ascii = new int[n];
        char[] letra = new char[n];
        Boolean primo = false;

        
        for(int i=0; i<n;i++)
        {
        letra[i] = palavra.charAt(i);
        }
        
        for(int i=0; i<n; i++)
        {
           if(Character.isLowerCase(letra[i]))
               ascii[i] = (int)letra[i]-96;
           else if (Character.isUpperCase(letra[i]))
               ascii[i] = (int)letra[i]-38;
        }
        primo = primo(ascii,n);
        
        if(primo == true)
            System.out.println("A palavra é prima."); 
        else
            System.out.println("A palavra não é prima.");         
    }
    
    public static Boolean primo(int[] numeros, int n){
        
        int soma, cont;
        
        soma=0;
        cont =0;
        
        for(int i = 0; i<n; i++)
        {
            soma = soma + numeros[i];  
        }
        
        for(int i=1; i<=soma;i++){
            if(soma % i == 0)
                cont ++;    
        }
        
        if (cont > 2)
            return false;
        else
            return true;
    }
    
}
