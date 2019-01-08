package com.heisenberg404.netfluxexample.repositories;

import com.heisenberg404.netfluxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository  extends ReactiveMongoRepository<Movie, String>{
}
