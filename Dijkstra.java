import java.util.*;

/**
 * Created by caroles on 21/05/2017.
 */

/**
 * Implementa o algoritmo de Dijkstra, que acha o menor caminho entre dois vértices de um
 * grafo direcionado ou não. Algoritmo baseado no artigo: https://pt.wikipedia.org/wiki/Algoritmo_de_Dijkstra
 */
public class Dijkstra {

    /**
     * Método estático que efetivamente acha o menor caminho entre os vértices informados.
     * @param g grafo direcionado e valorado
     * @param v tabela de vértices existentes indexados pelo nome
     * @param vInicial nome do vértice de saída
     * @param vFinal nome do vértice de chegada
     * @throws Exception quando um dos vértices informados não existe
     * @return o menor caminho entre os vértices, porém no sentido da volta
     */
    public static ArrayList<Vertice> menorCaminho (Grafo g, Map<String, Vertice> v, String vInicial,
                                          String vFinal) throws Exception {
        Vertice inicio, fim;

        inicio = v.get(vInicial);
        fim = v.get(vFinal);

        if (inicio == null|| fim == null) {
            throw new Exception("Vértice inexistente.");
        }

        //cria tabelas auxiliares que relacionam os vértices às suas informações necessárias para
        //o algoritmo
        Map<Vertice, Float> distancias = new HashMap<>();
        Map<Vertice, Vertice>predecessor = new HashMap<>();

        //define as distâncias iniciais como infinito, e o primeiro predecessor como inexistente
        for (Vertice it : v.values()) {
            distancias.put(it, Float.POSITIVE_INFINITY);
            predecessor.put(it, null);
        }

        //inicia a distância do primeiro vértice para ele mesmo (zero)
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

    /***
     * Acha os vértices adjacentes ao vértice informado.
     * @param g grafo direcionado e valorado
     * @param inicio vértice de partida
     * @return lista de arestas que partem do vértice inicial
     */
    private static ArrayList<Aresta> achaAdjacentes (Grafo g, Vertice inicio) {
        ArrayList<Aresta> adjacentes = new ArrayList<>();
        for (Aresta it : g) {
            if (it.getV1().equals(inicio)) {
                adjacentes.add(it);
            }
        }
        return adjacentes;
    }

    /**
     * Acha o vértice que está com a menor distância. Ao final, é removido da tabela.
     * @param v Tabela de vértices a serem visitados
     * @param d Tabela que relaciona vértices às menores distâncias encontradas até o momento
     * @return o vértice que possui a menor distância
     */
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
