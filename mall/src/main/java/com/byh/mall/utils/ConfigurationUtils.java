package com.byh.mall.utils;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.PropertiesBuilderParameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import java.io.File;


public class ConfigurationUtils
{
	private static <T extends FileBasedConfiguration> FileBasedConfigurationBuilder<T> getConfigurationBuilder(Class<T> t)
	{
		return new FileBasedConfigurationBuilder<T>((Class<T>) t);
	}
	private static PropertiesConfiguration getPropertiesConfiguration(File file){
		PropertiesConfiguration config=null;
		try {
			//文件扫码策略
//			List<FileLocationStrategy> subs = Arrays.asList(
//					new ProvidedURLLocationStrategy(),
//					new FileSystemLocationStrategy(),
//					new ClasspathLocationStrategy());// 此条被应用
//			FileLocationStrategy strategy = new CombinedLocationStrategy(subs);


			FileBasedConfigurationBuilder<PropertiesConfiguration> builder=getConfigurationBuilder(PropertiesConfiguration.class);
			PropertiesBuilderParameters builderParameters=new Parameters().properties();
			builderParameters.setFile(file);
			builderParameters.setEncoding("UTF-8");
			builderParameters.setIncludesAllowed(false);
//			builderParameters.setLocationStrategy(strategy);
			builderParameters.setListDelimiterHandler(new DefaultListDelimiterHandler(','));
			builderParameters.setThrowExceptionOnMissing(true);
			builder.configure(builderParameters);
			builder.setAutoSave(true);
			config=builder.getConfiguration();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return config;
	}

	public static String getValue(String key,File file)
	{
		return getPropertiesConfiguration(file).getString(key);
	}
	public static void setValue(String key,String value,File file)
	{
		getPropertiesConfiguration(file).setProperty(key, value);
	}
}
