package com.koc.webapp.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MetaParser {
	private MetaParser() {}
	
	public static Map<String, Action> parse(File metaFile) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(metaFile);
		document.getDocumentElement().normalize();
		Map<String, Action> result = new HashMap<>();
		NodeList actions = document.getElementsByTagName("action");
		
		for (int i = 0; i < actions.getLength(); i++) {
			Node actionNode = actions.item(i);
			
			if (actionNode.getNodeType() == Node.ELEMENT_NODE) {
				Element action = (Element) actionNode;
				String url = action.getAttribute("url");
				String methodName = action.getAttribute("method");
				
				Action entry = new Action();
				
				entry.setActionClassName(action.getAttribute("class"));
				entry.setMethodName(methodName);
				
				NodeList childNodes = action.getChildNodes();
				
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node resultNode = childNodes.item(j);
					if (resultNode.getNodeType() == Node.ELEMENT_NODE) {
						String type = ((Element) resultNode).getAttribute("type");
						if ("success".equals(type)) {
							String payloadKey = ((Element) resultNode).getAttribute("payload-key");
							entry.setPayloadKey(payloadKey);
							entry.setSuccessFile(((Element) resultNode).getTextContent());
						}else {
							entry.setErrorFile(((Element) resultNode).getTextContent());
						}
					}
				}
				
				result.put(url, entry);
			}
		}
		return result;
	}
}
