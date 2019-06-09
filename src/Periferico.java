
public class Periferico implements Comparable<Periferico>{
	private String nome;
	private int nivelprioridade;
	private int tempoExecucao;
	public static boolean ordenacaoCrescente;
	
	@Override
    public int compareTo(Periferico periferico) {
		if(ordenacaoCrescente) {
			if (this.nivelprioridade < periferico.getNivelprioridade()) {
		          return -1;
		     }
		     if (this.nivelprioridade > periferico.getNivelprioridade()) {
		          return 1;
		     }
		     return 0;
		}else {
			if (this.nivelprioridade > periferico.getNivelprioridade()) {
		          return -1;
		     }
		     if (this.nivelprioridade < periferico.getNivelprioridade()) {
		          return 1;
		     }
		     return 0;
		}
		
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNivelprioridade() {
		return nivelprioridade;
	}
	public void setNivelprioridade(int nivelprioridade) {
		this.nivelprioridade = nivelprioridade;
	}
	public int getTempoExecucao() {
		return tempoExecucao;
	}
	public void setTempoExecucao(int tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}
	
	
}
