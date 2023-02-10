package com.mustread.dataloader.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Repository;

import com.mustread.dataloader.entity.Author;

@Repository
@EnableCassandraRepositories
public interface AuthorRepository extends CassandraRepository<Author, String> {

}
