package com.ravi.assignment.qualibrate.domain.repository;

import com.ravi.assignment.qualibrate.domain.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
