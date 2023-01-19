/**
 * 
 */
package com.hs.core.configurations;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * @author nidhigurani
 *, configurationPolicy = ConfigurationPolicy.REQUIRE
 */
@Component(service = HeadlessSharkConfigurationImpl.class, immediate = true)
@Designate(ocd = HeadlessSharkConfigurationImpl.Configuration.class)
public class HeadlessSharkConfigurationImpl {
	
	private static final String GRAPHQL_ENDPOINT = "/graphql/execute.json/headless-shark";
	
	
	@ObjectClassDefinition(name = "Headless Shark Configurations" )
	public @interface Configuration {
		
		
		@AttributeDefinition(name = "GraphQL endpoint", description = "GraphQL endpoint", type = AttributeType.STRING )
		String getGraphqlEndpoint() default GRAPHQL_ENDPOINT ;
		
	}

	
	private String graphqlEndpoint;
	
	@Activate
	@Modified
	protected void activate(final Configuration config) {
		graphqlEndpoint = config.getGraphqlEndpoint();
	}
	
	public String getGraphqlEndpoint() {
		return graphqlEndpoint;
	}
}
