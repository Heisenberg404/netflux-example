package com.heisenberg404.netfluxexample.service;

import com.heisenberg404.netfluxexample.domain.Movie;
import com.heisenberg404.netfluxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    /**
     *
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     *
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     *
     * @return
     */
    Flux<Movie> getAllMovies();
}
