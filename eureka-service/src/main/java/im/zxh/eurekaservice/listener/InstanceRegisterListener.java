/**
 * Captain
 * © 2018 Captain copyright，All rights reserved.
 * http://www.sccaptain.com.cn
 * <p>
 * JAVA : 8
 * 文 件 名: InstanceRegisterListener
 * 创 建 人: wangtao (wang.tao@sccaptain.com.cn)
 * 创建时间: 2018/9/20 16:27
 * 版　　本: 1.0.0
 * 备　　注:
 * 修订历史:
 */
package im.zxh.eurekaservice.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 服务注册监听
 */
@Slf4j
@Configuration
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {

  @Override
  public void onApplicationEvent(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
    InstanceInfo instanceInfo = eurekaInstanceRegisteredEvent.getInstanceInfo();
    log.info("服务:{}, 注册成功, ip:{}, port:{}",
        instanceInfo.getAppName(),
        instanceInfo.getIPAddr(),
        instanceInfo.getPort());
  }

}