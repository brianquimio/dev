package fundamentals;


import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

    public class TrieNode {
        public HashMap<Character, TrieNode> children;
        public boolean terminates = false;
        public char c;

        public TrieNode() {
            children = new HashMap<>();
        }

        public TrieNode(char c) {
            this();
            this.c = c;
        }

        public void addWord (String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            char first = word.charAt(0);

            TrieNode child = getChild(first);
            if(child == null) {
                child = new TrieNode(first);
                children.put(first, child);
            }

            if (word.length() > 1) {
                child.addWord(word.substring(1));
            } else {
                child.setTerminates(true);
            }

        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public void setTerminates(boolean t) {
            t = terminates;
        }

        public boolean terminates() {
            return terminates;
        }

    }

    public TrieNode root;

    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode last = root;
        for(int i=0; i<prefix.length(); i++) {
            last = last.getChild(prefix.charAt(i));
            if(last == null) {
                return false;
            }
        }

        return !exact || last.terminates();
    }





}
