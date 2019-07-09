package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.ReportDao;
import edu.bjtu.xxq.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public Report getOne(String name) {
        return reportDao.findByName(name);
    }

    public List<Report> getBetweenDate(String from, String to) {
        return reportDao.findBetweenDate(from, to);
    }
}
