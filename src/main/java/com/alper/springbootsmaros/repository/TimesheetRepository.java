package com.alper.springbootsmaros.repository;

import com.alper.springbootsmaros.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet , Long> {

    List<Timesheet> findAll();


    @Query("select p from Timesheet p where p.userID =?1")
    List<Timesheet> findAllByUserId(Long userId);
    
    @Query("SELECT u FROM Timesheet u where MONTH(u.timesheetdate) = ?1")
    List<Timesheet> findAllByMonth(Integer month);
}
