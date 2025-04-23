package com.unl.music.base.controller.dataStruct.list;

    public class linkedList <E>{
        private Node <E> head;
        private Node <E> last;
        private Integer length;
    
        public Integer getLength() {
            return this.length;
        }
    
    
        public linkedList(){
            head=null;
            last=null;
            length=0;
        }
    
        public Boolean isEmpty(){
            return head == null || length ==0;
        }
    
        private Node<E> getNode(Integer pos) {
            if(isEmpty()){
                throw new ArrayIndexOutOfBoundsException("Lista vacìa");
                //System.out.println("Lista vacia");
                //return null;
            } else if(pos < 0 || pos >= length){
                //System.out.println("Fuera de rango");
                //return null;
                throw new ArrayIndexOutOfBoundsException("fuera de rango...");
            } else if(pos==0){
                return head;
            }else if ((length.intValue()-1) == pos.intValue()){
                return last;
            }else{
                Node<E> search = head;
                Integer cont = 0;
                while(cont < pos){
                    cont++;
                    search = search.getNext();
                }
                return search; 
            }
        }
               
        private E getDataFirst(){
            if(isEmpty()){
                throw new ArrayIndexOutOfBoundsException("Lista vacìa");
            }else{
                return head.getData();
            }
        }
    
        private E getDataLast(){
            if(isEmpty()){
                throw new ArrayIndexOutOfBoundsException("Lista vacìa");
            }else{
                return last.getData();
            }
        }
    
        private E get(Integer pos) throws ArrayIndexOutOfBoundsException{
            /*if(isEmpty()){
                throw new ArrayIndexOutOfBoundsException("Lista vacìa");
                //System.out.println("Lista vacia");
                //return null;
            } else if(pos < 0 || pos >= length){
                //System.out.println("Fuera de rango");
                //return null;
                throw new ArrayIndexOutOfBoundsException("fuera de rango");
            } else if(pos==0){
                return getDataFirst();
            }else if (length.intValue() == pos.intValue()){
                return getDataLast();
        }*/
        return getNode(pos).getData();
        }   
    
    
        private void addFirst(E data){
            if(isEmpty()){
                Node<E> aux=new Node<>(data);
                head =aux;
                last=aux;
            }else{
                Node<E> head_old=head;
                Node<E> aux = new Node<>(data, head_old);
                aux.setNext(head_old);
                head=aux;
            }
            length++;
        }
    
    private void addLast(E data){
        if(isEmpty()){
            addFirst(data);
        }else{
            Node<E> aux=new Node<>(data);
            last.setNext(aux);
            last=aux;
            length++;
        }
    }
    
        public void add(E data, Integer pos) throws Exception{
            if(pos==0){
                addFirst(data);
            }else if(length.intValue()==pos.intValue()){
               addLast(data);
    
            }else{
                Node<E> search_preview =getNode(pos -1);
                Node<E> search =getNode(pos);
    
                Node<E> aux= new Node<>(data, search);
                search_preview.setNext(aux);
                length++;
            }
    
        }
    
        public void add(E data){
            addLast(data);
        }
    
    
        public String print(){
            if(isEmpty())
                return "Esta vacia";
            else{
                StringBuilder resp= new StringBuilder();
                Node<E> help=head;
                while(help != null){
                    resp.append(help.getData()).append(" - ");
                    help=help.getNext();
                }
                resp.append("\n");
                return resp.toString();
            }
        }
    
    
        public void update(E data, Integer pos){
            getNode(pos).setData(data);
        }
    
        public void deleteHead(){
            head=head.getNext();
            length--;
    
            if (head == null) { 
                last = null;
            }
        }
    
        public void deleteLast(){
            if (length == 1) {
                clear(); 
                length--;
                return;
            }
    
            Node<E> previous_Last =getNode((length.intValue())-2);
            previous_Last.setNext(null);
            last=previous_Last;
            length--;
    
            if (last == null) { 
                head = null;
            }
        }
    
        public void delete(Integer pos){
            if(pos < 0 || pos >= length){
                throw new ArrayIndexOutOfBoundsException("fuera de rango...");
            }
            if(pos==0){
                deleteHead();
            }else if(pos==length-1){
                deleteLast();
            }else{
                Node<E> previous =getNode(pos -1);
                Node<E> search =getNode(pos);
    
                previous.setNext(search.getNext());
                length--;
            }
            
        }
    
        public void clear(){
            head=null;
            last=null;
            length=0;
        }
        public static void main(String[] args) {
            linkedList<Double> lista = new linkedList<>();
            try{
                lista.add(56.7);
                lista.add(65.7);
                lista.add(56.7, 0);
                lista.add(4.7);
                lista.add(9.0, 3);
                lista.add(-1.0, lista.getLength());
                System.out.println(lista.print());
                //System.out.println(lista.get(lista.getLength()-1));
                System.out.println("Actualizar ");
                lista.update(10.0, 0);
                System.out.println(lista.print());
                System.out.println(lista.length);
                lista.deleteHead();
                System.out.println("Eliminar cabeza ");
                System.out.println(lista.length);
                System.out.println(lista.print());
    
                System.out.println("Eliminar cola");
                lista.deleteLast();
                System.out.println(lista.length);
                System.out.println(lista.print());
                lista.delete(3);
                System.out.println("Eliminar ");
                System.out.println(lista.length);
                System.out.println(lista.print());
                System.out.println("Tamaño ");
                System.out.println(lista.length);
            }catch(Exception e){
                System.out.println("Error "+e);
            }
        }    
    }

}
