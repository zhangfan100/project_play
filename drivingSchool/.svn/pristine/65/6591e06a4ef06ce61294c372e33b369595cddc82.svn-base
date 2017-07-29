package com.HuiShengTec.base.messageConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.HuiShengTec.utils.Toolkit;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MappingFastJsonHttpMessageConverter extends
		AbstractHttpMessageConverter<Object> {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	// fastjson特性参数
	private SerializerFeature[] serializerFeature;

	public SerializerFeature[] getSerializerFeature() {
		return serializerFeature;
	}
	public void setSerializerFeature(SerializerFeature[] serializerFeature) {
		this.serializerFeature = serializerFeature;
	}

	public MappingFastJsonHttpMessageConverter() {
		super(new MediaType("application", "json", DEFAULT_CHARSET));
	}

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		// JavaType javaType = getJavaType(clazz);
		// return this.objectMapper.canDeserialize(javaType) &&
		// canRead(mediaType);
		return true;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		// return this.objectMapper.canSerialize(clazz) && canWrite(mediaType);
		return true;
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// should not be called, since we override canRead/Write instead
		throw new UnsupportedOperationException();
	}

	@Override
	protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = inputMessage.getBody().read()) != -1) {
			baos.write(i);
		}
		return JSON.parseArray(baos.toString(), clazz);
	}
	/**
	 * 输出方法
	 */
	@Override
	protected void writeInternal(Object o, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		
		String jsonString = null;
		
		//判断返回的类型
		if(o instanceof String){
			jsonString = o.toString();
		}else{
			//获取SESSION中的预设日期输出方式
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getSession();
			Integer mode = (Integer) session.getAttribute("JSONMode");
			//默认输出模式为simpleDateMode
			if(Toolkit.isEmpty(mode)){
				mode=JSONDateOutputMode.simpleDateMode;
			}
			String pattern = null;
			switch (mode) {
				case JSONDateOutputMode.simpleDateMode:pattern=Toolkit.datePattern;break;
				case JSONDateOutputMode.dateTimeMode:pattern=Toolkit.dateTimePattern;break;
			}
			jsonString = JSON.toJSONStringWithDateFormat(o, pattern, serializerFeature);
			//重置日期输出模式为默认输出模式
			if(mode.equals(JSONDateOutputMode.dateTimeMode)){
				JSONDateOutputMode.setJSONDateToDateMode();
			}
		}
		
		//控制台输出将要输出的JSON
		logger.debug("----"+jsonString);
		OutputStream out = outputMessage.getBody();
		out.write(jsonString.getBytes(DEFAULT_CHARSET));
		out.flush();
	}
}
