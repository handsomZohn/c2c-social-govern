package com.zhss.c2c.social.govern.reviewer.service;

import com.zhss.c2c.social.govern.reviewer.api.ReviewerService;
import com.zhss.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.zhss.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description 评审员service
 *@CreateDate 2021\2\7 0007 13:59
 *@Author z
 *@Version 1.0
 */
@Service(
        version = "1.0.0",
        // 接口类型
        interfaceClass = ReviewerService.class,
        // 集群故障转移策略 单机的时候这个能不能写 我觉得是不能写
        // 2020.02.09 实践证明 单机的时候，写了也无所谓
        cluster = "failfast",
        // 负载均衡算法
        loadbalance = "roundrobin"
)
public class ReviewerServiceImpl implements ReviewerService  {


    /**
     * 评审员处理任务DAO组件
     */
    @Autowired
    private ReviewerTaskStatusDAO reviewerTaskStatusDAO;

    /**
     * 选择评审员
     * @param reportTaskId 举报任务id
     * @return 评审员用户id
     */
    @Override
    public List<Long> selectReviewers(Long reportTaskId) {
        // 模拟通过算法选择一批评审员
        // System.out.println("模拟通过算法选择一批评审员");


        System.out.println("dev环境=====================模拟通过算法选择一批评审员");
        // System.out.println("test环境=====================模拟通过算法选择一批评审员");

        List<Long> reviewerIds = new ArrayList<>();
        reviewerIds.add(1L);
        reviewerIds.add(2L);
        reviewerIds.add(3L);
        reviewerIds.add(4L);
        reviewerIds.add(5L);

        // 把每个评审员要执行的任务录入数据库
        for(Long reviewerId : reviewerIds) {
            ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
            reviewerTaskStatus.setReviewerId(reviewerId);
            reviewerTaskStatus.setReportTaskId(reportTaskId);
            reviewerTaskStatus.setStatus(ReviewerTaskStatus.PROCESSING);
            reviewerTaskStatusDAO.add(reviewerTaskStatus);
        }
        return reviewerIds;
    }

    /**
     * 完成投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     */
    @Override
    public void finishVote(Long reviewerId, Long reportTaskId) {
        ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
        reviewerTaskStatus.setReviewerId(reviewerId);
        reviewerTaskStatus.setReportTaskId(reportTaskId);
        reviewerTaskStatus.setStatus(ReviewerTaskStatus.FINISHED);
        reviewerTaskStatusDAO.update(reviewerTaskStatus);
    }
}
