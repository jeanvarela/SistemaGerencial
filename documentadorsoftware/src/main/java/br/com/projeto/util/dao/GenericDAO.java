package br.com.projeto.util.dao;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.projeto.infraestrutura.util.Util;
import br.com.projeto.modelo.entidade.GenericDomain;
import br.com.projeto.modelo.entidade.cargo.Cargo;
import br.com.projeto.util.jpa.JPAUtil;
import br.com.projeto.util.mensagens.MensagensUtil;

/**
 * Classse utilizada para aceessar o banco de dados
 */
public class GenericDAO<T> implements IGenericDAO<T> {
	
	
	private Class<T> classe;
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.classe = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.manager = JPAUtil.getEntityManager();
	}

	@Override
	public Long salvar(GenericDomain entidade) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entidade);
		transaction.commit();
		
		return entidade != null ? entidade.getCodigo() : null;
	}
	

	@SuppressWarnings("unchecked")
	public List<T> listar( String... propriedades){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classe);
		
		if (Util.verificarStringVarArgComElementosNulo(propriedades)) {
			for (String propriedade : propriedades) {
				try {
					Object valor = PropertyUtils.getProperty(classe, propriedade);
					if (valor != null) {
						if (valor instanceof String) {
							criteria.add(Restrictions.ilike(propriedade, (String) valor, MatchMode.ANYWHERE));
						} else {
							criteria.add(Restrictions.eq(propriedade, valor));
						}
					}


				} catch (Exception e) {
					throw new RuntimeException(MensagensUtil.getMensagem("propriedadeNaoEncontrada"), e);
				}
			}
		}
		
		return criteria.list();
	}
	
	@Override
	public T buscar(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		T objeto = manager.find(classe, id);
		manager.close();
		
		return objeto;
	}
	
	@Override
	public void excluir(T entidade){
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		Object objetoGerenciado = manager.merge(entidade);
		
		manager.remove(objetoGerenciado);
		
		transaction.commit();
		manager.close();
    }
		
	@Override
	public GenericDomain editar(GenericDomain entidade) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();		
		transaction.begin();
		
		GenericDomain entidadeAtualizada = manager.merge(entidade);
		
		transaction.commit();
		manager.close();
		
		return entidadeAtualizada;
	}
	
	protected Session getSession() {
		return manager.unwrap(Session.class);
	}
	
	protected EntityManager getEntityManager(){
		return this.manager;
	}
}
