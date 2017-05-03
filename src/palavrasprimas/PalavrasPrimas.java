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
        
        int n;
        //Declaração de um vetor de palavras
        String [] palavras;
        Scanner ler = new Scanner(System.in);
        
        // Define a quantidade de palavras que serão verificadas
        System.out.println("Entre com o numero de palavras que deseja verificar:");
        n = ler.nextInt();
       
        palavras = new String[n];
        
        //Enquanto o vetor de palavras não for preenchido continua o for
        for(int i = 0; i<n;i++)
        {
            System.out.println("Entre a palavra " + (i+1) + ":");
            palavras[i] = ler.next();
            
            //Se a palavra conter qualquer carcter que não seja uma letra permitida ela será invalida
            if(palavras[i].matches("^[a-zA-Z2]*$"))
                //chama a função para o calculo do valor da palavra em numeros
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

        //tranforma a palavra em um vetor de Char
        for(int i=0; i<n;i++)
        {
        letra[i] = palavra.charAt(i);
        }
        
        //vai verificar qual numero referente a cada letra da palavra
        for(int i=0; i<n; i++)
        {
            /*usando ASCII para definir um numero a letra, caso seja minuscula
            será subtraido 96 do valor ASCII, caso seja maiúscula será subtraido 38.*/
           if(Character.isLowerCase(letra[i]))
               ascii[i] = (int)letra[i]-96;
           else if (Character.isUpperCase(letra[i]))
               ascii[i] = (int)letra[i]-38;
        }
        //chama função para a soma dos valores encontrados, recebendo um boolean
        primo = primo(ascii,n);
        
        if(primo == true)
            System.out.println("It is a prime word."); 
        else
            System.out.println("It is not a prime word.");         
    }
    
    public static Boolean primo(int[] numeros, int n){
        
        int soma, cont;
        
        soma=0;
        cont =0;
        
        //soma todos os numeros do vetor que corresponde as letras
        for(int i = 0; i<n; i++)
        {
            soma = soma + numeros[i];  
        }
        
        //verifica se está soma é prima ou não
        for(int i=1; i<=soma;i++){
            if(soma % i == 0)
                cont ++;    
        }
        
        //se a soma for divisivel por mais de 2 numeros não é primo
        if (cont > 2)
            return false;
        else
            return true;
    }
    
}
