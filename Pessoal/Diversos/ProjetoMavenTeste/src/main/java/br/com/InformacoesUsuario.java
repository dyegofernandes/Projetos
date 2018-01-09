package br.com;

import java.math.BigDecimal;

public class InformacoesUsuario {

	private Integer id;

	private String nome;

	private Integer qtdApareceu;

	private BigDecimal tempo;

	private String observacao;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public Integer getQtdApareceu() {
		return qtdApareceu;
	}

	public void setQtdApareceu( Integer qtdApareceu ) {
		this.qtdApareceu = qtdApareceu;
	}

	public BigDecimal getTempo() {
		return tempo;
	}

	public void setTempo( BigDecimal tempo ) {
		this.tempo = tempo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao( String observacao ) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "InformacoesUsuario [id=" + id + ", nome=" + nome + ", qtdApareceu=" + qtdApareceu + ", tempo=" + tempo + ", observacao=" + observacao + "]";
	}
}
