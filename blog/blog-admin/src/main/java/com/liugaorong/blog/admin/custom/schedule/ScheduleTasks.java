package com.liugaorong.blog.admin.custom.schedule;

import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

//  @Autowired
//  private LeaseAgreementService service;

//  @Scheduled(cron = "* * * * * *")
//  public void test() {
//    System.out.println(new Date());
//  }

//  @Scheduled(cron = "0 0 0 * * *")
//  public void checkLeaseStatus() {
//    LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
//    updateWrapper.le(LeaseAgreement::getLeaseEndDate, new Date());
//    updateWrapper.in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING);
//    updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
//    service.update(updateWrapper);
//  }
}
