/**
 * 
 */
package cn.crazychain.sample;

import org.ethereum.facade.EthereumFactory;
import org.springframework.context.annotation.Bean;

import cn.crazychain.sample.PrivateChainSample.PrivateChainConfig;

/**
 * @author yang
 *
 */
public class ContractManageSample extends PrivateChainSample {
	
	
	 public static void main(String[] args) throws Exception {
	        LOG.info("-----------------Starting PrivateChainSample!--------------------");

	        class PrivateConfig extends PrivateChainConfig {
	            @Bean
	            public PrivateChainSample sampleBean() {
	                return new PrivateChainSample();
	            }
	        }

	        // Based on Config class the BasicSample would be created by Spring
	        // and its springInit() method would be called as an entry point
	        EthereumFactory.createEthereum(PrivateConfig.class);
	}

}
