public class Lista {
    NoLista inicio, fim;

    public Lista() {}


    public void insereListaInicio(int info) {
        if(inicio == null)
            inicio = fim = new NoLista(info);
        else{
            NoLista nc = new NoLista(null, inicio, info);
            inicio.setAnt(nc);
            inicio = nc;
        }
    }
    public void insereListaFim(int info) {
        if (fim == null)
            inicio = fim = new NoLista(info);
        else{
            NoLista nc = new NoLista(fim, null, info);
            fim.setProx(nc);
            fim = nc;
        }

    }
    public void exibirLista(){
        NoLista aux = inicio;
        while(aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }

        /*NoLista aux = fim;
        while(aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getAnt();
        }*/
    }

    private int length(){
        NoLista ini;
        int i;
        for(ini = inicio,i = 0; ini != null; ini = ini.getProx(),i++);
        return i;
    }

    private NoLista posiciona(NoLista pos, int posAtu, int posDist){
        if (posDist > posAtu){
            while(posAtu != posDist){
                pos = pos.getProx();
                posAtu++;
            }
            return pos;
        }
        while(posAtu != posDist){
            pos = pos.getAnt();
            posAtu--;
        }
        return pos;
    }

    private NoLista posicionaDps(NoLista pos, int posAtu, int posDist){
        while(posAtu != posDist){
            pos = pos.getProx();
            posAtu++;
        }
        return pos;
    }

    private NoLista posicionaAnt(NoLista pos, int posAtu, int posDist){
        while(posAtu != posDist){
            pos = pos.getAnt();
            posAtu--;
        }
        return pos;
    }

    public int max(){
        int M = inicio.getInfo();
        NoLista aux = inicio.getProx();
        while (aux != null){
            if(aux.getInfo() > M)
                M = aux.getInfo();
            aux = aux.getProx();
        }
        return M;
    }

    public int min(){
        int m = inicio.getInfo();
        NoLista aux = inicio.getProx();
        while (aux != null){
            if(aux.getInfo() < m)
                m = aux.getInfo();
            aux = aux.getProx();
        }
        return m;
    }

    public void insercaoDireta(){
        NoLista pi, ppos;
        int aux;

        if(length() > 1)
            for(pi = inicio.getProx(); pi != null; pi = pi.getProx()) {
                ppos = pi;
                aux = pi.getInfo();
                while(ppos != inicio && aux < ppos.getAnt().getInfo()){
                    ppos.setInfo(ppos.getAnt().getInfo());
                    ppos = ppos.getAnt();
                }
                ppos.setInfo(aux);
            }
    }

    private NoLista buscaBinaria(int tl, int info, NoLista aux){
        int ini = 0, fim = tl, meio = fim/2;

        aux = posicionaAnt(aux, tl, meio);

        while(ini < fim && info != aux.getInfo()){
            if(info > aux.getInfo())
                ini = meio + 1;
            else fim = meio - 1;
            int pos = meio;
            meio = (ini + fim)/2;
            aux = posiciona(aux, pos, meio);
        }
        if(info > aux.getInfo())
            return aux.getProx();
        return aux;
    }
    public void insercaoBinaria(){
        NoLista pa, pos;
        int info,i;

        for(pa = inicio.getProx(), i= 1; pa != null; pa = pa.getProx(), i++) {
            info = pa.getInfo();
            pos = buscaBinaria(i, info, pa);
            for (NoLista aux = pa;aux != pos;aux = aux.getAnt())
                aux.setInfo(aux.getAnt().getInfo());
            pos.setInfo(info);
        }
    }

    public void selecaoDireta(){
        for(NoLista i = inicio; i.getProx() != null; i = i.getProx()){
            NoLista pos_m = i;
            for (NoLista j = i.getProx(); j != null; j = j.getProx())
                if(pos_m.getInfo() > j.getInfo())
                    pos_m = j;
            int info = i.getInfo();
            i.setInfo(pos_m.getInfo());
            pos_m.setInfo(info);
        }
    }

    public void bubleSort(){
        int tl = length();
        boolean flag = true;

        while (tl > 1 && flag){
            flag = false;
            NoLista aux;
            int i;
            for(i = 0, aux = inicio; i < tl - 1; aux = aux.getProx(), i++)
                if(aux.getInfo() > aux.getProx().getInfo()){
                    int info = aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(info);
                    flag = true;
                }
            tl--;
        }
    }

    public void shakeSort(){
        NoLista ini = inicio, fim = this.fim;
        int info;
        boolean flag = true;

        while (ini != fim && flag){
            flag = false;
            for(NoLista aux = ini; aux != fim; aux = aux.getProx())
                if(aux.getInfo() > aux.getProx().getInfo()){
                    info = aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(info);
                    flag = true;
                }
            fim = fim.getAnt();
            if (flag){
                flag = false;
                for (NoLista aux = fim; aux != ini; aux = aux.getAnt())
                    if(aux.getInfo() < aux.getAnt().getInfo()){
                        info = aux.getInfo();
                        aux.setInfo(aux.getAnt().getInfo());
                        aux.getAnt().setInfo(info);
                        flag = true;
                    }
                ini = ini.getProx();
            }
        }
    }

    public void shellSort(){
        int pos, i, aux , dist = 1, tam = length();
        NoLista indice = inicio, ant, atu;

        while(dist < tam)
            dist = dist * 3 + 1;

        for(dist /= 3, indice = fim, i = tam - 1; dist > 0; dist /= 3, indice = inicio, i = 0)
            for (indice = posiciona(indice, i, dist),i = dist; i < tam; i++, indice = indice.getProx()){
                aux = indice.getInfo();
                pos = i;
                atu = indice;
                ant = posicionaAnt(atu, pos, pos - dist);
                while (pos >= dist && aux < ant.getInfo()){
                    atu.setInfo(ant.getInfo());
                    pos -= dist;
                    atu = ant;
                    if(pos >= dist)
                        ant = posicionaAnt(atu, pos + dist, pos);
                }
                atu.setInfo(aux);
            }
    }

    public void heapSort(){
        int posPai, posFE, posFD;
        NoLista pai, FE, FD, maiorF;

        for(int tl = length(); tl > 1; tl--){
            for (pai = posiciona(inicio, 0, tl/2 -1), posPai = tl / 2 - 1; posPai >= 0; posPai--, pai = pai.getAnt()){
                posFE = posPai * 2 + 1;
                posFD = posPai * 2 + 2;
                maiorF = FE = posicionaDps(pai, posPai, posFE);
                if(posFD < tl){
                    FD = FE.getProx();
                    if(FD.getInfo() > FE.getInfo())
                        maiorF = FD;
                }
                if(pai.getInfo() < maiorF.getInfo()){
                    int aux = pai.getInfo();
                    pai.setInfo(maiorF.getInfo());
                    maiorF.setInfo(aux);
                }
                int aux = inicio.getInfo();
                NoLista aux2 = posicionaDps(FE, posFE, tl-1);
                inicio.setInfo(aux2.getInfo());
                aux2.setInfo(aux);
            }
        }
    }

    public void quickSortSemPivo(){
        quickSortSP(inicio, fim, 0, length() - 1);
    }
    private void quickSortSP(NoLista ini, NoLista fim, int posi, int posj) {
        NoLista i = ini, j = fim;
        boolean flag = true;
        int aux, posIni = posi, posFim = posj;

        while(posi < posj) {
            if(flag)
                while (posi < posj && i.getInfo() <= j.getInfo()) {
                    posi++;
                    i = i.getProx();
                }
            else
                while (posi < posj && j.getInfo() >= i.getInfo()) {
                    posj--;
                    j = j.getAnt();
                }
            aux = i.getInfo();
            i.setInfo(j.getInfo());
            j.setInfo(aux);
            flag = !flag;
        }
        if(posIni < posi - 1)
            quickSortSP(ini,i.getAnt(), posIni, posi-1);
        if(posj < posFim)
            quickSortSP(j.getProx(),fim,posj+1,posFim);
    }

    public void quickComPivo(){
        quickCP(inicio, fim, 0, length()-1);
    }
    private void quickCP(NoLista ini, NoLista fim, int posInicio, int posFim) {
        int posi= posInicio, posj= posFim, pivo = posicionaDps(ini,posi, (posi+posj)/2).getInfo();
        NoLista i = ini, j = fim;

        while(posi < posj){
            while (i.getInfo() < pivo) {
                i = i.getProx();
                posi++;
            }
            while (j.getInfo() > pivo) {
                j = j.getAnt();
                posj--;
            }
            if(posi <= posj) {
                int aux = i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                i = i.getProx();
                j = j.getAnt();
                posi++;
                posj--;
            }
        }
        if(posInicio < posj)
            quickCP(ini, j, posInicio, posj);
        if(posi < posFim)
            quickCP(i, fim, posi, posFim);
    }

    private void particao(Lista lista1, Lista lista2) {
        int tl = length(), meio = tl/2;
        NoLista aux = inicio.getProx();

        lista1.inicio = new NoLista(inicio.getInfo());
        NoLista l1 = lista1.inicio;
        for (int i = 1; i < meio; i++) {
            l1.setProx(new NoLista(aux.getInfo()));
            l1 = l1.getProx();
            aux = aux.getProx();
        }

        lista2.inicio = new NoLista(aux.getInfo());
        NoLista l2 = lista2.inicio;
        aux = aux.getProx();
        for (int i = meio + 1; i < tl; i++) {
            l2.setProx(new NoLista(aux.getInfo()));
            l2 = l2.getProx();
            aux = aux.getProx();
        }
    }
    private void fusao(Lista lista1, Lista lista2, int seq) {
        NoLista aux = inicio;
        NoLista l1 = lista1.inicio;
        NoLista l2 = lista2.inicio;
        int i,j, sum = seq;

        for(i = j = 0; aux != null; ) {
            while(i < seq && j < seq) {
                if (l1.getInfo() < l2.getInfo()) {
                    aux.setInfo(l1.getInfo());
                    l1 = l1.getProx();
                    i++;
                } else {
                    aux.setInfo(l2.getInfo());
                    l2 = l2.getProx();
                    j++;
                }
                aux = aux.getProx();
            }
            while (i < seq){
                aux.setInfo(l1.getInfo());
                l1 = l1.getProx();
                i++;
                aux = aux.getProx();
            }
            while (j < seq) {
                aux.setInfo(l2.getInfo());
                l2 = l2.getProx();
                j++;
                aux = aux.getProx();
            }
            seq += sum;
        }
    }
    public void mergeSort() {
        int seq = 1,  tl = length();
        while (seq < tl) {
            Lista lista1 = new Lista();
            Lista lista2 = new Lista();
            particao(lista1,lista2);
            fusao(lista1,lista2, seq);
            seq *= 2;
        }
    }

    public void countingSort() {
        int M = max();
        NoLista aux;

        int[] vet = new int[M + 1];
        for(aux = inicio; aux != null; aux = aux.getProx())
            vet[aux.getInfo()]++;

        for(int i = 1; i < vet.length; i++)
            vet[i] += vet[i - 1];

        NoLista ordenado = new NoLista();
        int tam = length();
        NoLista lista = ordenado;
        int i;
        for (i = 1; i < tam; i++) {
            lista.setProx(new NoLista());
            lista.getProx().setAnt(lista);
            lista = lista.getProx();
        }

        aux = fim;
        fim = lista;
        inicio = ordenado;
        for(; aux != null; aux = aux.getAnt()){
            lista = posiciona(lista,i,vet[aux.getInfo()]);
            i = vet[aux.getInfo()];
            lista.setInfo(aux.getInfo());
            vet[aux.getInfo()]--;
        }
    }

    public void bucketSort(){
        int max = max();
        int min = min();
        int baldes = (int) Math.ceil(Math.sqrt(max - min + 1));
        int intervalo = (max - min + 1) / baldes;
        Lista[] bucket = new Lista[baldes];

        for (int i = 0; i < bucket.length; i++)
            bucket[i] = new Lista();

        for (NoLista aux = inicio; aux != null; aux = aux.getProx()) {
            int pos = Math.min((aux.getInfo() - min) / intervalo, baldes - 1);
            bucket[pos].insereListaInicio(aux.getInfo());
        }

        for (int i = 0; i < bucket.length; i++)
            bucket[i].insercaoDireta();

        NoLista lista = inicio;
        for (int i = 0; i < bucket.length; i++) {
            for (NoLista aux = bucket[i].inicio; aux != null; aux = aux.getProx()){
                lista.setInfo(aux.getInfo());
                lista = lista.getProx();
            }
        }
    }

    public void radixSort() {
        int max = max();
        for(int dgt = 1; dgt <= max; dgt *= 10) {
            int[] couting = new int[10];

            for (NoLista aux = inicio; aux != null; aux = aux.getProx())
                couting[(aux.getInfo()/dgt) % 10]++;

            for (int i = 1; i < 10; i++)
                couting[i] += couting[i - 1];

            int tam = length();
            NoLista lista = new NoLista();
            NoLista ini_lista = lista;
            int i;
            for (i = 1; i < tam; i++) {
                lista.setProx(new NoLista());
                lista.getProx().setAnt(lista);
                lista = lista.getProx();
            }

            NoLista aux = fim;
            fim = lista;
            inicio = ini_lista;
            for(; aux != null; aux = aux.getAnt()){
                lista = posiciona(lista,i,couting[(aux.getInfo()/dgt) % 10]);
                i = couting[(aux.getInfo()/dgt) % 10];
                lista.setInfo(aux.getInfo());
                couting[(aux.getInfo()/dgt) % 10]--;
            }
        }
    }

    public void combSort(){
        int tam = length(), intervalo = (int) (tam/1.3),  i = 0;
        NoLista aux;
        while(intervalo > 0 && i < tam){
            i = 0;
            aux = inicio;
            NoLista aux2 = posicionaDps(aux, 0, intervalo);
            while (i + intervalo < tam){
                if (aux.getInfo() > aux2.getInfo()){
                    int info = aux.getInfo();
                    aux.setInfo(aux2.getInfo());
                    aux2.setInfo(info);
                }
                i++;
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
            intervalo = (int) (intervalo/1.3);
        }
    }


    public void gnomeSort(){
        NoLista aux = inicio;

        while (aux != null) {
            if(aux == inicio)
                aux = aux.getProx();
            if (aux.getInfo() >= aux.getAnt().getInfo())
                aux = aux.getProx();
            else{
                int info = aux.getInfo();
                aux.setInfo(aux.getAnt().getInfo());
                aux.getAnt().setInfo(info);
                aux = aux.getAnt();
            }
        }
    }
}
