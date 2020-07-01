package com.legendbois.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fileindex", path="fileindex")
public interface FileRepository extends JpaRepository<FileModel, Integer>{
	
	List<FileModel> findByFname(String fname);
	
	@Query(value = "SELECT * FROM files WHERE content LIKE %?1%;", nativeQuery = true)
	List<FileModel> searchContent(@Param("content") String content);
	
	@Query(value = "SELECT * FROM files WHERE fname LIKE %?1%;", nativeQuery = true)
	List<FileModel> searchFiles(@Param("fname") String fname);

}
