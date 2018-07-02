/**
 * 
 */
package cn.crazychain.sample;

import static org.ethereum.crypto.HashUtil.sha3;

import org.ethereum.config.SystemProperties;
import org.ethereum.crypto.ECKey;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.samples.TestNetSample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.typesafe.config.ConfigFactory;

/**
 * 测试私有链或者联盟链
 * @author yang
 *
 */
public class PrivateChainSample {
	
	 public static final Logger LOG = LoggerFactory.getLogger(PrivateChainSample.class);
	
	
    protected abstract static class PrivateChainConfig {
     
        public abstract PrivateChainSample sampleBean();

        @Bean
        public SystemProperties systemProperties() {
            SystemProperties props = new SystemProperties();
            //props.overrideParams(ConfigFactory.parseString(config.replaceAll("'", "\"")));
            props.overrideParams(ConfigFactory.load(PrivateChainSample.class.getClassLoader(), "regular-node"));
            return props;
        }
    }

  

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
