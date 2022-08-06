package com.lp.dispatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lp.dispatch.model.Dispatch;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Integer>{

}
