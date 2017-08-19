package br.com.projeto.modelo.entidade.cargo;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.projeto.modelo.entidade.GenericDomain;

@Entity
@Table(name="cargo")
public class Cargo extends GenericDomain{

}
