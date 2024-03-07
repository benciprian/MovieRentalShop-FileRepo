package org.example.Repository;

import org.example.Domain.Movie;
import org.example.Domain.Validator;
import org.example.Domain.ValidatorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieFileRepository extends InMemoryRepository<Long, Movie> {
    private String fileName;

    public MovieFileRepository(Validator<Movie> validator, String fileName) {
        super(validator);
        this.fileName = fileName;

        loadData();
    }

    private void loadData() {
        Path path = Paths.get(fileName);

        try {
            List<String> lines = Files.lines(path).collect(Collectors.toList());

            for (String line : lines) {
                String[] items = line.split(",");

                Long id = Long.valueOf(items[0]);
                String title = items[1];
                int year = Integer.parseInt(items[2]);
                String genre = items[3];
                double rentalPrice = Double.parseDouble(items[4]);

                Movie movie = new Movie(id, title, year, genre, rentalPrice);

                try {
                    super.save(movie);
                } catch (ValidatorException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
