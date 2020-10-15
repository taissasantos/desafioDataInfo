package ds.github.taissasantos.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telefones> telefones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefones> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefones> telefones) {
        this.telefones = telefones;
    }
}
