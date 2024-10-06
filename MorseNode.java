public class MorseNode {
    char letra; 
    MorseNode ponto;
    MorseNode traco;

    public MorseNode(char letra) {
        this.letra = letra;
        this.ponto = null;
        this.traco = null;
    }
}
