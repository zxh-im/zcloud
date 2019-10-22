/**
 * Captain
 * © 2018 Captain copyright，All rights reserved.
 * http://www.sccaptain.com.cn
 * <p>
 * JAVA : 8
 * 文 件 名: InstanceRenewListener
 * 创 建 人: wangtao (wang.tao@sccaptain.com.cn)
 * 创建时间: 2018/9/20 16:27
 * 版　　本: 1.0.0
 * 备　　注:
 * 修订历史:
 */
package im.zxh.eurekaservice.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 服务心跳检测监听
 */
@Slf4j
@Configuration
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {

  @Override
  public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
    InstanceInfo instanceInfo = event.getInstanceInfo();
    log.info("心跳检测服务:{}, instanceId:{}, http://{}:{}, 更新间隔{}秒(等待{}秒)",
        instanceInfo.getAppName(),
        instanceInfo.getInstanceId(),
        instanceInfo.getIPAddr(),
        instanceInfo.getPort(),
        instanceInfo.getLeaseInfo().getRenewalIntervalInSecs(),
        instanceInfo.getLeaseInfo().getDurationInSecs()
    );
  }

}
