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

package link.thingscloud.freeswitch.esl;

import link.thingscloud.freeswitch.esl.exception.InboundClientException;
import link.thingscloud.freeswitch.esl.inbound.NettyInboundClient;
import link.thingscloud.freeswitch.esl.inbound.option.InboundClientOption;

/**
 * 保证单例对象
 *
 * @author : <a href="mailto:ant.zhou@aliyun.com">zhouhailin</a>
 */
class InboundClientFactory {

    private InboundClient inboundClient = null;

    private static class InboundClientFactoryInstance {
        private static final InboundClientFactory instance = new InboundClientFactory();
    }

    private InboundClientFactory() {
    }

    static InboundClientFactory getInstance() {
        return InboundClientFactoryInstance.instance;
    }

    synchronized InboundClient newInboundClient(InboundClientOption option) {
        if (inboundClient == null) {
            inboundClient = new NettyInboundClient(option == null ? new InboundClientOption() : option);
            return inboundClient;
        }
        throw new InboundClientException("InboundClient has been created already, instance : [" + inboundClient + "]!");
    }

    InboundClient getInboundClient() {
        if (inboundClient == null) {
            throw new InboundClientException("InboundClient is null, you must be create it first.");
        }
        return inboundClient;
    }

}