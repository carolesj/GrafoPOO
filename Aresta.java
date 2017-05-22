/**
 * Created by caroles on 21/05/2017.
 */

/**
 * Implementa arestas de um grafo, que possuem dois vértices (saída e chegada)
 * e peso.
 */
public class Aresta {
    Vertice v1;
    Vertice v2;
    float peso;

    /**
     * Constroi uma aresta valorada e direcionada.
     * @param v1 vértice de saída
     * @param v2 vértice de chegada
     * @param peso peso da aresta
     */
    public Aresta (Vertice v1, Vertice v2, float peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    /**
     * Informa o peso
     * @return o peso da aresta
     */
    public float getPeso () {
        return peso;
    }

    /**
     * Informa o vértice de saída
     * @return o vértice de saída da aresta
     */
    public Vertice getV1 () {
        return v1;
    }

    /**
     * Informa o vértice de chegada
     * @return o vértice de chegada da aresta
     */
    public Vertice getV2 () {
        return v2;
    }
}
