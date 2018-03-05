package com.hfut.study.common.util;


import com.hfut.study.common.exception.BizException;
import com.thoughtworks.xstream.XStream;

/**
 * Created by zhangxin on 2017/8/29.
 */
public class XmlUtils {
	
//	private static Logger log = LoggerFactory.getLogger(study.util.XmlUtils.class);

	public static <T> String toXml(T obj) throws BizException {
		String xml = null;
		try {
			XStream xstream = new XStream();
			xstream.processAnnotations(obj.getClass());
			xml = xstream.toXML(obj);
			xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+System.getProperty("line.separator", "\n")+xml;
		} catch (Exception e) {
			throw new BizException("编码服务器数据错误",e);
		}
//		log.info(xml);
		return xml;
	}

	public static  <T> T toBean(String xmlStr, Class<T> cls) throws BizException {
//		log.info(xmlStr);
		try {
			XStream xstream = new XStream();
			xstream.ignoreUnknownElements();
			xstream.processAnnotations(cls);
			return (T) xstream.fromXML(xmlStr);
		} catch (Exception e) {
			throw new BizException("解析服务器数据错误",e);
		}
	}
}
