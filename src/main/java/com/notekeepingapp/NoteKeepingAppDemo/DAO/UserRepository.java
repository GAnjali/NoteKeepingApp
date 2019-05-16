package com.notekeepingapp.NoteKeepingAppDemo.DAO;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value="select * from users u where u.user_name=:username", nativeQuery = true)
    User findByusername(@Param("username") String username);
}
