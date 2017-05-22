import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by caroles on 21/05/2017.
 */

/**
 * Um grafo pode ser visto como um conjunto de arestas, por isso, essa classe deve
 * extender uma HashSet de arestas.
 */
public class Grafo extends HashSet<Aresta> {
    public static void main (String[] args) {
        //cria um conjunto de todos os vértices que serão criados
        HashMap <String, Vertice> GrupoVertices = new HashMap<>();
        //cria um conjunto para as arestas que serão definidas
        Grafo g = new Grafo();

        int op = 0;
        do {
            System.out.println("Digite 1 para inserir vértices, 2 para definir arestas, " +
                    "3 para rodar o algoritmo de caminho mínimo entre 2 vértices ou 4" +
                    "para sair.");
            try {
                op = EntradaTeclado.leInt();

                switch (op) {
                    case 1:
                        System.out.println("Digite o nome do vértice");
                        String nome = EntradaTeclado.leString();
                        Vertice novo = new Vertice(nome);
                        GrupoVertices.put(nome, novo);
                        break;
                    case 2:
                        System.out.println("Digite o vértice de saída, o vértice de chegada " +
                                "e o peso da aresta");
                        String v1 = EntradaTeclado.leString();
                        String v2 = EntradaTeclado.leString();
                        float peso = (float) EntradaTeclado.leDouble();
                        Vertice aux1 = GrupoVertices.get(v1);
                        Vertice aux2 = GrupoVertices.get(v2);
                        if (aux1 != null && aux2 != null) {
                            Aresta a = new Aresta(aux1, aux2, peso);
                            g.add(a);
                        } else {
                            System.out.println("Os vértices informados estão incorretos. " +
                                    "Tente novamente");
                        }
                        break;
                    case 3:
                        System.out.println("Digite o vértice inicial e o vértice final");
                        String inicio = EntradaTeclado.leString();
                        String fim = EntradaTeclado.leString();
                        ArrayList<Vertice> caminho;
                        try {
                            caminho = Dijkstra.menorCaminho(g, GrupoVertices, inicio, fim);
                            //o algoritmo implementado retorna o caminho ao contrário, portanto
                            //percorre a ArrayList ao contrário
                            for (int i = (caminho.size() - 1); i >= 0; i--) {
                                System.out.print(caminho.get(i).getNome() + "\t");
                            }
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Erro ao calcular caminho: " + e);
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Essa opção não é valida. Tente novamente.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Opa, parece que você digitou algo inesperado. " +
                        "É mole? Tente novamente.");
            }
        } while (op != 4);
    }
}
