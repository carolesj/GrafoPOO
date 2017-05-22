/**
 * Created by caroles on 21/05/2017.
 */

/**
 * Implementa um vértice que possui um nome.
 */
public class Vertice {
    String nome;

    /**
     * Constroi um vértice e define seu nome.
     * @param nome o nome do vértice
     */
    public Vertice (String nome) {
        this.nome = nome;
    }

    /**
     * Informa o nome do vértice
     * @return o nome do vértice
     */
    public String getNome () {
        return nome;
    }

}
