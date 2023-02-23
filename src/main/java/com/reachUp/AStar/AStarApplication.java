package com.reachUp.AStar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AStarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AStarApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CityStateRepository cityStateRepository) {
//		return args -> {
//			CityState vidin = new CityState("Vidin");
//			cityStateRepository.save(vidin);
//            CityState montana = new CityState("Montana");
//            cityStateRepository.save(montana);
//            CityState vratsa = new CityState("Vratsa");
//            cityStateRepository.save(vratsa);
//            CityState veliko = new CityState("Veliko Tarnovo");
//            cityStateRepository.save(veliko);
//            CityState ruse = new CityState("Ruse");
//            cityStateRepository.save(ruse);
//            CityState pleven = new CityState("Pleven");
//            cityStateRepository.save(pleven);
//            CityState sofia = new CityState("Sofia");
//            cityStateRepository.save(sofia);
//            CityState pernik = new CityState("Pernik");
//            cityStateRepository.save(pernik);
//            CityState bansko = new CityState("Bansko");
//            cityStateRepository.save(bansko);
//            CityState shumen = new CityState("Shumen");
//            cityStateRepository.save(shumen);
//            CityState dobrich = new CityState("Dobrich");
//            cityStateRepository.save(dobrich);
//            CityState varna = new CityState("Varna");
//            cityStateRepository.save(varna);
//            CityState burgas = new CityState("Burgas");
//            cityStateRepository.save(burgas);
//            CityState haskovo = new CityState("Haskovo");
//            cityStateRepository.save(haskovo);
//            CityState plovdiv = new CityState("Plovdiv");
//            cityStateRepository.save(plovdiv);
//            CityState pazardzhik = new CityState("Pazardzhik");
//            cityStateRepository.save(pazardzhik);
//            CityState blagoevgrad = new CityState("Blagoevgrad");
//            cityStateRepository.save(blagoevgrad);
//		};
//	}
}
