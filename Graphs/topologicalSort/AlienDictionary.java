import java.util.*;

class AlienDictionary {

    public static String printArrayWithMarkers(List<String> words, int lValue, int pValue) {
        String out = "[";
        for (int i = 0; i < words.size() - 1; i++) {
            if (i == lValue || i == pValue) {
                out += "«";
                out += words.get(i) + "», ";
            } else {
                out += words.get(i) + ", ";
            }
        }
        if (words.size() - 1 == pValue) {
            out += "«";
            out += words.get(words.size() - 1) + "»";
        } else {
            out += words.get(words.size() - 1) + "]";
        }
        return out;
    }

    public static String printStringWithMarkers(String strn, int pValue) {
        String out = "";
        for (int i = 0; i < strn.length(); i++) {
            if (i == pValue) {
                out += "«" + String.valueOf(strn.charAt(i)) + "»";
            } else {
                out += String.valueOf(strn.charAt(i));
            }
        }
        return out;
    }

    public static String alienOrder(List<String> words) {
        HashMap<Character, List<Character>> adjList = new HashMap<Character, List<Character>>();
        // counts stores the number of unique letters
        System.out.println("\n\tGetting unique characters");
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (String word : words) {
            char[] strArray = word.toCharArray();
            for (char c : strArray) {
                count.put(c, 0);
            }
        }
        Set<Character> characters = count.keySet();
        System.out.println("\t\tdict_keys(" + characters + ")");

        // Step 1: We need to populate adj_list and counts.
        // For each pair of adjacent words...
        System.out.println("\n\tComparing adjacent words");
        int outer = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);
            System.out.println("\t\tLoop index: " + outer);
            System.out.println("\t\t" + printArrayWithMarkers(words, outer, outer + 1));
            outer += 1;
            System.out.println("\t\tWords to compare: " + word1 + ", " + word2);
            System.out.println("\t\tIterating the words");
            int inner = 0;
            int j = 0;
            for (j = 0; j < word1.length() || j < word2.length(); j++) {
                char c = word1.charAt(j), d = word2.charAt(j);
                System.out.println("\t\t\tInner loop index: " + inner);
                System.out.println("\t\t\t\tword1: " + printStringWithMarkers(word1, inner) + ", c = " + c);
                System.out.println("\t\t\t\tword2: " + printStringWithMarkers(word2, inner) + ", d = " + d);
                inner += 1;
                if (c != d) {
                    if (adjList.get(c) == null) {
                        adjList.put(c, new ArrayList<Character>());
                    }
                    if (adjList.get(d) == null) {
                        adjList.put(d, new ArrayList<Character>());
                    }
                    System.out.println("\t\t\t\tThe characters are not the same: ");
                    boolean found = false;
                    for (int k = 0; k < adjList.get(c).size(); k++) {
                        if (adjList.get(c).get(k) == d) found = true;
                    }
                    if (found == false) {
                        System.out.print("\t\t\t\t\tAdding '" + d + "' to " + c + "'s children: " + adjList.get(c) + " ⟶ ");
                        adjList.get(c).add(d);
                        System.out.println(adjList.get(c));
                        System.out.print("\t\t\t\t\tIncrementing count of '" + d + "' ⟶ ");
                        count.put(d, count.get(d) + 1);
                        System.out.println(count);
                    }
                    break;
                } else {
                    System.out.println("\t\t\t\tBoth characters are the same: '" + c + "', moving to the next character");
                }
            }
            // Check that second word isn't a prefix of first word.
            if (j >= word1.length() || j >= word2.length()) {
                if (word2.length() < word1.length()) return "";
            }
        }

        // Step 2: We need to repeatedly pick off nodes with an indegree of 0.
        List<Character> result = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : count.keySet()) {
            if (count.get(c) == 0) queue.add(c);
        }
        System.out.println("\n\tRemoving the sources");
        System.out.println("\t\tSources: " + queue);
        int m = 0;
        while (!queue.isEmpty()) {
            System.out.println("\t\tLoop index: " + m);
            m += 1;
            System.out.println("\t\t\tGetting the source by popping from the queue");
            System.out.print("\t\t\tSources: " + queue + " ⟶ ");
            char c = queue.removeFirst();
            System.out.println(queue);
            System.out.println("\t\t\t\tSource: " + c);
            System.out.print("\t\t\t\tAppending to the result list: " + result + " ⟶ ");
            result.add(c);
            System.out.println(result);
            System.out.println("\t\t\tUpdating the in-degrees of the children");
            System.out.println("\t\t\t\tSource: " + c + ", children: " + adjList.get(c));
            int n = 0;
            if (adjList.get(c) == null) {
                adjList.put(c, new ArrayList<>());
            }
            for (int f = 0; f < adjList.get(c).size(); f++) {
                char d = adjList.get(c).get(f);
                System.out.println("\t\t\t\tInner loop index: " + n);
                n += 1;
                System.out.println("\t\t\t\t\tChild: " + d);
                System.out.println("\t\t\t\t\tDecrementing in-degree of " + d + ": " + count.get(d) + " ⟶ " + (count.get(d) - 1));
                count.put(d, count.get(d) - 1);
                if (count.get(d) == 0) {
                    System.out.println("\t\t\t\t\tSince in-degree of " + d + " = 0, it's now a source.");
                    System.out.println("\t\t\t\t\tAdding it to the sources queue: " + queue + " ⟶ ");
                    queue.add(d);
                    System.out.println(queue);
                }
            }
        }
        return "None";
    }

    public static void main(String args[]) {
        List<List<String>> words = Arrays.asList(
                Arrays.asList("mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv"),
                Arrays.asList("vanilla", "alpine", "algor", "port", "norm", "nylon", "ophellia", "hidden"),
                Arrays.asList("passengers", "to", "the", "unknown"),
                Arrays.asList("alpha", "bravo", "charlie", "delta"),
                Arrays.asList("jupyter", "ascending"));

        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + 1 + ".\twords = " + words.get(i));
            alienOrder(words.get(i));
            System.out.println("\tDictionary = \"" + alienOrder(words.get(i)) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}