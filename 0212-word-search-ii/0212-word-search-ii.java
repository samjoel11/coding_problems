class Solution {
    public class Node{
        char ch;
        HashMap<Character,Node> child = new HashMap<>();
        String isTerminal;
    }
    Node root;
    public void insert(String word){
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.child.containsKey(ch)){
                temp = temp.child.get(ch);
            }
            else{
                Node nn = new Node();
                nn.ch = ch;
                temp.child.put(ch,nn);
                temp = nn;
            }
        }
        temp.isTerminal = word;
    }
    public String startWith(String word){
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.child.containsKey(ch)){
                return null;
            }
            temp = temp.child.get(ch);
            if (temp.isTerminal != null) return temp.isTerminal;
        }
        
        return null;
    }
    public void search(char[][] board, int i, int j, Node nn){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || (!nn.child.containsKey(board[i][j]))){
            return  ;
        }

        char ch = board[i][j];
        nn = nn.child.get(ch);
        if(nn.isTerminal != null){
            ans.add(nn.isTerminal);
            nn.isTerminal = null;
        }
        board[i][j] = '*';
        search(board,i+1,j,nn);
        search(board,i,j+1,nn);
        search(board,i-1,j,nn);
        search(board,i,j-1,nn);
        board[i][j] = ch;
    }
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node nn = new Node();
        nn.ch = '*';
        root = nn;
        for(String s : words){
            insert(s);
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(root.child.containsKey(board[i][j])){
                    search(board,i,j,root);
                }
            }
        }
        return ans;
    }
}