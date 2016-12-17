package avi.edu.rappersdelight.repository;

import avi.edu.rappersdelight.rapper.Rapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RapperRepositoryTest {
    private RapperRepository rapperRepository = new RapperRepository();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_rapper_by_id() {
        assertThat(rapperRepository.getRapperById("1")).isEqualTo(new Rapper("1", "Red Man"));
    }

    @Test
    public void should_throw_a_rapper_not_found_exception() {
        thrown.expect(RapperNotFoundException.class);
        thrown.expectMessage("Rapper with id: 3 not found");
        rapperRepository.getRapperById("3");
    }
}
