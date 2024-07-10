package com.mark.marker_api.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    @Query("select new com.mark.marker_api.domain.MarkDTO(b.id, b.title, b.url, b.createdAt) from Mark b")
    Page<MarkDTO> findMarks(Pageable pageable);

    @Query("""
            select new com.mark.marker_api.domain.MarkDTO(b.id, b.title, b.url, b.createdAt) from Mark b
            where lower(b.title) like lower(concat('%', :query, '%'))
            """)
    Page<MarkDTO> searchMarks(String query, Pageable pageable);

    //Todo : find out why this is not working.
    Page<MarkDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);



}
