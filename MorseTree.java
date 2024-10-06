public class MorseTree {
    private final MorseNode raiz;

    public MorseTree() {
        raiz = new MorseNode(' ');

        inserirCodigo(".-", 'a');
        inserirCodigo("-...", 'b');
        inserirCodigo("-.-.", 'c');
        inserirCodigo("-..", 'd');
        inserirCodigo(".", 'e');
        inserirCodigo("..-.", 'f');
        inserirCodigo("--.", 'g');
        inserirCodigo("....", 'h');
        inserirCodigo("..", 'i');
        inserirCodigo(".---", 'j');
        inserirCodigo("-.-", 'k');
        inserirCodigo(".-..", 'l');
        inserirCodigo("--", 'm');
        inserirCodigo("-.", 'n');
        inserirCodigo("---", 'o');
        inserirCodigo(".--.", 'p');
        inserirCodigo("--.-", 'q');
        inserirCodigo(".-.", 'r');
        inserirCodigo("...", 's');
        inserirCodigo("-", 't');
        inserirCodigo("..-", 'u');
        inserirCodigo("...-", 'v');
        inserirCodigo(".--", 'w');
        inserirCodigo("-..-", 'x');
        inserirCodigo("-.--", 'y');
        inserirCodigo("--..", 'z');
    }

    private void inserirCodigo(String codigoMorse, char letra) {
        MorseNode atual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (atual.ponto == null) {
                    atual.ponto = new MorseNode(' ');
                }
                atual = atual.ponto;
            } else if (simbolo == '-') {
                if (atual.traco == null) {
                    atual.traco = new MorseNode(' ');
                }
                atual = atual.traco;
            }
        }
        atual.letra = letra; 
    }

    public String decodificar(String codigoMorse) {
        StringBuilder mensagemDecodificada = new StringBuilder();
        String[] palavras = codigoMorse.split("   "); 

        for (String palavra : palavras) {
            String[] letras = palavra.split(" "); 
            for (String letra : letras) {
                MorseNode atual = raiz;
                for (char simbolo : letra.toCharArray()) {
                    if (simbolo == '.') {
                        atual = atual.ponto;
                    } else if (simbolo == '-') {
                        atual = atual.traco;
                    }

                    if (atual == null) {
                        break; 
                    }
                }
                if (atual != null) {
                    mensagemDecodificada.append(atual.letra);
                }
            }
            mensagemDecodificada.append(' ');
        }

        return mensagemDecodificada.toString().trim();
    }
}
