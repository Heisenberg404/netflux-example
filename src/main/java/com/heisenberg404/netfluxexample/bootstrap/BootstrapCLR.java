package com.heisenberg404.netfluxexample.bootstrap;

import com.heisenberg404.netfluxexample.domain.Movie;
import com.heisenberg404.netfluxexample.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the lambda", "AEON flux", "Enter the Mono<void>", "Fluxxionator", "Back to the future",
                        "Meet the fluxxes", "Lord of the Fluxxes")
                        .map(title -> new Movie(title))
                        .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
