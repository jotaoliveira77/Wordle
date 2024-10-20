package main;

import java.util.Scanner;

import palavras.PalavrasDoJogo;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class TermoJogo {

    int maxTry = 6;
    int maxLetras = 5;
    String palavra;
    String tentativa;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        TermoJogo jogo = new TermoJogo();
        jogo.jogar();
    }

    public void jogar() {

        PalavrasDoJogo word = new PalavrasDoJogo();
        palavra = word.getPalavraAleatoria();
       
        int currentAttempt = 0;
        List<String> attempts = new ArrayList<>(); 

        while (currentAttempt < maxTry) {
            System.out.println("Digite sua tentativa:");
            tentativa = scan.nextLine();

            if (tentativa.length() != palavra.length()) {
                System.out.println("A palavra deve ter exatamente " + maxLetras + " letras.");
                continue;
            }

            attempts.add(tentativa); 
            currentAttempt++;

            if (tentativa.equalsIgnoreCase(palavra)) {
                System.out.println("Parabéns, você acertou em " + currentAttempt + " tentativas!");
                break;
            } else {
                System.out.println("Você tem " + (maxTry - currentAttempt) + " tentativas restantes.");
                exibirFeedback(tentativa, palavra);
            }

            if (currentAttempt == maxTry) {
                System.out.println("Fim de jogo! A palavra correta era: " + palavra);
            }
        }
    }

    public void exibirFeedback(String tentativa, String palavra) {
        char[] feedback = new char[maxLetras];

        for (int i = 0; i < maxLetras; i++) {
            if (tentativa.charAt(i) == palavra.charAt(i)) {
                feedback[i] = 'G';  
            } else if (palavra.contains(Character.toString(tentativa.charAt(i)))) {
                feedback[i] = 'Y'; 
            } else {
                feedback[i] = 'B';  
            }
        }

        System.out.println("Feedback: " + new String(feedback));
        System.out.println("'G' = Letra correta no lugar certo, 'Y' = Letra correta no lugar errado, 'B' = Letra incorreta");
    }
}
