package arvore;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public T adicionar(T novoValor) {
        return super.adicionar(novoValor);
    }
    public void rotacaoDireita(No<T> no){
        No<T> aux = no.getFilhoLeft();
        no.setFilhoLeft(aux.getFilhoRight());
        no.getFilhoRight().setPai(no);
        aux.setFilhoRight(no);
        aux.setPai(no.getPai());
        if(no.getPai().getFilhoRight() == no){
            no.getPai().setFilhoRight(aux);
            no.setPai(aux);
        }else{
            no.getPai().setFilhoLeft(aux);
            no.setPai(aux);
        }
    }

    public void rotacaoEsquerda(No<T> no){
        No<T> aux = no.getFilhoRight();
        no.setFilhoRight(aux.getFilhoLeft());
        no.getFilhoRight().setPai(no);
        aux.setFilhoLeft(no);
        aux.setPai(no.getPai());
        if(no.getPai().getFilhoRight() == no){
            no.getPai().setFilhoRight(aux);
            no.setPai(aux);
        }else{
            no.getPai().setFilhoLeft(aux);
            no.setPai(aux);
        }
    }

    public int fatorBlanceamento(No<T> no){
        return calcularAltura(no.getFilhoRight()) - calcularAltura(no.getFilhoLeft());
    }
}
