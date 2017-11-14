package org.main;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private int employee_id;
	@Column(name = "EMP_NAME", length = 155)
	private String employee_name;
	@Column(name = "EMAIL_ID", nullable = false)
	private String employee_email;
	private long phone;
	@Column(name = "BASIC_SALARY")
	private int basic_salary;
	@Column(name = "DA")
	private int dearness_allowance;
	@Column(name = "HRA")
	private int house_rent_allowance;
	@Column(name = "PF")
	private int provident_fund;
	@Column(name = "TA")
	private int total_allowance;
	@Transient
	private int net_salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String employee_name, String employee_email, long phone, int basic_salary,
			int dearness_allowance, int house_rent_allowance, int provident_fund, int total_allowance, int net_salary) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
		this.phone = phone;
		this.basic_salary = basic_salary;
		this.dearness_allowance = dearness_allowance;
		this.house_rent_allowance = house_rent_allowance;
		this.provident_fund = provident_fund;
		this.total_allowance = total_allowance;
		this.net_salary = net_salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(int basic_salary) {
		this.basic_salary = basic_salary;
	}

	public int getDearness_allowance() {
		return dearness_allowance;
	}

	public void setDearness_allowance(int dearness_allowance) {
		this.dearness_allowance = dearness_allowance;
	}

	public int getHouse_rent_allowance() {
		return house_rent_allowance;
	}

	public void setHouse_rent_allowance(int house_rent_allowance) {
		this.house_rent_allowance = house_rent_allowance;
	}

	public int getProvident_fund() {
		return provident_fund;
	}

	public void setProvident_fund(int provident_fund) {
		this.provident_fund = provident_fund;
	}

	public int getTotal_allowance() {
		return total_allowance;
	}

	public void setTotal_allowance(int total_allowance) {
		this.total_allowance = total_allowance;
	}

	public int getNet_salary() {
		return net_salary;
	}

	public void setNet_salary(int net_salary) {
		this.net_salary = net_salary;
	}

};

package org.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Id");
		int employee_id = Integer.valueOf(bf.readLine());
		System.out.println("Enter Name");
		String employee_name = bf.readLine();
		System.out.println("Enter Email");
		String employee_email = bf.readLine();
		System.out.println("Enter phone number");
		long phone = Long.valueOf(bf.readLine());
		int net_salary = 0;
		System.out.println("Enter basic salary");
		int basic_salary = Integer.valueOf(bf.readLine());
		System.out.println("Enter dearness allowance");
		int dearness_allowance = Integer.valueOf(bf.readLine());
		System.out.println("Enter house rent allowance");
		int house_rent_allowance = Integer.valueOf(bf.readLine());
		System.out.println("Enter provident fund");
		int provident_fund = Integer.valueOf(bf.readLine());
		System.out.println("total allowance");
		int total_allowance = Integer.valueOf(bf.readLine());
		Employee employee = new Employee(employee_id, employee_name, employee_email, phone, basic_salary,
				dearness_allowance, house_rent_allowance, provident_fund, total_allowance, net_salary);
		System.out.println(employee.getEmployee_id());
		System.out.println(employee.getEmployee_name());
		System.out.println(employee.getEmployee_email());
		System.out.println(employee.getPhone());
		System.out.println(employee.getBasic_salary());
		System.out.println(employee.getDearness_allowance());
		System.out.println(employee.getHouse_rent_allowance());
		System.out.println(employee.getProvident_fund());
		System.out.println(employee.getTotal_allowance());
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

}

<?xml version='1.0' encoding='utf-8'?>
<!-- ~ Hibernate, Relational Persistence for Idiomatic Java ~ ~ License: 
	GNU Lesser General Public License (LGPL), version 2.1 or later. ~ See the 
	lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>. -->
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

	<session-factory>

		<!-- Database connection settings -->
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:3306/sample</property>
		<property name="connection.username">root</property>
		<property name="connection.password"></property>

		<!-- JDBC connection pool (use the built-in) -->
		<property name="connection.pool_size">10</property>

		<!-- SQL dialect -->
		<property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>

		<!-- Disable the second-level cache -->
		<property name="cache.provider_class">org.hibernate.cache.internal.NoCacheProvider</property>

		<!-- Echo all executed SQL to stdout -->
		<property name="show_sql">true</property>

		<!-- Drop and re-create the database schema on startup -->
		<property name="hbm2ddl.auto">create</property>

		<!-- Names the annotated entity class -->
		<mapping class="org.main.Employee" />

	</session-factory>

</hibernate-configuration>