package algorithms.homework.hw6;


import java.util.*;

public class Graphs {
    private static HashMap<String, LinkedList<String>> graph;
    private static HashSet<String> visited;
    private static Stack<String> topoStack;


    /**
     * Begin DFS
     *
     * @param startVertex the starting point of the graph
     */
    public static void performDFS(String startVertex) {
        visited = new HashSet<>();
        dfs(startVertex);
    }

    /**
     * Recursive DFS helper method
     *
     * @param startVertex the starting point of the graph
     */
    public static void dfs(String startVertex) {
        visited.add(startVertex);
        System.out.print(startVertex + " ");

        List<String> neighbors = graph.getOrDefault(startVertex, new LinkedList<>());

        Collections.sort(neighbors);

        for (String s : neighbors) {
            if (!visited.contains(s)) {
                dfs(s);
            }
        }
    }


    /**
     * @param graph       the graph to search
     * @param startVertex the starting point of the graph
     */
    public static void bfs(HashMap<String, LinkedList<String>> graph, String startVertex) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            String w = queue.poll();
            System.out.print(w + " ");

            LinkedList<String> neighbours = new LinkedList<>(graph.getOrDefault(w, new LinkedList<>()));
            Collections.sort(neighbours);

            for (String s : neighbours) {
                if (!visited.contains(s)) {
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
    }

    /**
     * Sorts graph's vertices from startingVertex
     *
     * @param startVertex the starting point of the graph
     */
    public static void topoSort(String startVertex) {
        visited.add(startVertex);

        List<String> neighbors = graph.getOrDefault(startVertex, new LinkedList<>());
        Collections.sort(neighbors);

        for (String s : neighbors) {
            if (!visited.contains(s)) {
                topoSort(s);
            }
        }

        topoStack.push(startVertex);
    }

    /**
     * Carries out sorting for the entire graph
     */
    public static void performTopoSort() {
        visited = new HashSet<>();
        topoStack = new Stack<>();

        for (String startVertex : graph.keySet()) {
            if (!visited.contains(startVertex)) {
                topoSort(startVertex);
            }
        }

        /**
         * Print all vertices
         */

        System.out.print("\nTopological Sort: ");
        while (!topoStack.empty()) {
            System.out.print(topoStack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        /********************************************************************************
         *                                                                              *
         *                            BFS & DFS TEST CASE GRAPHS                        *
         *                                                                              *
         ********************************************************************************/

        graph = new HashMap<>();
//        TEST CASE 1: initial graph
        graph.put("A", new LinkedList<>(Arrays.asList("B", "F", "G")));
        graph.put("B", new LinkedList<>(Arrays.asList("C", "D")));
        graph.put("C", new LinkedList<>(List.of("F")));
        graph.put("D", new LinkedList<>(List.of("E")));
        graph.put("E", new LinkedList<>(List.of("F")));
        graph.put("F", new LinkedList<>(List.of("H")));
        graph.put("G", new LinkedList<>(List.of("D")));
        graph.put("H", new LinkedList<>());
//
//         TEST CASE 2:  empty graph
//         HashMap<String, LinkedList<String >> graph = new HashMap<>();
//
//
//         TEST CASE 3:  single vertex graph
//         HashMap<String, LinkedList<String >> graph = new HashMap<>();
//         graph.put("A", new LinkedList<>(Arrays.asList("B", "F", "G")));


        System.out.print("DFS: ");
        performDFS("A");

        System.out.print("\nBFS: ");
        bfs(graph, "A");

        /********************************************************************************
         *                                                                              *
         *                            TOPOLOGICAL SORT TEST CASES                       *
         *                                                                              *
         ********************************************************************************/

//          TEST CASE 1: Initial search list
        graph = new HashMap<>();
        graph.put("Underwear", new LinkedList<>(Arrays.asList("Pants", "Shoes")));
        graph.put("Pants", new LinkedList<>(Arrays.asList("Belt", "Shoes")));
        graph.put("Belt", new LinkedList<>(Arrays.asList("Jacket")));
        graph.put("Shirt", new LinkedList<>(Arrays.asList("Belt", "Tie")));
        graph.put("Tie", new LinkedList<>(Arrays.asList("Jacket")));
        graph.put("Jacket", new LinkedList<>());
        graph.put("Shoes", new LinkedList<>());
        graph.put("Socks", new LinkedList<>(Arrays.asList("Shoes")));
        graph.put("Watch", new LinkedList<>());
        performTopoSort();

//         TEST CASE 2: Graph with a cycle to test looping
//         graph = new HashMap<>();
//         graph.put("Shirt", new LinkedList<>(Arrays.asList("Tie")));
//         graph.put("Tie", new LinkedList<>(Arrays.asList("Jacket")));
//         graph.put("Jacket", new LinkedList<>(Arrays.asList("Shirt")));
//         performTopoSort();

//         TEST CASE 3: Graph with disconnected components, shows no dependencies
//         graph = new HashMap<>();
//         graph.put("Underwear", new LinkedList<>(Arrays.asList("Pants")));
//         graph.put("Pants", new LinkedList<>(Arrays.asList("Belt", "Shoes")));
//         graph.put("Belt", new LinkedList<>(Arrays.asList("Jacket")));
//         graph.put("Socks", new LinkedList<>(Arrays.asList("Shoes")));
//         graph.put("Watch", new LinkedList<>());
//         performTopoSort();


    }
}