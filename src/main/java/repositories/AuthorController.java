package repositories;

import encapsulations.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorController extends JpaRepository<Author, UUID> {
}
