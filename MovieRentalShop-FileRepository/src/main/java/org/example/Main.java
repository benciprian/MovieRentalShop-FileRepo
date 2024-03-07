package org.example;

import org.example.Domain.Movie;
import org.example.Domain.MovieValidator;
import org.example.Domain.Validator;
import org.example.Domain.ValidatorException;
import org.example.Repository.MovieFileRepository;
import org.example.Repository.Repository;
import org.example.Service.MovieService;
import org.example.UI.Console;




public class Main {

     public static void main(String[] args) throws ValidatorException {

         //in memory repository
         // Validator<Movie> movieValidator = new MovieValidator();
         // Repository<Long, Movie> movieRepository = new InMemoryRepository<>(movieValidator);
         // MovieService movieService = new MovieService(movieRepository);
         // Console console = new Console(movieService);
         // movieRepository.save(new Movie(1l,"Hotel_Transilvania",2001,"Action",23));
         // movieRepository.save(new Movie(2l,"Laguna_Albastra",2012,"Adventure",32));
         // console.run();

         String filePath = "./data/movies";

         Validator<Movie> movieValidator = new MovieValidator();
         Repository<Long, Movie> movieRepository = new MovieFileRepository(movieValidator, filePath);
         MovieService movieService = new MovieService(movieRepository);
         Console console = new Console(movieService);
         console.run();

         System.out.println("bye");
     }

}