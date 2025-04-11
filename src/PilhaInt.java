public class PilhaInt {
    NoPilhaInt pilha;

    public PilhaInt() {}

    public boolean isEmpty() {
        return pilha == null;
    }
    public void push(int info){
        if(isEmpty())
            pilha = new NoPilhaInt(info,null);
        else
            pilha = new NoPilhaInt(info,pilha);
    }
    public int pop(){
        if(!isEmpty()){
            int info = pilha.getInfo();
            pilha = pilha.getProx();
            return info;
        }
        return -1;
    }
}
