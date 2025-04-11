public class PilhaLista {
    NoPilhaLista pilha;

    public PilhaLista() {}

    public boolean isEmpty() {
        return pilha == null;
    }
    public void push(NoLista info){
        if(isEmpty())
            pilha = new NoPilhaLista(info,null);
        else
            pilha = new NoPilhaLista(info,pilha);
    }
    public NoLista pop(){
        if(!isEmpty()){
            NoLista info = pilha.getInfo();
            pilha = pilha.getProx();
            return info;
        }
        return null;
    }
}
