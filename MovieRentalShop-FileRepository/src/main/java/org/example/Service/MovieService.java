package org.example.Service;

import org.example.Domain.Movie;
import org.example.Domain.ValidatorException;
import org.example.Repository.Repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MovieService {
    private Repository<Long, Movie> repository;

    public MovieService(Repository<Long, Movie> repository) {
        this.repository = repository;
    }
    public void addMovie(Movie movie) throws ValidatorException {
        repository.save(movie);
    }

    public Set<Movie> getAllMovies() {
        Iterable<Movie> students = repository.findAll();
        return StreamSupport.stream(students.spliterator(), false).collect(Collectors.toSet());
    }
    public void updateMovie(Movie movie) throws ValidatorException {
        repository.update(movie);
    }
    public void deleteMovie(Long id) throws ValidatorException {
        repository.delete(id);
    }
}
