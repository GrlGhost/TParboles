package Main.Trees;

//    private DoubleNode <T> root;
//    public BinarySearchTree(){root = null;}
//    public BinarySearchTree(T o){root = new DoubleNode<T>(o);}
//    public BinarySearchTree(T o, BinarySearchTree<T> tLeft, BinarySearchTree<T> tRight){
//        root = new DoubleNode<>(o, tLeft.root, tRight.root);
//    }
//    public T getRoot(){return root.data;}
//    public BinarySearchTree<T> getLeft(){
//        BinarySearchTree<T> t = new BinarySearchTree<>();
//        t.root = root.left;
//        return t;
//    }
//    public BinarySearchTree<T> getRight(){
//        BinarySearchTree<T> t = new BinarySearchTree<>();
//        t.root = root.right;
//        return t;
//    }
//    public  boolean isEmpty(){return root == null;}
//
//
//    public void search(){
//    }
//
//    public void insert(T object){
//    }
//
//    public void delete(T object){
//    }
//
//    public void getMax(){
//    }
//
//    public void getMin(){
//    }
//
//    public boolean exists(Comparable<T> object){
//        boolean result = false;
//        if (getRoot() == object){
//            result = true;
//        }
//        else if (object.compareTo(getRoot()) > 0){
//            exists(getRight().getRoot());
//        }
//        else if(object.compareTo(getRoot()) < 0){
//            exists(getLeft().getRoot());
//        }
//        return result;
//    }
//}



public class BinarySearchTree <T>{
        // Implementacion de un arbol binario de busqueda no balanceado
        // Autor Alicia Gioia

        private DoubleNode<T> root;

        public BinarySearchTree(){
            root = null;
        }

        // precondicion: elemento a insertar no pertenece al árbol
        public void insert(Comparable <T> x){
            root = insert(root, x);
        }


        // precondicion: elemento a eliminar pertenece al árbol
        public void delete(Comparable <T> x){
            root = delete(root, x);
        }

        // precondicion: árbol distinto de vacío
        public T getMin(){
            return getMin(root).data;
        }

        // precondicion: árbol distinto de vacío
        public T getMax(){
            return getMax(root).data;
        }

        // precondicion: elemnto a buscar pertenece al arbol
        public T search(Comparable<T> x){
            return search(root, x).data;
        }

        // precondicion: -
        public boolean exists(Comparable<T> x){
            return exists(root, x);
        }

        // precondicion: -
        public boolean isEmpty(){
            return (root == null);
        }

        // precondición: árbol distino de vacío
        public T getRoot(){
            return root.data;
        }

        // precondición: árbol distino de vacío
        public BinarySearchTree<T> getLeft(){
            BinarySearchTree<T> t = new BinarySearchTree<T>();
            t.root = root.left;
            return t;
        }

        // precondición: árbol distino de vacío
        public BinarySearchTree<T> getRight(){
            BinarySearchTree<T> t = new BinarySearchTree<T>();
            t.root = root.right;
            return t;
        }


        // METODOS PRIVADOS
        private DoubleNode<T> getMax(DoubleNode <T> t){
            if (t.right == null)
                return t;
            else
                return getMax(t.right);
        }

        private DoubleNode <T> getMin(DoubleNode <T> t){
            if (t.left == null)
                return t;
            else
                return getMin(t.left);
        }

        private DoubleNode <T> search(DoubleNode <T> t, Comparable<T> x){
            if (x.compareTo(t.data)== 0)
                return t;
            else if (x.compareTo( t.data)< 0)
                return search(t.left, x);
            else
                return search(t.right, x);
        }

        private boolean exists(DoubleNode <T> t, Comparable<T> x) {
            if (t == null)
                return false;
            if (x.compareTo(t.data) == 0)
                return true;
            else if (x.compareTo( t.data)< 0)
                return exists(t.left, x);
            else
                return exists(t.right, x);
        }


        private DoubleNode<T> insert (DoubleNode <T> t, Comparable <T> x) {
            if (t == null){
                t = new DoubleNode<T>((T) x);
                t.data = (T) x;

            }
            else if (x.compareTo(t.data) < 0)
                t.left = insert(t.left, x);
            else
                t.right = insert(t.right, x);
            return t;
        }


        private DoubleNode<T> delete (DoubleNode<T> t, Comparable<T> x) {
            if (x.compareTo(t.data) < 0)
                t.left = delete(t.left, x);
            else if (x.compareTo(t.data) > 0)
                t.right = delete(t.right, x);
            else
            if (t.left != null && t.right != null ) {
                t.data = getMin(t.right).data;
                t.right = deleteMin(t.right);
            }
            else if (t.left != null)
                t = t.left;
            else
                t =t.right;
            return t;
        }

        private DoubleNode<T> deleteMin(DoubleNode<T> t){
            if (t.left != null)
                t.left = deleteMin(t.left);
            else
                t = t.right;
            return t;
        }
    }
