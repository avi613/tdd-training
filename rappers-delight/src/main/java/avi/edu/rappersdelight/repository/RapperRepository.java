package avi.edu.rappersdelight.repository;

import avi.edu.rappersdelight.rapper.Rapper;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class RapperRepository {
    private List<Rapper> rappersMock = ImmutableList.of(
            new Rapper("1", "Red Man"),
            new Rapper("2", "Method Man")
    );

    public List<Rapper> getAllRappers() {
        return rappersMock;
    }

    public Rapper getRapperById(String id) {
        return rappersMock.stream()
                .filter(rapper -> id.equals(rapper.getId()))
                .findAny()
                .orElseThrow(() -> new RapperNotFoundException("Rapper with id: " + id + " not found"));
    }
}
