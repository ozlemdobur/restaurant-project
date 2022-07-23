package com.restaurant.repository;

import com.restaurant.model.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Modifying
    @Transactional
    @Query(value = "update Menu set image_Path=:image_Path where id=:id")
    public void uploadPictureToMenu(@Param("image_Path") String image_Path, @Param("id") Long id);

    List<Menu> findByMenuTypeLike(String menuType);

}
