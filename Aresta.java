/**
 * Created by caroles on 21/05/2017.
 */
public class Aresta {
    Vertice v1;
    Vertice v2;
    float peso;

    public Aresta (Vertice v1, Vertice v2, float peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public float getPeso () {
        return peso;
    }

    public Vertice getV1 () {
        return v1;
    }

    public Vertice getV2 () {
        return v2;
    }
}
