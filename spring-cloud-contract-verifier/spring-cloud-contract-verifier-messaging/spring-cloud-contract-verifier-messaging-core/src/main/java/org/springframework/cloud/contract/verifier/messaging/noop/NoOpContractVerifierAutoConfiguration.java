/*
 *  Copyright 2013-2016 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.springframework.cloud.contract.verifier.messaging.noop;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.contract.verifier.messaging.ContractVerifierMessageExchange;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author Marcin Grzejszczak
 */
@Configuration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
public class NoOpContractVerifierAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public ContractVerifierMessageExchange<?> contractVerifierMessageExchange() {
		return new NoOpContractVerifierMessaging();
	}

	@Bean
	@ConditionalOnMissingBean
	public ContractVerifierMessaging<?> contractVerifierMessaging(
			ContractVerifierMessageExchange<Object> exchange) {
		return new ContractVerifierMessaging<Object>(exchange);
	}

}
