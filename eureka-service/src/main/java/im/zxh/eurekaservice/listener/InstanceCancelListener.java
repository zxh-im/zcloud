/**
 * Captain
 * © 2018 Captain copyright，All rights reserved.
 * http://www.sccaptain.com.cn
 * <p>
 * JAVA : 8
 * 文 件 名: InstanceCancelListener
 * 创 建 人: wangtao (wang.tao@sccaptain.com.cn)
 * 创建时间: 2018/9/20 16:26
 * 版　　本: 1.0.0
 * 备　　注:
 * 修订历史:
 */
package im.zxh.eurekaservice.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 服务宕机监听
 */
@Slf4j
@Configuration
public class InstanceCancelListener implements ApplicationListener<EurekaInstanceCanceledEvent> {

  @Override
  public void onApplicationEvent(EurekaInstanceCanceledEvent event) {
    log.info("服务:{}, 挂掉了, serverId:{}",
        event.getAppName(),
        event.getServerId());
  }

}
