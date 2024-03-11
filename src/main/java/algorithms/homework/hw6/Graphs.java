package algorithms.homework.hw6;

import java.util.*;

public class Graphs {
   private static void process(String vertex) {
      System.out.println(vertex + " ");
   }

   public static void dfs(HashMap<String, LinkedList<String>> graph, String vertex) {
      HashSet<String> visited = new HashSet<>();
      Stack<String> stack = new Stack<>();

      visited.add(vertex);
      stack.push(vertex);

      while (!stack.isEmpty()) {
         String w = stack.pop();
         process(w);

         for (String s : graph.get(w)) {
            if (!visited.contains(s)) {
               visited.add(s);
               stack.push(s);
            }
         }
      }
   }

   public static void main(String[] args) {
      HashMap<String, LinkedList<String>> graph = new HashMap<>();
      graph.put("A", new LinkedList<>(Arrays.asList("B", "C", "E")));
      graph.put("B", new LinkedList<>(Arrays.asList("A", "D", "E")));
      graph.put("C", new LinkedList<>(Arrays.asList("A", "F", "G")));
      graph.put("D", new LinkedList<>(Arrays.asList("B")));
      graph.put("E", new LinkedList<>(Arrays.asList("A", "B", "F")));
      graph.put("F", new LinkedList<>(Arrays.asList("C", "E", "H")));
      graph.put("G", new LinkedList<>(Arrays.asList("C")));
      graph.put("H", new LinkedList<>(Arrays.asList("F")));
   }
}