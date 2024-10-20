package palavras;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PalavrasDoJogo {

    private List<String> palavras;  
    private Random random;

    public PalavrasDoJogo() {
        random = new Random();
        palavras = new ArrayList<>();
        
        
        palavras.add("Carne");
        palavras.add("Fluxo");
        palavras.add("Gatos");
        palavras.add("Festa");
        palavras.add("Pluma");
        palavras.add("Ratos");
    }

    
    public String getPalavraAleatoria() {
        int index = random.nextInt(palavras.size());
        return palavras.get(index);
    }

    
    public void adicionarPalavra(String novaPalavra) {
        palavras.add(novaPalavra);
    }

    
    public void removerPalavra(String palavra) {
        palavras.remove(palavra);
    }
}

