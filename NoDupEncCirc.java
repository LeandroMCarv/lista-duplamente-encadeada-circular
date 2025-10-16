package listaDuplamenteEncadeadaCircular;

public class NoDupEncCirc {
	private int valor;
	private NoDupEncCirc proximo;
	private NoDupEncCirc anterior;
	//getters and setters
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NoDupEncCirc getProximo() {
		return proximo;
	}
	public void setProximo(NoDupEncCirc proximo) {
		this.proximo = proximo;
	}
	public NoDupEncCirc getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDupEncCirc anterior) {
		this.anterior = anterior;
	}
	//constructor
	public NoDupEncCirc(int valor) {
		this.valor = valor;
		this.proximo = this;
		this.anterior = this;
	}
}
