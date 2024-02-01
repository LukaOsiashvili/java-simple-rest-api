package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("From Actor where active = :active and " + "concat(firstName, concat(' ', lastName)) like :searchValue")
    Page<Actor> search(@Param("active") Integer active, @Param("searchValue") String searchValue, Pageable pageable);

}
