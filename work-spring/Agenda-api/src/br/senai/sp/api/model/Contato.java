package br.senai.sp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //← anotação que diz para o spring que essa classe é uma tabela no banco 
@Table(name = "tbl_contato") //← Anotação dizendo que o spring vai encontrar uma tabela com esse nome 
public class Contato{
	@Id//← Dizendo para o spring que o campo id e a chave primaria identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY)// ← dizendo que o id e o indetificador da tabela
	private Long id;
	@NotNull// Dizendo que o nome é not null
	@Size(min=5,max=100)// Dizendo que o minimo de caracteres são 5 e no maximo 1000	
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private String linkedin;
	private String foto;
	//POJO => CLASS JAVA COM ATRIBUTOS DE CLASSE E GET E SET 
//	se no banco tiver uma tabela com enderescor, no java usamos o camelcase exemplo 'banco: idade_contato' 'Java: idadeContato' isso é feito para 
//	o usso do spring que coloca o anderescor altomaticamente no codigo
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco="
				+ endereco + ", linkedin=" + linkedin + ", foto=" + foto + "]";
	}

	
	
	
}
