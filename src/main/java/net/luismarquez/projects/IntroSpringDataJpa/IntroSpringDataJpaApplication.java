package net.luismarquez.projects.IntroSpringDataJpa;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner validateDSCommand(DataSource dataSource){
		return args -> {
			System.out.println("\n Probando Conexión y DS\n");
			Connection conn = dataSource.getConnection();
			PreparedStatement pstm = conn.prepareStatement("select * from characters");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String mensaje = rs.getString("id") + " - " + rs.getString("name");
				System.out.println(mensaje);
			}
			System.out.println("\n\n ");
		};
	}

	@Bean
	public CommandLineRunner validateEntityManagerCommand(EntityManager em){
		return args -> {
			System.out.println("\nProbando EntityManagerFactory\n");
			List<Object[]> result = em.createNativeQuery("select * from characters").getResultList();

			result.forEach(each -> {
				String mensaje = each[0] + " - " + each[1];
				System.out.println(mensaje);
			});
			System.out.println("\n\n");

		};
	}

}
