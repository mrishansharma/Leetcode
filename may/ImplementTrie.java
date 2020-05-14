/** Implement Trie (Prefix Tree)
* Solution
* Implement a trie with insert, search, and startsWith methods.
* Example:
* Trie trie = new Trie();
* 
* trie.insert("apple");
* trie.search("apple");   // returns true
* trie.search("app");     // returns false
* trie.startsWith("app"); // returns true
* trie.insert("app");   
* trie.search("app");     // returns true
* Note:
* You may assume that all inputs are consist of lowercase letters a-z.
* All inputs are guaranteed to be non-empty strings.
**/
class Trie {

    class Node
    {
        boolean isLast[] =new boolean[26] ;
        Node next[] = new Node[26];
    }
    Node root ;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char charWord[] = word.toCharArray();
        Node current= null,next = this.root;
        for(int i = 0;i<charWord.length;i++){
            char character = charWord[i];
            current = next;
            if(current.next[character - 'a']==null){
                current.next[character-'a'] = new Node();
            }    
            next = current.next[character-'a']; 
        }
        current.isLast[charWord[charWord.length-1]-'a']= true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char charWord[] = word.toCharArray();
        Node current= null,next = this.root;
        for(int i = 0;i<charWord.length;i++){
            char character = charWord[i];
            current = next;
            if(current.next[character - 'a']==null){
                return false;
            }    
            next = current.next[character-'a'];
        }
        return current.isLast[charWord[charWord.length-1]-'a'];       
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char charWord[] = prefix.toCharArray();
        Node current = this.root;
        for(int i = 0;i<charWord.length;i++){
            char character = charWord[i];
            if(current.next[character - 'a']==null){
                return false;
            }    
            current = current.next[character-'a'];
        }
        return true;
                
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */