package com.ideas.app.conf;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/***
 * Clase de configuracio para acceso a los datos de app 
 */

@Configuration
@EnableTransactionManagement
// paquete de los repositorios, las interface de los crud
@EnableJpaRepositories("com.ideas.app.repository")

// paquetes de servicio, que implementa las interfaces de crud
@ComponentScan("com.ideas.app.service")
public class AppRootConfig {

	
	/**
	 * Bean encargado de conectar a la base de datos
	 * @return retorna una dataSource  de conexion
	 */
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("Losmaspepas2018");
		dataSource.setUrl("jdbc:mysql://localhost:3306/AGENCIA?serverTimezone=UTC");
		return dataSource;

	}

	
	/**
	 * Bean encargado de acceder a los datos, requiere de un objeto dataSource y del tipo de implementacion para JPA
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		// Asignar el dataSoruce
		factoryBean.setDataSource(getDataSource());
		// El manejador de la implementacion de JPA
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		// indicamos en que paquete se encuentran las clases anotadas para JPA,
		factoryBean.setPackagesToScan("com.ideas.app.jpa.model");
		factoryBean.setPersistenceUnitName("pun-hibernate-jpa");
		return factoryBean;
	}

	
	/**
	 * Manejador de la implementacion de JPA, nosotros estamos utilizando Hibernate
	 * @return
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(false);
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		return jpaVendorAdapter;
	}

	
	/**
	 * Bean encargado de manejar las transacciones de la aplicación, iniciar, cerrar, manejo de errores
	 * Para habilitar esta caracteristicas,  la clase de configuracion debe tener la anotacion @EnableTransactionManagement
	 * 
	 * @param entityManagerFactory : una instancia de un entityManagerFactory
	 * @return 
	 */
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
