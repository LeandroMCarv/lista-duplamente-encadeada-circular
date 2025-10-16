package listaDuplamenteEncadeadaCircular;

public class Main {
	public static void main(String[] args) {
		ListDupEncCirc lista = new ListDupEncCirc();
		lista.adicionarNo(new NoDupEncCirc(1));
		lista.adicionarNo(new NoDupEncCirc(3));
		lista.adicionarNo(new NoDupEncCirc(2));
		lista.adicionarNo(new NoDupEncCirc(7));
		lista.adicionarNo(new NoDupEncCirc(4));
		System.out.println(lista.toString());
	}
}
