package com.app.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.API.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long> {
	@Query("SELECT i FROM ImageData i WHERE i.pid = :pid")
	Optional<ImageData> findById(@Param("pid") int pid);
}
