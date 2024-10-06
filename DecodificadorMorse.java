import java.util.Scanner;

public class DecodificadorMorse {
    private static final String[][] MORSE_CODE = {
        {".-", "a"}, {"-...", "b"}, {"-.-.", "c"}, {"-..", "d"}, {".", "e"},
        {"..-.", "f"}, {"--.", "g"}, {"....", "h"}, {"..", "i"}, {".---", "j"},
        {"-.-", "k"}, {".-..", "l"}, {"--", "m"}, {"-.", "n"}, {"---", "o"},
        {".--.", "p"}, {"--.-", "q"}, {".-.", "r"}, {"...", "s"}, {"-", "t"},
        {"..-", "u"}, {"...-", "v"}, {".--", "w"}, {"-..-", "x"}, {"-.--", "y"},
        {"--..", "z"}
    };

    private final MorseTree morseTree;

    public DecodificadorMorse() {
        morseTree = new MorseTree();
    }

    public String codificar(String mensagem) {
        StringBuilder codigoMorse = new StringBuilder();
        mensagem = mensagem.toLowerCase(); 

        for (char letra : mensagem.toCharArray()) {
            if (letra == ' ') {
                codigoMorse.append("   ");
            } else {
                for (String[] par : MORSE_CODE) {
                    if (par[1].equals(String.valueOf(letra))) {
                        codigoMorse.append(par[0]).append(" ");
                        break;
                    }
                }
            }
        }

        return codigoMorse.toString().trim();
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a opção:");
        System.out.println("1. Traduzir código Morse para texto");
        System.out.println("2. Traduzir texto para código Morse");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o código Morse (use espaços para separar letras e 3 espaços para separar palavras): ");
                String codigoMorse = scanner.nextLine();
                String mensagemDecodificada = morseTree.decodificar(codigoMorse);
                System.out.println("Mensagem decodificada: " + mensagemDecodificada);
                break;

            case 2:
                System.out.print("Digite a mensagem: ");
                String mensagem = scanner.nextLine();
                String codigoMorseCodificado = codificar(mensagem);
                System.out.println("Código Morse codificado: " + codigoMorseCodificado);
                break;

            default:
                System.out.println("Opção inválida.");
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        DecodificadorMorse decodificador = new DecodificadorMorse();
        decodificador.executar();
    }
}
