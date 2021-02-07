package com.zhss.c2c.social.govern.report.service;

import com.zhss.c2c.social.govern.report.dao.ReportTaskDAO;
import com.zhss.c2c.social.govern.report.domain.ReportTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 举报任务Service实现类
 */
@Service
public class ReportTaskServiceImpl implements ReportTaskService {

    /**
     * 举报任务DAO组件
     */
    @Autowired
    private ReportTaskDAO reportTaskDAO;

    /**
     * 增加举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTask.setVoteResult(ReportTask.VOTE_RESULT_UNKNOWN);
        reportTaskDAO.add(reportTask);
    }

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    @Override
    public ReportTask queryById(Long id) {
        return reportTaskDAO.queryById(id);
    }

}
