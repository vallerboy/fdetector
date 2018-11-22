package pl.oskarpolak.fdetector.models.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.fdetector.models.NewsEntity;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Integer> {
    Page<NewsEntity> findAll(Pageable pageable);
}
