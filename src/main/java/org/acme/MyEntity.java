package org.acme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
@Entity
@Table(name = "MyEntity", schema = "dbo")
public class MyEntity extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	@Column(name = "stuff")
	public String stuff;

}
