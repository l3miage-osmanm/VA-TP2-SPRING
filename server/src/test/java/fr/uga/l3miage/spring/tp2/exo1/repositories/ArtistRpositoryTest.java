package fr.uga.l3miage.spring.tp2.exo1.repositories;


import fr.uga.l3miage.exo1.enums.GenreMusical;
import fr.uga.l3miage.spring.tp2.exo1.models.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import java.util.Set;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class ArtistRpositoryTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void countByGenreMusicalEquals(){
        ArtistEntity artistEntity1= ArtistEntity
                .builder()
                .name("mitski")
                .biography("it's me and japanese american pop singer mitski against the world")
                .genreMusical(GenreMusical.CLASSIC)
                .build();
        ArtistEntity artistEntity2= ArtistEntity
                .builder()
                .name("deftones")
                .biography("emos")
                .genreMusical(GenreMusical.RANDB)
                .build();
        artistRepository.save(artistEntity2);
        artistRepository.save(artistEntity1);
        artistRepository.save(artistEntity1);
        artistRepository.save(artistEntity2);
        int rep1=artistRepository.countByGenreMusicalEquals(GenreMusical.CLASSIC);
        int rep2=artistRepository.countByGenreMusicalEquals(GenreMusical.RANDB);
        assertThat(rep1==2);
        assertThat(rep2==2);


    }
}
