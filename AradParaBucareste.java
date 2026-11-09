import java.util.*;

public class AradParaBucareste {
    public static void main(String[] args) {
        List<Resultado> resultados = new ArrayList<>();
        // Cada busca recebe um grafo novo (evita estado compartilhado entre execuções)
        Grafo g1 = new Grafo(); resultados.add(new Gulosa(g1.bucareste).busca(g1.arad));
        Grafo g2 = new Grafo(); resultados.add(new AEstrela(g2.bucareste).busca(g2.arad));
        Grafo g3 = new Grafo(); resultados.add(new Largura(g3.bucareste).busca(g3.arad));

        for (Resultado r : resultados) {
            System.out.println("=== " + r.metodo + " ===");
            System.out.println("Ordem de expansão : " + String.join(" -> ", r.ordemExpansao));
            System.out.println("Caminho encontrado: " + String.join(" -> ", r.caminho));
            System.out.println("Custo (km)        : " + r.custo);
            System.out.println("Nós expandidos    : " + r.nosExpandidos);
            System.out.println("Nós gerados       : " + r.nosGerados);
            System.out.println();
        }

        System.out.printf("%-10s | %-9s | %-10s | %-7s | %s%n", "Método", "Custo(km)", "Expandidos", "Gerados", "Caminho");
        for (Resultado r : resultados)
            System.out.printf("%-10s | %-9d | %-10d | %-7d | %s%n", r.metodo, r.custo, r.nosExpandidos, r.nosGerados, String.join(" > ", r.caminho));
    }
}
