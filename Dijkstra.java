import java.util.*;

/**
 * Created by caroles on 21/05/2017.
 */
public class Dijkstra {
    public static ArrayList<Vertice> menorCaminho (Grafo g, Map<String, Vertice> v, String vInicial,
                                          String vFinal) throws Exception {
        Vertice inicio, fim;

        inicio = v.get(vInicial);
        fim = v.get(vFinal);

        if (inicio == null|| fim == null) {
            throw new Exception("Vértice inexistente.");
        }

        Map<Vertice, Float> distancias = new HashMap<>();
        Map<Vertice, Vertice>predecessor = new HashMap<>();

        for (Vertice it : v.values()) {
            distancias.put(it, Float.POSITIVE_INFINITY);
            predecessor.put(it, null);
        }

        distancias.put(inicio, 0.0f);

        ArrayList<Vertice> proximos = new ArrayList<>(v.values());

        while (!proximos.isEmpty()) {
            Vertice auxiliar = achaMenorDistancia(proximos, distancias);
            for (Aresta it : achaAdjacentes(g, auxiliar)) {
                Vertice v2 = it.getV2();
                if (distancias.get(v2) > (distancias.get(auxiliar) + it.getPeso())) {
                    distancias.put(v2, distancias.get(auxiliar) + it.getPeso());
                    predecessor.put(v2, auxiliar);
                }
            }
        }
        ArrayList<Vertice> caminho = new ArrayList<>();
        for (Vertice it = fim; it != null; it = predecessor.get(it)) {
            caminho.add(it);
        }
        return caminho;
    }

    private static ArrayList<Aresta> achaAdjacentes (Grafo g, Vertice inicio) {
        ArrayList<Aresta> adjacentes = new ArrayList<>();
        for (Aresta it : g) {
            if (it.getV1().equals(inicio)) {
                adjacentes.add(it);
            }
        }
        return adjacentes;
    }

    private static Vertice achaMenorDistancia (ArrayList<Vertice> v, Map<Vertice, Float> d) {
        float menorDistancia = d.get(v.get(0));
        int indice = 0;
        for (int i = 1; i < v.size(); i++) {
            if (menorDistancia > d.get(v.get(i))) {
                menorDistancia = d.get(v.get(i));
                indice = i;
            }
        }
        return v.remove(indice);
    }
}
