package com.reachUp.AStar;

import com.reachUp.AStar.project.entity.City;
import com.reachUp.AStar.project.entity.Path;
import com.reachUp.AStar.project.repository.CityRepository;
import com.reachUp.AStar.project.repository.PathRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AStarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AStarApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner1(
            CityRepository cityStateRepository,
            PathRepository pathStateRepository) {
		return args -> {

			City vidin = new City("Vidin");
			cityStateRepository.save(vidin);
            City montana = new City("Montana");
            cityStateRepository.save(montana);
            City vratsa = new City("Vratsa");
            cityStateRepository.save(vratsa);
            City veliko = new City("Veliko Tarnovo");
            cityStateRepository.save(veliko);
            City ruse = new City("Ruse");
            cityStateRepository.save(ruse);
            City pleven = new City("Pleven");
            cityStateRepository.save(pleven);
            City sofia = new City("Sofia");
            cityStateRepository.save(sofia);
            City pernik = new City("Pernik");
            cityStateRepository.save(pernik);
            City bansko = new City("Bansko");
            cityStateRepository.save(bansko);
            City shumen = new City("Shumen");
            cityStateRepository.save(shumen);
            City dobrich = new City("Dobrich");
            cityStateRepository.save(dobrich);
            City varna = new City("Varna");
            cityStateRepository.save(varna);
            City burgas = new City("Burgas");
            cityStateRepository.save(burgas);
            City haskovo = new City("Haskovo");
            cityStateRepository.save(haskovo);
            City plovdiv = new City("Plovdiv");
            cityStateRepository.save(plovdiv);
            City pazardzhik = new City("Pazardzhik");
            cityStateRepository.save(pazardzhik);
            City blagoevgrad = new City("Blagoevgrad");
            cityStateRepository.save(blagoevgrad);

            Path vidin1 = new Path(
                    "Vidin",
                    "Montana",
                    88
            );
            pathStateRepository.save(vidin1);
            Path vidin2 = new Path(
                    "Vidin",
                    "Ruse",
                    406
            );
            pathStateRepository.save(vidin2);
            Path vidin3 = new Path(
                    "Vidin",
                    "Blagoevgrad",
                    240
            );
            pathStateRepository.save(vidin3);
            Path montana1 = new Path(
                    "Montana",
                    "Vratsa",
                    37
            );
            pathStateRepository.save(montana1);
            Path montana2 = new Path(
                    "Montana",
                    "Pleven",
                    106
            );
            pathStateRepository.save(montana2);
            Path montana3 = new Path(
                    "Montana",
                    "Sofia",
                    117
            );
                pathStateRepository.save(montana3);
                Path montana4 = new Path(
                        "Montana",
                        "Vidin",
                        88
                );
            pathStateRepository.save(montana4);
            Path vratsa1 = new Path(
                    "Vratsa",
                    "Pleven",
                    86
            );
                pathStateRepository.save(vratsa1);
                Path vratsa5 = new Path(
                        "Vratsa",
                        "Montana",
                        37
                );
            pathStateRepository.save(vratsa5);
            Path vratsa2 = new Path(
                    "Vratsa",
                    "Veliko Tarnovo",
                    199
            );
            pathStateRepository.save(vratsa2);
            Path vratsa3 = new Path(
                    "Vratsa",
                    "Sofia",
                    92
            );
            pathStateRepository.save(vratsa3);
            Path vratsa4 = new Path(
                    "Vratsa",
                    "Pazardzhik",
                    174
            );
            pathStateRepository.save(vratsa4);
            Path pleven1 = new Path(
                    "Pleven",
                    "Ruse",
                    111
            );
            pathStateRepository.save(pleven1);
            Path pleven2 = new Path(
                    "Pleven",
                    "Shumen",
                    173
            );
            pathStateRepository.save(pleven2);
            Path pleven3 = new Path(
                    "Pleven",
                    "Sofia",
                    125
            );
            pathStateRepository.save(pleven3);
            Path pleven4 = new Path(
                    "Pleven",
                    "Pazardzhik",
                    210
            );
            pathStateRepository.save(pleven4);
            Path pleven5 = new Path(
                    "Pleven",
                    "Plovdiv",
                    198
            );
            pathStateRepository.save(pleven5);
            Path pleven6 = new Path(
                    "Pleven",
                    "Haskovo",
                    229
            );
            pathStateRepository.save(pleven6);
            Path pleven7 = new Path(
                    "Pleven",
                    "Veliko Tarnovo",
                    99
            );
                pathStateRepository.save(pleven7);
                Path pleven8 = new Path(
                        "Pleven",
                        "Montana",
                        106
                );
            pathStateRepository.save(pleven8);
                Path pleven9 = new Path(
                        "Pleven",
                        "Vratsa",
                        86
                );
                pathStateRepository.save(pleven9);
            Path veliko1 = new Path(
                    "Veliko Tarnovo",
                    "Ruse",
                    86
            );
            pathStateRepository.save(veliko1);
            Path veliko2 = new Path(
                    "Veliko Tarnovo",
                    "Shumen",
                    111
            );
            pathStateRepository.save(veliko2);
            Path veliko3 = new Path(
                    "Veliko Tarnovo",
                    "Sofia",
                    164
            );
            pathStateRepository.save(veliko3);
            Path veliko4 = new Path(
                    "Veliko Tarnovo",
                    "Plovdiv",
                    158
            );
            pathStateRepository.save(veliko4);
            Path veliko5 = new Path(
                    "Veliko Tarnovo",
                    "Haskovo",
                    143
            );
            pathStateRepository.save(veliko5);
            Path veliko6 = new Path(
                    "Veliko Tarnovo",
                    "Sliven",
                    92
            );
            pathStateRepository.save(veliko6);
                Path veliko7 = new Path(
                        "Veliko Tarnovo",
                        "Vratsa",
                        199
                );
                pathStateRepository.save(veliko7);
                Path veliko8 = new Path(
                        "Veliko Tarnovo",
                        "Pleven",
                        99
                );
                pathStateRepository.save(veliko8);
            Path ruse1 = new Path(
                    "Ruse",
                    "Shumen",
                    88
            );
            pathStateRepository.save(ruse1);
            Path ruse2 = new Path(
                    "Ruse",
                    "Dobrich",
                    149
            );
            pathStateRepository.save(ruse2);
            Path ruse3 = new Path(
                    "Ruse",
                    "Sliven",
                    224
            );
            pathStateRepository.save(ruse3);
                Path ruse4 = new Path(
                        "Ruse",
                        "Vidin",
                        406
                );
                pathStateRepository.save(ruse4);
                Path ruse5 = new Path(
                        "Ruse",
                        "Pleven",
                        111
                );
                pathStateRepository.save(ruse5);
                Path ruse6 = new Path(
                        "Ruse",
                        "Veliko Tarnovo",
                        86
                );
                pathStateRepository.save(ruse6);
            Path shumen1 = new Path(
                    "Shumen",
                    "Varna",
                    61
            );
            pathStateRepository.save(shumen1);
            Path shumen2 = new Path(
                    "Shumen",
                    "Dobrich",
                    97
            );
            pathStateRepository.save(shumen2);
            Path shumen3 = new Path(
                    "Shumen",
                    "Plovdiv",
                    204
            );
            pathStateRepository.save(shumen3);
            Path shumen4 = new Path(
                    "Shumen",
                    "Haskovo",
                    189
            );
            pathStateRepository.save(shumen4);
            Path shumen5 = new Path(
                    "Shumen",
                    "Sliven",
                    120
            );
            pathStateRepository.save(shumen5);
            Path shumen6 = new Path(
                    "Shumen",
                    "Burgas",
                    115
            );
            pathStateRepository.save(shumen6);
                Path shumen7 = new Path(
                        "Shumen",
                        "Pleven",
                        173
                );
                pathStateRepository.save(shumen7);
                Path shumen8 = new Path(
                        "Shumen",
                        "Veliko Tarnovo",
                        111
                );
                pathStateRepository.save(shumen8);
                Path shumen9 = new Path(
                        "Shumen",
                        "Ruse",
                        88
                );
                pathStateRepository.save(shumen9);
                Path shumen10 = new Path(
                        "Shumen",
                        "Dobrich",
                        97
                );
                pathStateRepository.save(shumen10);
                Path dobrich1 = new Path(
                        "Dobrich",
                        "Ruse",
                        149
                );
                pathStateRepository.save(dobrich1);
                Path dobrich2 = new Path(
                        "Dobrich",
                        "Shumen",
                        97
                );
                pathStateRepository.save(dobrich2);
                Path dobrich3 = new Path(
                        "Dobrich",
                        "Varna",
                        50
                );
                pathStateRepository.save(dobrich3);
                Path varna1 = new Path(
                        "Varna",
                        "Shumen",
                        61
                );
                pathStateRepository.save(varna1);
                Path varna2 = new Path(
                        "Varna",
                        "Dobrich",
                        50
                );
                pathStateRepository.save(varna2);
                Path varna3 = new Path(
                        "Varna",
                        "Burgas",
                        118
                );
                pathStateRepository.save(varna3);
                Path sofia1 = new Path(
                        "Sofia",
                        "Montana",
                        117
                );
                pathStateRepository.save(sofia1);
                Path sofia2 = new Path(
                        "Sofia",
                        "Vratsa",
                        92
                );
                pathStateRepository.save(sofia2);
                Path sofia3 = new Path(
                        "Sofia",
                        "Pleven",
                        125
                );
                pathStateRepository.save(sofia3);
                Path sofia4 = new Path(
                        "Sofia",
                        "Veliko Tarnovo",
                        164
                );
                pathStateRepository.save(sofia4);
                Path sofia5 = new Path(
                        "Sofia",
                        "Pernik",
                        44
                );
                pathStateRepository.save(sofia5);
                Path sofia6 = new Path(
                        "Sofia",
                        "Bansko",
                        211
                );
                pathStateRepository.save(sofia6);
                Path sofia7 = new Path(
                        "Sofia",
                        "Blagoevgrad",
                        71
                );
                pathStateRepository.save(sofia7);
                Path sofia8 = new Path(
                        "Sofia",
                        "Pazardzhik",
                        76
                );
                pathStateRepository.save(sofia8);
                Path sofia9 = new Path(
                        "Sofia",
                        "Sliven",
                        230
                );
                pathStateRepository.save(sofia9);
                Path pernik1 = new Path(
                        "Pernik",
                        "Sofia",
                        44
                );
                pathStateRepository.save(pernik1);
                Path pernik2 = new Path(
                        "Pernik",
                        "Bansko",
                        93
                );
                pathStateRepository.save(pernik2);
                Path pernik3 = new Path(
                        "Pernik",
                        "Blagoevgrad",
                        49
                );
                pathStateRepository.save(pernik3);
                Path bansko1 = new Path(
                        "Bansko",
                        "Sofia",
                        211
                );
                pathStateRepository.save(bansko1);
                Path bansko2 = new Path(
                        "Bansko",
                        "Pernik",
                        93
                );
                pathStateRepository.save(bansko2);
                Path bansko3 = new Path(
                        "Bansko",
                        "Blagoevgrad",
                        53
                );
                pathStateRepository.save(bansko3);
                Path bansko4 = new Path(
                        "Bansko",
                        "Pazardzhik",
                        114
                );
                pathStateRepository.save(bansko4);
                Path blag1 = new Path(
                        "Blagoevgrad",
                        "Vidin",
                        240
                );
                pathStateRepository.save(blag1);
                Path blag2 = new Path(
                        "Blagoevgrad",
                        "Sofia",
                        71
                );
                pathStateRepository.save(blag2);
                Path blag3 = new Path(
                        "Blagoevgrad",
                        "Pernik",
                        49
                );
                pathStateRepository.save(blag3);
                Path blag4 = new Path(
                        "Blagoevgrad",
                        "Bansko",
                        53
                );
                pathStateRepository.save(blag4);
                Path blag5 = new Path(
                        "Blagoevgrad",
                        "Pazardzhik",
                        153
                );
                pathStateRepository.save(blag5);
            Path pazardzhik1 = new Path(
                    "Pazardzhik",
                    "Vratsa",
                    174
            );
            pathStateRepository.save(pazardzhik1);
            Path pazardzhik2 = new Path(
                    "Pazardzhik",
                    "Pleven",
                    210
            );
            pathStateRepository.save(pazardzhik2);
            Path pazardzhik3 = new Path(
                    "Pazardzhik",
                    "Sofia",
                    76
            );
            pathStateRepository.save(pazardzhik3);
            Path pazardzhik4 = new Path(
                    "Pazardzhik",
                    "Bansko",
                    114
            );
            pathStateRepository.save(pazardzhik4);
            Path pazardzhik5 = new Path(
                    "Pazardzhik",
                    "Blagoevgrad",
                    153
            );
            pathStateRepository.save(pazardzhik5);
            Path pazardzhik6 = new Path(
                    "Pazardzhik",
                    "Plovdiv",
                    40
            );
            pathStateRepository.save(pazardzhik6);
            Path plovdiv1 = new Path(
                    "Plovdiv",
                    "Pleven",
                    198
            );
            pathStateRepository.save(plovdiv1);
            Path plovdiv2 = new Path(
                    "Plovdiv",
                    "Veliko Tarnovo",
                    158
            );
            pathStateRepository.save(plovdiv2);
            Path plovdiv3 = new Path(
                    "Plovdiv",
                    "Shumen",
                    204
            );
            pathStateRepository.save(plovdiv3);
            Path plovdiv4 = new Path(
                    "Plovdiv",
                    "Pazardzhik",
                    40
            );
            pathStateRepository.save(plovdiv4);
            Path plovdiv5 = new Path(
                    "Plovdiv",
                    "Haskovo",
                    67
            );
            pathStateRepository.save(plovdiv5);
            Path plovdiv7 = new Path(
                    "Plovdiv",
                    "Sliven",
                    108
            );
            pathStateRepository.save(plovdiv7);
            Path plovdiv8 = new Path(
                    "Plovdiv",
                    "Burgas",
                    143
            );
            pathStateRepository.save(plovdiv8);
            Path haskovo1 = new Path(
                    "Haskovo",
                    "Pleven",
                    229
            );
            pathStateRepository.save(haskovo1);
            Path haskovo2 = new Path(
                    "Haskovo",
                    "Veliko Tarnovo",
                    143
            );
            pathStateRepository.save(haskovo2);
            Path haskovo3 = new Path(
                    "Haskovo",
                    "Shumen",
                    189
            );
            pathStateRepository.save(haskovo3);
            Path haskovo4 = new Path(
                    "Haskovo",
                    "Plovdiv",
                    67
            );
            pathStateRepository.save(haskovo4);
            Path haskovo5 = new Path(
                    "Haskovo",
                    "Sliven",
                    92
            );
            pathStateRepository.save(haskovo5);
            Path haskovo6 = new Path(
                    "Haskovo",
                    "Burgas",
                    160
            );
            pathStateRepository.save(haskovo6);
            Path sliven1 = new Path(
                    "Sliven",
                    "Veliko Tarnovo",
                    92
            );
            pathStateRepository.save(sliven1);
            Path sliven2 = new Path(
                    "Sliven",
                    "Ruse",
                    224
            );
            pathStateRepository.save(sliven2);
            Path sliven3 = new Path(
                    "Sliven",
                    "Shumen",
                    120
            );
            pathStateRepository.save(sliven3);
            Path sliven4 = new Path(
                    "Sliven",
                    "Sofia",
                    230
            );
            pathStateRepository.save(sliven4);
            Path sliven5 = new Path(
                    "Sliven",
                    "Plovdiv",
                    108
            );
            pathStateRepository.save(sliven5);
            Path sliven6 = new Path(
                    "Sliven",
                    "Haskovo",
                    92
            );
            pathStateRepository.save(sliven6);
            Path sliven7 = new Path(
                    "Sliven",
                    "Burgas",
                    72
            );
            pathStateRepository.save(sliven7);
            Path burgas1 = new Path(
                    "Burgas",
                    "Shumen",
                    115
            );
            pathStateRepository.save(burgas1);
            Path burgas2 = new Path(
                    "Burgas",
                    "Varna",
                    118
            );
            pathStateRepository.save(burgas2);
            Path burgas3 = new Path(
                    "Burgas",
                    "Plovdiv",
                    143
            );
            pathStateRepository.save(burgas3);
            Path burgas4 = new Path(
                    "Burgas",
                    "Haskovo",
                    160
            );
            pathStateRepository.save(burgas4);
            Path burgas5 = new Path(
                    "Burgas",
                    "Sliven",
                    72
            );
            pathStateRepository.save(burgas5);
		};
	}
}
