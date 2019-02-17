package com.example.demo.repository;

import com.example.demo.model.MvtNoteLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MvtNoteLineRepository  extends JpaRepository<MvtNoteLine, Long> {

    @Query("select  m from MvtNoteLine m order by m.produit.name desc")
    List<MvtNoteLine> getLines();
}
