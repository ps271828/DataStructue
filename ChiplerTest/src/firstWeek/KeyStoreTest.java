package firstWeek;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Base64.Encoder;

public class KeyStoreTest {

	/**
	 * 下面为生成keyStore命令    需要在jdk的bin目录下执行
	 * keytool -genkey -alias test -keyalg RSA -validity 20000 -keystore test.keystore
	 * @throws KeyStoreException 
	 * @throws Exception 
	 */
	public static void testTrustKeyStore() throws KeyStoreException, Exception {
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		
		FileInputStream fis = new FileInputStream("D:\\test.keystore");
		
		String storePassword = "123456";
		
		"".getBytes();
		
		ks.load(fis, storePassword.toCharArray());
		
		fis.close();
		
		String alais = "test"; 
		
		PrivateKey prk = (PrivateKey) ks.getKey(alais, storePassword.toCharArray());
		
		Certificate c = ks.getCertificate(alais);
		
		PublicKey pk = c.getPublicKey();
		
		encode(pk.getEncoded());
		
		//内部类接口
		TrustedCertificateEntry tf = new KeyStore.TrustedCertificateEntry(c);
		
		Certificate c1 = tf.getTrustedCertificate();
		
		encode(c1.getPublicKey().getEncoded());
		
		PrivateKeyEntry pke = new KeyStore.PrivateKeyEntry(prk, ks.getCertificateChain(alais));
		
        encode(prk.getEncoded());		
	}
	
	public static void encode(byte[] data) {
		Encoder encoder = Base64.getEncoder();
		byte[] b = encoder.encode(data);
		System.out.println(new String(b));
	}
	
	public static void main(String[] args) {
		try {
			testTrustKeyStore();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
