package ds.github.taissasantos.model.repository;

import ds.github.taissasantos.model.entity.Telefones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonesRepository  extends JpaRepository<Telefones, Integer> {
}
