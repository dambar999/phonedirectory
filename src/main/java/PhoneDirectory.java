import java.util.HashMap;

class TrieNode{
    HashMap<Character,TrieNode>child;
    boolean isLastCharacter;

    TrieNode(){
        child =new HashMap<>();
        isLastCharacter=false;
        for(char i='a';i<='z';i++){
            child.put(i,null);
        }
    }
}


public class PhoneDirectory {

   static  TrieNode root;

    static void displayContactsMatchingPrefix(TrieNode curNode,
                                    String prefix)
    {

        // Check if the string 'prefix' ends at this Node
        // If yes then display the string found so far
        if (curNode.isLastCharacter)
            System.out.println(prefix);

        // Find all the adjacent Nodes to the current
        // Node and then call the function recursively
        // This is similar to performing DFS on a graph
        for (char i = 'a'; i <= 'z'; i++)
        {
            TrieNode nextNode = curNode.child.get(i);
            if (nextNode != null)
            {
                displayContactsMatchingPrefix(nextNode, prefix + i);
            }
        }
    }

    public static void main(String[]args){

       String  contacts [] ={"cat","dogg","dogggy","cad","cadbury","caliber"};
        insertContact(contacts);
        //Test case 1
       TrieNode node1= search("ca");
        System.out.println("Test case 1.. ");
       if(node1==null){
           System.out.println("No Suggestion  matching ");
       }else
           displayContactsMatchingPrefix(node1,"ca");


       //Test Case 2
        System.out.println("Test case 2.. ");
        TrieNode node2= search("do");
        if(node2==null){
            System.out.println("No Suggestion  matching ");
        }else
            displayContactsMatchingPrefix(node2,"do");

        //Test Case 3
        System.out.println("Test case 3.. ");
        TrieNode node3= search("catt");
        if(node3==null){
            System.out.println("No Suggestion .... ");
        }else
            displayContactsMatchingPrefix(node3,"catt");



    }

    static void insertContact(String [] contacts ){

       root=new TrieNode();
      for(int i=0;i<contacts.length;i++){
         insert(contacts[i]);
         }

      }

    static   void insert(String contact){

         TrieNode temp=root;
        int len=contact.length();

        for(int i=0;i<len;i++){

            TrieNode nextNode= temp.child.get(contact.charAt(i));

            if(nextNode==null){

                nextNode=new TrieNode();
                temp.child.put(contact.charAt(i),nextNode);
            }

            temp=nextNode;
            if(i==len-1){
               temp.isLastCharacter=true;
            }
        }
    }
    static  TrieNode search(String key)
    {
        int level;
        int length = key.length();
        char index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level);

            if (pCrawl.child.get(index) == null)
                return null;

            pCrawl = pCrawl.child.get(index);
        }

        if (pCrawl != null){
            return pCrawl;
        }
        return null;
    }

}
