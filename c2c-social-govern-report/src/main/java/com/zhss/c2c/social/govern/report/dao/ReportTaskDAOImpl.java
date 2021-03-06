package com.zhss.c2c.social.govern.report.dao;

import com.zhss.c2c.social.govern.report.domain.ReportTask;
import com.zhss.c2c.social.govern.report.mapper.ReportTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 举报任务DAO实现类
 */
@Repository
public class ReportTaskDAOImpl implements ReportTaskDAO {


    /**
     * 举报任务Mapper组件
     */
    @Autowired
    private ReportTaskMapper reportTaskMapper;

    /**
     * 增加举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTaskMapper.insert(reportTask);
    }

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    @Override
    public ReportTask queryById(Long id) {
        return reportTaskMapper.selectById(id);
    }

    /**
     * 更新举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void update(ReportTask reportTask) {
        reportTaskMapper.update(reportTask);
    }


    /**
     * 根据id查询举报任务是否结束 true结束 false未结束
     * @param id
     * @return
     */
    @Override
    public boolean getReportResult(long id) {
        long reportResult = reportTaskMapper.getReportResult(id);
        return 1 == reportResult ? true : false;
    }
}
