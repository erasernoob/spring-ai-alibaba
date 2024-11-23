package com.alibaba.cloud.ai;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.alibaba.cloud.ai.properties.DingTalkProperties;
import com.alibaba.cloud.ai.service.CustomRobotSendMessageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

/**
 * @author YunLong
 */
@EnableConfigurationProperties(DingTalkProperties.class)
@ConditionalOnProperty(prefix = "spring.ai.alibaba.plugin.dingtalk", name = "enabled", havingValue = "true")
public class DingTalkConfig {

    @Bean
    @ConditionalOnMissingBean
    @Description("Send group chat messages using a custom robot")
    public CustomRobotSendMessageService customRobotSendMessageFunction(DingTalkProperties dingTalkProperties) {
        return new CustomRobotSendMessageService(dingTalkProperties);
    }
}
