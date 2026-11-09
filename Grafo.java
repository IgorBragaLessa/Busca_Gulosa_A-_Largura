public class Grafo {
    // Atributos são as cidades (vértices do grafo)
    public Vertice arad, zerind, oradea, sibiu, timisoara, lugoj, mehadia,
            dobreta, craiova, rimnicu, fagaras, pitest, bucareste, giurgiu;

    public Grafo() {

        arad = new Vertice("Arad", 366);
        zerind = new Vertice("Zerind", 374);
        oradea = new Vertice("Oradea", 380);
        sibiu = new Vertice("Sibiu", 253);
        timisoara = new Vertice("Timisoara", 329);
        lugoj = new Vertice("Lugoj", 244);
        mehadia = new Vertice("Mehadia", 241);
        dobreta = new Vertice("Dobreta", 242);
        craiova = new Vertice("Craiova", 160);
        rimnicu = new Vertice("Rimnicu Vilcea", 193);
        fagaras = new Vertice("Fagaras", 178);
        pitest = new Vertice("Pitesti", 98);
        bucareste = new Vertice("Bucareste", 0);
        giurgiu = new Vertice("Giurgiu", 77);

        arad.adicionaAdjacente(new Adjacente(zerind, 75));
        arad.adicionaAdjacente(new Adjacente(sibiu, 140));
        arad.adicionaAdjacente(new Adjacente(timisoara, 118));

        zerind.adicionaAdjacente(new Adjacente(arad, 75));
        zerind.adicionaAdjacente(new Adjacente(oradea, 71));

        oradea.adicionaAdjacente(new Adjacente(zerind, 71));
        oradea.adicionaAdjacente(new Adjacente(sibiu, 151));

        sibiu.adicionaAdjacente(new Adjacente(oradea, 151));
        sibiu.adicionaAdjacente(new Adjacente(arad, 140));
        sibiu.adicionaAdjacente(new Adjacente(fagaras, 99));
        sibiu.adicionaAdjacente(new Adjacente(rimnicu, 80));

        timisoara.adicionaAdjacente(new Adjacente(arad, 118));
        timisoara.adicionaAdjacente(new Adjacente(lugoj, 111));

        lugoj.adicionaAdjacente(new Adjacente(timisoara, 111));
        lugoj.adicionaAdjacente(new Adjacente(mehadia, 70));

        mehadia.adicionaAdjacente(new Adjacente(lugoj, 70));
        mehadia.adicionaAdjacente(new Adjacente(dobreta, 75));

        dobreta.adicionaAdjacente(new Adjacente(mehadia, 75));
        dobreta.adicionaAdjacente(new Adjacente(craiova, 120));

        craiova.adicionaAdjacente(new Adjacente(dobreta, 120));
        craiova.adicionaAdjacente(new Adjacente(pitest, 138));
        craiova.adicionaAdjacente(new Adjacente(rimnicu, 146));

        rimnicu.adicionaAdjacente(new Adjacente(sibiu, 80));
        rimnicu.adicionaAdjacente(new Adjacente(craiova, 146));
        rimnicu.adicionaAdjacente(new Adjacente(pitest, 97));

        fagaras.adicionaAdjacente(new Adjacente(sibiu, 99));
        fagaras.adicionaAdjacente(new Adjacente(bucareste, 211));

        pitest.adicionaAdjacente(new Adjacente(rimnicu, 97));
        pitest.adicionaAdjacente(new Adjacente(craiova, 138));
        pitest.adicionaAdjacente(new Adjacente(bucareste, 101));

        bucareste.adicionaAdjacente(new Adjacente(fagaras, 211));
        bucareste.adicionaAdjacente(new Adjacente(pitest, 101));
        bucareste.adicionaAdjacente(new Adjacente(giurgiu, 90));

        giurgiu.adicionaAdjacente(new Adjacente(bucareste, 90));
    }
}