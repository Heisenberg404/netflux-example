package com.heisenberg404.netfluxexample.service;

import com.heisenberg404.netfluxexample.domain.Movie;
import com.heisenberg404.netfluxexample.domain.MovieEvent;
import com.heisenberg404.netfluxexample.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Flux<MovieEvent> events(String movieId) {
        System.out.println("in:" + movieId);
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
            System.out.println("returning:" + new Date());
        }).delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<Movie> getMovieById(String id) {
        return this.movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }
}
