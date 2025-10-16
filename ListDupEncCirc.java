package listaDuplamenteEncadeadaCircular;

public class ListDupEncCirc {
	private NoDupEncCirc cabeca;

	public NoDupEncCirc getCabeca() {
		return cabeca;
	}

	public void setCabeca(NoDupEncCirc cabeca) {
		this.cabeca = cabeca;
	}

	public ListDupEncCirc() {
		this.cabeca=null;
	}
	
	public boolean estaVazia() {
		return this.cabeca==null;
	}
	
	public void adicionarNo(NoDupEncCirc no) {
		if(estaVazia()) {
			this.cabeca=no;
		}else {
			NoDupEncCirc atual = this.cabeca;
			if(atual.getValor()>no.getValor()) {
				if(atual.getProximo()==atual) {
					no.setProximo(atual);
					no.setAnterior(atual);
					atual.setProximo(no);
					atual.setAnterior(no);
					this.cabeca=no;
				}else {
					atual.getAnterior().setProximo(no);
					no.setProximo(atual);
					no.setAnterior(atual.getAnterior());
					atual.setAnterior(no);
					this.cabeca=no;
				}
			}else {
				while(atual.getProximo()!=this.cabeca&&no.getValor()>atual.getValor()) {
					atual = atual.getProximo();
				}
				if(atual.getProximo()==this.cabeca) {
					if(atual.getValor()<no.getValor()) {
						atual.setProximo(no);
						no.setAnterior(atual);
						no.setProximo(this.cabeca);
						this.cabeca.setAnterior(no);
					}else {
						atual.getAnterior().setProximo(no);
						no.setAnterior(atual.getAnterior());
						no.setProximo(atual);
						atual.setAnterior(no);
					}
				}else {
					atual.getAnterior().setProximo(no);
					no.setAnterior(atual.getAnterior());
					no.setProximo(atual);
					atual.setAnterior(no);
				}
			}
		}
	}
//	public void adicionarNo(NoDupEncCirc no) {
//		if(estaVazia()) {
//			this.cabeca=no;
//		}
//		else {//nao esta vazia
//			NoDupEncCirc atual = this.cabeca;
//			if(atual.getValor()>no.getValor()) {//insere na cabeça
//				if(atual.getProximo()==atual) {//só tem a cabeça na lista
//					no.setAnterior(atual);
//					no.setProximo(atual);
//					atual.setAnterior(no);
//					atual.setProximo(no);
//					this.cabeca=no;
//				}
//				else {//tem mais de um nó na lista
//					no.setAnterior(atual.getAnterior());
//					no.setProximo(atual);
//					atual.getAnterior().setProximo(no);
//					atual.setAnterior(no);
//					this.cabeca=no;
//				}
//			}
//			else {//insere no meio ou no fim
//				while(atual.getProximo()!=this.cabeca&&atual.getValor()<no.getValor()) {
//					atual=atual.getProximo();
//				}
//				if(atual.getValor()<no.getValor()) {//vai inserir no final
//					if(atual.getProximo()==this.cabeca) {
//						atual.setProximo(no);
//						no.setAnterior(atual);
//						no.setProximo(this.cabeca);
//						this.cabeca.setAnterior(no);
//					}
//				}
//				else {//adiciona no meio
//					atual.getAnterior().setProximo(no);
//					no.setAnterior(atual.getAnterior());
//					atual.setAnterior(no);
//					no.setProximo(atual);
//				}
//			}
//		}
/*			INSERE SEMPRE NO FINAL
			NoDupEncCirc ultimo = this.cabeca.getAnterior();//pega o ultimo no da lista
			ultimo.setProximo(no);//o ultimo passa a apontar para um novo no
			no.setProximo(this.cabeca);//o novo no passa a apontar para a cabeca
			no.setAnterior(ultimo);//o novo no passa a ter como anterior, o antigo ultimo
			this.cabeca.setAnterior(no);//a cabeca passa a ter um outro anterior, que é o novo nó
*/
//	}
	
	public void adicionarCabeca(NoDupEncCirc no) {
		if(estaVazia()) {
			this.cabeca=no;
		}
		else {
			no.setProximo(this.cabeca); //o novo que será a cabeça apontará para a cabeça a ser substituida
			no.setAnterior(this.cabeca.getAnterior());//o anterior a nova cabeça é o anterior da cabeça a ser substituida que é o último nó da lista
			this.cabeca.setAnterior(no);//a cabeça a ser substituida passa a ter como anterior a nova cabeca
			this.cabeca=no;//finalmente a cabeca passa a ser o no inserido
			this.cabeca.getAnterior().setProximo(this.cabeca);//o ultimo no da lista passa a ter como proximo, a nova cabeça
		}
	}
	
	public void removerNo(int valor) {
		if(!estaVazia()) {
			NoDupEncCirc atual = this.cabeca;
			NoDupEncCirc anterior = null;
			if(atual.getValor()==valor) {//esta na cabeca
				if(this.cabeca.getProximo()==this.cabeca) {//so tem a cabeca na lista
					this.cabeca.setProximo(null);
					this.cabeca.setAnterior(null);
					this.cabeca=null;
				}else {//a cabeca nao esta sozinha na lista
					atual=this.cabeca.getProximo();
					atual.setAnterior(this.cabeca.getAnterior());
					this.cabeca.getAnterior().setProximo(atual);
					this.cabeca.setAnterior(null);
					this.cabeca.setProximo(null);
					this.cabeca=atual;
				}
			}else {//esta no meio ou no fim
				while(atual.getProximo()!=this.cabeca&&atual.getValor()!=valor) {
					anterior = atual;
					atual=atual.getProximo();				
				}
				if(atual.getValor()==valor) {//encontrou o valor
					if(atual.getProximo()!=this.cabeca) {//esta no meio
						anterior.setProximo(atual.getProximo());
						atual.getProximo().setAnterior(anterior);
						atual.setAnterior(null);
						atual.setProximo(null);
					}
					else {//esta no fim
						anterior.setProximo(this.cabeca);
						this.cabeca.setAnterior(anterior);
						atual.setProximo(null);
						atual.setAnterior(null);
					}
				}
			}
		}
	}

	public void limparLista() {
		if(!estaVazia()) {
			NoDupEncCirc atual = this.cabeca;
			while(atual.getProximo()!=this.cabeca) {
				NoDupEncCirc proximo = atual.getProximo();
				atual.setProximo(null);
				atual.setAnterior(null);
				atual=proximo;
			}
			atual.setAnterior(null);
			atual.setProximo(null);
			this.cabeca=null;
		}
	}
	
	public NoDupEncCirc buscarNo(int valor) {
		if(!estaVazia()) {
			NoDupEncCirc atual = this.cabeca;
			while(atual.getProximo()!=this.cabeca) {//percorre toda a lista
				if(atual.getValor()==valor) {//verifica da cabeca ate o penultimo elemento
					return atual;
				}
				atual=atual.getProximo();
			}
			if(atual.getValor()==valor) {//verifica na posicao final
				return atual;
			}else {//nao encontrou nada entao retorna null
				return null;
			}
		}else {//a lista esta vazia entao retorna null
			return null;
		}
	}
	
	public String toString() {
		if(estaVazia()) {
			return "";
		}else {
			String retorno = "";
			NoDupEncCirc atual = this.cabeca;
			while(atual.getProximo()!=this.cabeca) {
				retorno+= atual.getValor() + ",";
				atual=atual.getProximo();
			}
			retorno+=atual.getValor();
			return retorno;
		}
	}
}