import java.util.Arrays;
import java.util.List;

public class Tree<T>{
    /*
    A recursive tree data structure, which provides services required of the
           MultiSet ADT. See TreeMultiSet, which is the next class defined.

           This is a simplified version of the Tree data structure
           adapted from CSC148.
     */

    // Instance attributes
    private T root;
    private Tree<T>[] subtrees;

    // constructor when only given root
    Tree(T root) {
        this.root = root;
    }

    // constructor when given root and subtrees
    Tree(T root, Tree<T>[] subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public boolean is_empty() {
        return this.root == null;
    }

    public int __len__() {
        if (this.is_empty()) {
            return 0;
        } else {
            int size = 1;

            for(Tree tree: this.subtrees)
                size += tree.__len__();
            return size;
        }
    }

    public int count(T item) {
        if (this.is_empty()) {
            return 0;
        } else {
            int num = 0;
            if (this.root == item) {
                num +=1;
            }
            for (Tree subtree:
                 this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }
    public String __str__() {
        return this.String_indented();
    }

    private String String_indented(int depth) {
        if (this.is_empty()){
            return "";
        } else {
            String s = repeat(depth, "  ") + this.root.toString() + "\n";
            for (Tree subtree:
                    this.subtrees) {
                s += subtree.String_indented(depth + 1);
            }
            return s;

        }
    }

    // default
    private String String_indented() {

        int depth = 0;
        if (this.is_empty()){
            return "";
        } else {
            String s = repeat(depth, "  ") + this.root.toString() + "\n";
            for (Tree subtree:
                    this.subtrees) {
                s += subtree.String_indented(depth + 1);
            }
            return s;

        }
    }

    private static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public float average() {
        return (float)0.0;
    }

    private float average_helper() {
        return (float)0.0;
    }

    public boolean __contains__(T item) {
        return false;
    }

    public List<?> leaves() {
        return this.leaves();
    }

    //Mutating

    public boolean delete_item(T item) {
        return false;
    }

    private void delete_root() {

    }

    private T extract_leaf() {
        return root;
    }

    public void insert(T item) {

    }

    public boolean insert_child(T item, T parent ) {
        return true;
    }

    public static void main(String[] args) {
        // test suite
        Tree t = new Tree(null);
        System.out.println(t.is_empty());
        System.out.println(t.__len__());
    }

}


