package org.lessons.java.fotoalbum.repository;

import java.util.List;

import org.lessons.java.fotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

	List<Photo> findByTitleLike(String title);

	List<Photo> findByTagLike(String tag);

}
