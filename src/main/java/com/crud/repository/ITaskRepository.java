package com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.entity.Task;

@Repository
@Transactional
public interface ITaskRepository extends MongoRepository<Task, String> {

}
