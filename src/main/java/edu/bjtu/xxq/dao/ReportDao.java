package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {

    Report findByName(String name);

    List<Report> findBetweenDate(String from, String to);
}
