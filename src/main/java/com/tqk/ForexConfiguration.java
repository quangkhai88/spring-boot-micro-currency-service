package com.tqk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 *
 * @author khaitq on 10 juin 2018
 */

public class ForexConfiguration {

	@Autowired
	IClientConfig clientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig clientConfig) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}


}
