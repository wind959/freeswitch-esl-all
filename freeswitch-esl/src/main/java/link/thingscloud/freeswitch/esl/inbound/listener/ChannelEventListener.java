/*
 * Copyright 2019 ThingsCloud Link.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package link.thingscloud.freeswitch.esl.inbound.listener;

import link.thingscloud.freeswitch.esl.inbound.handler.InboundChannelHandler;
import link.thingscloud.freeswitch.esl.transport.event.EslEvent;

/**
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
public interface ChannelEventListener {

    void onChannelActive(String remoteAddr, InboundChannelHandler inboundChannelHandler);

    void onChannelClosed(String remoteAddr);

    void handleAuthRequest(String remoteAddr, InboundChannelHandler inboundChannelHandler);

    void handleEslEvent(String remoteAddr, EslEvent event);

    void handleDisconnectNotice(String remoteAddr);
}