package com.app.repo;

import com.app.pojo.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by moslpc on 2016/8/26.
 */
@Repository
public interface UserRepo extends CrudRepository<User, String> {

    @Query("{'name' : ?0}")
    public Iterable<User> searchByName(String name);



}
