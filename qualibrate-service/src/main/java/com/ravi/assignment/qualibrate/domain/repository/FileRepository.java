package com.ravi.assignment.qualibrate.domain.repository;

import com.ravi.assignment.qualibrate.domain.File;
import com.ravi.assignment.qualibrate.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends PagingAndSortingRepository<File, Long> {

    @Modifying
    @Query("delete from File f where f.user.id=:userId")
    void deleteByUser(Long userId);

    List<File> findByUser(User user);
}
