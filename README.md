#DesafioCeps
Projeto que envolve serviços REST e uma SinglePage Application construída com Twitter Bootstrap e Angular.JS

	Consulta de CEPs
	Cadastro de Endereços
	Exercício sobre Stream

#O que utilizei?
Foram utilizados as seguintes tecnologias:

	JDK 1.8
	Springboot
	Spring Data JPA
	Spring MVC
	H2
	Junit
	Thymeleaf
	Angular
	JQuery
	Tomcat
	Twitter Bootstrap 3
	nekohtml

#Um pouco mais sobre o projeto
	Projeto com SpringBoot que roda uma aplicação Web através do TomCat.
	Essa aplicação contém serviços REST para a consulta de CEPs válidos e busca por aproximação.
	A Consulta de CEP é utilizada em uma SinglePageApplication construída com Thymeleaf e Angular para o cadastro de endereços.
	O Cadastro de endereços utiliza outros serviços REST para as operações com CRUD.
	Todos os dados foram persistidos usando Repositories JPA, com Spring-Data. Tudo fica salvo no banco de dados H2, também embarcado com o Spring-Boot.

#Testes
	Os testes da Aplicação foram escritos utilizando JUnit.
	A carga incial de CEPs e endereços, tanto para os testes quanto para visualizar em telas está localizada dentro do arquivo data.sql.
	Nos testes também se encontram os métodos que cobrem o exercício 3, sobre Stream

#Como executar o projeto?
	Clone o repositório e execute o comando abaixo:
	$ ./mvnw clean package spring-boot:run

	Se preferir, execute a classe a partir da sua IDE Favorita (ou direto pelo console :( ):
	br.com.felipe.DesafioCepsApplication.java
