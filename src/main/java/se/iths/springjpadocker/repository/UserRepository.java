package se.iths.springjpadocker.repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.springjpadocker.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
