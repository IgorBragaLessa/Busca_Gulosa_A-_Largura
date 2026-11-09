import java.util.*;

/** Busca Gulosa: ordena a fronteira apenas por h(n) (distância em linha reta). */
public class Gulosa extends Busca {
    public Gulosa(Vertice objetivo) { super(objetivo); }

    @Override
    public Resultado busca(Vertice origem) {
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt((No n) -> n.h));
        Set<Vertice> visitados = new HashSet<>();
        List<String> ordem = new ArrayList<>();
        fronteira.add(new No(origem, null, 0));
        int gerados = 1;

        while (!fronteira.isEmpty()) {
            No atual = fronteira.poll();
            if (!visitados.add(atual.vertice)) continue;
            ordem.add(atual.vertice.getRotulo());
            if (ehObjetivo(atual.vertice)) return monta("Gulosa", atual, ordem, gerados);

            for (Adjacente adj : atual.vertice.getAdjacentes()) {
                if (!visitados.contains(adj.getVertice())) {
                    fronteira.add(new No(adj.getVertice(), atual, atual.g + adj.getCusto()));
                    gerados++;
                }
            }
        }
        return monta("Gulosa", null, ordem, gerados);
    }
}
